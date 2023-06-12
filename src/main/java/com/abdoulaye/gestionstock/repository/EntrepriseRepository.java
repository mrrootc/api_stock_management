package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
