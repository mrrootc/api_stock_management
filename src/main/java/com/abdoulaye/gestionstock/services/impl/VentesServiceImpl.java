package com.abdoulaye.gestionstock.services.impl;


import com.abdoulaye.gestionstock.dto.ArticleDto;
import com.abdoulaye.gestionstock.dto.LigneVenteDto;
import com.abdoulaye.gestionstock.dto.MouvementStockDto;
import com.abdoulaye.gestionstock.dto.VenteDto;
import com.abdoulaye.gestionstock.exception.EntityNotFoundException;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.exception.InvalidOperationException;
import com.abdoulaye.gestionstock.model.*;
import com.abdoulaye.gestionstock.repository.ArticleRepository;
import com.abdoulaye.gestionstock.repository.LigneVenteRepository;
import com.abdoulaye.gestionstock.repository.VentesRepository;
import com.abdoulaye.gestionstock.services.MouvementStockService;
import com.abdoulaye.gestionstock.services.VentesService;
import com.abdoulaye.gestionstock.validator.VenteValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class VentesServiceImpl implements VentesService {

  private final ArticleRepository articleRepository;
  private final VentesRepository ventesRepository;
  private final LigneVenteRepository ligneVenteRepository;
  private  MouvementStockService mvtStkService;


  @Override
  public VenteDto save(VenteDto dto) {
    List<String> errors = VenteValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ventes n'est pas valide");
      throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
    }

    List<String> articleErrors = new ArrayList<>();

    dto.getLigneVentes().forEach(ligneVenteDto -> {
      Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
      if (article.isEmpty()) {
        articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'a ete trouve dans la BDD");
      }
    });

    if (!articleErrors.isEmpty()) {
      log.error("un ou plusieurs article n'ont pas été trouvé dans la DB, {}", errors);
      throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
    }

    Vente savedVentes = ventesRepository.save(VenteDto.toEntity(dto));

    dto.getLigneVentes().forEach(ligneVenteDto -> {
      LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
      ligneVente.setVente(savedVentes);
      ligneVenteRepository.save(ligneVente);
      updateMvtStk(ligneVente);
    });

    return VenteDto.fromEntity(savedVentes);
  }

  @Override
  public VenteDto findById(Integer id) {
    if (id == null) {
      log.error("Ventes ID is NULL");
      return null;
    }
    return ventesRepository.findById(id)
        .map(VenteDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
  }

  @Override
  public VenteDto findByCode(String code) {
    if (!StringUtils.hasLength(code)) {
      log.error("Vente CODE is NULL");
      return null;
    }
    return ventesRepository.findVentesByCode(code)
        .map(VenteDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune vente client n'a ete trouve avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
        ));
  }

  @Override
  public List<VenteDto> findAll() {
    return ventesRepository.findAll().stream()
        .map(VenteDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Vente ID is NULL");
      return;
    }
    List<LigneVente> ligneVentes = ligneVenteRepository.findAllByVenteId(id);
    if (!ligneVentes.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer une vente ...",
          ErrorCodes.VENTE_ALREADY_IN_USE);
    }
    ventesRepository.deleteById(id);
  }

  private void updateMvtStk(LigneVente lig) {
    MouvementStockDto mouvementStockDto = com.abdoulaye.gestionstock.dto.MouvementStockDto.builder()
        .article(ArticleDto.fromEntity(lig.getArticle()))
        .dateMvt(Instant.now())
        .typeMvt(TypeMouvementStock.SORTIE)
        .sourceMvt(SourceMouvementStock.VENTE)
        .quantite(lig.getQuantite())
        .idEntreprise(lig.getIdEntreprise())
        .build();
    mvtStkService.sortieStock(mouvementStockDto);
  }
}
