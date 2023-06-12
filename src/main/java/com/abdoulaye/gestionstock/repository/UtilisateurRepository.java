package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
