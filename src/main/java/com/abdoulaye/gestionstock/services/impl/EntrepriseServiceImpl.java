package com.abdoulaye.gestionstock.services.impl;

import com.abdoulaye.gestionstock.dto.EntrepriseDto;
import com.abdoulaye.gestionstock.dto.RoleDto;
import com.abdoulaye.gestionstock.dto.UtilisateurDto;
import com.abdoulaye.gestionstock.exception.EntityNotFoundException;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.repository.EntrepriseRepository;
import com.abdoulaye.gestionstock.repository.RolesRepository;
import com.abdoulaye.gestionstock.services.EntrepriseService;
import com.abdoulaye.gestionstock.services.UtilisateurService;
import com.abdoulaye.gestionstock.validator.EntrepriseValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
@RequiredArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {

  private final EntrepriseRepository entrepriseRepository;
  private final   UtilisateurService utilisateurService;
  private final RolesRepository rolesRepository;


  @Override
  public EntrepriseDto save(EntrepriseDto dto) {
    List<String> errors = EntrepriseValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Entreprise is not valid {}", dto);
      throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
    }
    EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
        entrepriseRepository.save(EntrepriseDto.toEntity(dto))
    );

    UtilisateurDto utilisateur = fromEntreprise(savedEntreprise);

    UtilisateurDto savedUser = utilisateurService.save(utilisateur);

    RoleDto rolesDto = RoleDto.builder()
        .nomRole("ADMIN")
        .utilisateur(savedUser)
        .build();

    rolesRepository.save(RoleDto.toEntity(rolesDto));

    return  savedEntreprise;
  }

  private UtilisateurDto fromEntreprise(EntrepriseDto dto) {
    return UtilisateurDto.builder()
        .adresse(dto.getAdresse())
        .nom(dto.getNom())
        .prenom(dto.getCodeFiscal())
        .email(dto.getEmail())
        .motDePasse(generateRandomPassword())
        .entreprise(dto)
        .dateDeNaissance(Instant.now())
        .image(dto.getImage())
        .build();
  }

  private String generateRandomPassword() {
    return "MisterRoot@#$77$";
  }

  @Override
  public EntrepriseDto findById(Integer id) {
    if (id == null) {
      log.error("Entreprise ID est null");
      return null;
    }
    return entrepriseRepository.findById(id)
        .map(EntrepriseDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune entreprise avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
  }

  @Override
  public List<EntrepriseDto> findAll() {
    return entrepriseRepository.findAll().stream()
        .map(EntrepriseDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Entreprise ID est null");
      return;
    }
    entrepriseRepository.deleteById(id);
  }
}
