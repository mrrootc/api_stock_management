package com.abdoulaye.gestionstock.controller;


import com.abdoulaye.gestionstock.controller.api.UtilisateurApi;
import com.abdoulaye.gestionstock.dto.ChangerMotDePasseUtilisateurDto;
import com.abdoulaye.gestionstock.dto.UtilisateurDto;
import com.abdoulaye.gestionstock.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateurApi {

  private final UtilisateurService utilisateurService;

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    return utilisateurService.save(dto);
  }

  @Override
  public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
    return utilisateurService.changerMotDePasse(dto);
  }

  @Override
  public UtilisateurDto findById(Integer id) {
    return utilisateurService.findById(id);
  }

  @Override
  public UtilisateurDto findByEmail(String email) {
    return utilisateurService.findByEmail(email);
  }

  @Override
  public List<UtilisateurDto> findAll() {
    return utilisateurService.findAll();
  }

  @Override
  public void delete(Integer id) {
    utilisateurService.delete(id);
  }
}
