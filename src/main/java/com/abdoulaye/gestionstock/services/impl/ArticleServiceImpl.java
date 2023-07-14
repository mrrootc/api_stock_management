package com.abdoulaye.gestionstock.services.impl;


import com.abdoulaye.gestionstock.dto.ArticleDto;
import com.abdoulaye.gestionstock.dto.LigneCommandeClientDto;
import com.abdoulaye.gestionstock.dto.LigneCommandeFournisseurDto;
import com.abdoulaye.gestionstock.dto.LigneVenteDto;
import com.abdoulaye.gestionstock.exception.EntityNotFoundException;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.exception.InvalidOperationException;
import com.abdoulaye.gestionstock.model.LigneCommandeClient;
import com.abdoulaye.gestionstock.model.LigneCommandeFournisseur;
import com.abdoulaye.gestionstock.model.LigneVente;
import com.abdoulaye.gestionstock.repository.ArticleRepository;
import com.abdoulaye.gestionstock.repository.LigneCommandeClientRepository;
import com.abdoulaye.gestionstock.repository.LigneCommandeFournisseurRepository;
import com.abdoulaye.gestionstock.repository.LigneVenteRepository;
import com.abdoulaye.gestionstock.services.ArticleService;
import com.abdoulaye.gestionstock.validator.ArticleValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;
  private final LigneVenteRepository venteRepository;
  private final LigneCommandeFournisseurRepository commandeFournisseurRepository;
  private final LigneCommandeClientRepository commandeClientRepository;



  @Override
  public ArticleDto save(ArticleDto dto) {
    List<String> errors = ArticleValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
    }

    return ArticleDto.fromEntity(
        articleRepository.save(
            ArticleDto.toEntity(dto)
        )
    );
  }


  @Override
  public ArticleDto findById(Integer id) {
    if (id == null) {
      log.error("Article ID is null");
      return null;
    }

    return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
        new EntityNotFoundException(
            "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.ARTICLE_NOT_FOUND)
    );
  }



 // @Override
//  public ArticleDto findByCodeArticle(String codeArticle) {
//    if (!StringUtils.hasLength(codeArticle)) {
//      log.error("Article CODE is null");
//      return null;
//    }
//
//    return articleRepository.findArticleByCodeArticle(Integer.valueOf(codeArticle))
//        .map(ArticleDto::fromEntity)
//        .orElseThrow(() ->
//            new EntityNotFoundException(
//                "Aucun article avec le CODE = " + codeArticle + " n' ete trouve dans la BDD",
//                ErrorCodes.ARTICLE_NOT_FOUND)
//        );
//  }


  @Override
  public List<ArticleDto> findAll() {
    return articleRepository.findAll().stream()
        .map(ArticleDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
    return venteRepository.findAllByArticleId(idArticle).stream()
        .map(LigneVenteDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
    return commandeClientRepository.findAllByArticleId(idArticle).stream()
        .map(LigneCommandeClientDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
    return commandeFournisseurRepository.findAllByArticleId(idArticle).stream()
        .map(LigneCommandeFournisseurDto::fromEntity)
        .collect(Collectors.toList());
  }



//  @Override
//  public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
//    return articleRepository.findArticleByCodeArticle(idCategory).stream()
//        .map(ArticleDto::fromEntity)
//        .collect(Collectors.toList());
//  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Article ID is null");
      return;
    }
    List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
    if (!ligneCommandeClients.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }
    List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
    if (!ligneCommandeFournisseurs.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
          ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }
    List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
    if (!ligneVentes.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
          ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }
    articleRepository.deleteById(id);
  }
}
