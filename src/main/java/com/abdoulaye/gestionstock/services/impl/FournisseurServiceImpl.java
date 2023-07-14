package com.abdoulaye.gestionstock.services.impl;

import com.abdoulaye.gestionstock.dto.FournisseurDto;
import com.abdoulaye.gestionstock.exception.EntityNotFoundException;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.exception.InvalidOperationException;
import com.abdoulaye.gestionstock.model.CommandeClient;
import com.abdoulaye.gestionstock.repository.CommandeFournisseurRepository;
import com.abdoulaye.gestionstock.repository.FournisseurRepository;
import com.abdoulaye.gestionstock.services.FournisseurService;
import com.abdoulaye.gestionstock.validator.FournisseurValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {

  private final FournisseurRepository fournisseurRepository;
  private final CommandeFournisseurRepository commandeFournisseurRepository;


  @Override
  public FournisseurDto save(FournisseurDto dto) {
    List<String> errors = FournisseurValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Fournisseur n'est pas valide {}", dto);
      throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
    }

    return FournisseurDto.fromEntity(
        fournisseurRepository.save(
            FournisseurDto.toEntity(dto)
        )
    );
  }

  @Override
  public FournisseurDto findById(Integer id) {
    if (id == null) {
      log.error("Fournisseur ID est null");
      return null;
    }
    return fournisseurRepository.findById(id)
        .map(FournisseurDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun fournisseur avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
  }

  @Override
  public List<FournisseurDto> findAll() {
    return fournisseurRepository.findAll().stream()
        .map(FournisseurDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Fournisseur ID est null");
      return;
    }
    List<CommandeClient> commandeFournisseur = commandeFournisseurRepository.findAllByFournisseurId(id);
    if (!commandeFournisseur.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un fournisseur qui a deja des commandes",
          ErrorCodes.FOURNISSEUR_ALREADY_IN_USE);
    }
    fournisseurRepository.deleteById(id);
  }
}
