package com.abdoulaye.gestionstock.services;

import com.abdoulaye.gestionstock.dto.ChangerMotDePasseUtilisateurDto;
import com.abdoulaye.gestionstock.dto.UtilisateurDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UtilisateurService {

  UtilisateurDto save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  List<UtilisateurDto> findAll();

  void delete(Integer id);

  UtilisateurDto findByEmail(String email);

  UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
