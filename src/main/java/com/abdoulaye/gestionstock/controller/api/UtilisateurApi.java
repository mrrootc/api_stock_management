package com.abdoulaye.gestionstock.controller.api;


import com.abdoulaye.gestionstock.dto.ChangerMotDePasseUtilisateurDto;
import com.abdoulaye.gestionstock.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abdoulaye.gestionstock.utils.Constants.UTILISATEUR_ENDPOINT;

@Api("utilisateurs")
public interface UtilisateurApi {

  @PostMapping(UTILISATEUR_ENDPOINT + "/create")
  UtilisateurDto save(@RequestBody UtilisateurDto dto);

  @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
  UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

  @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
  UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

  @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
  UtilisateurDto findByEmail(@PathVariable("email") String email);

  @GetMapping(UTILISATEUR_ENDPOINT + "/all")
  List<UtilisateurDto> findAll();

  @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
  void delete(@PathVariable("idUtilisateur") Integer id);

}
