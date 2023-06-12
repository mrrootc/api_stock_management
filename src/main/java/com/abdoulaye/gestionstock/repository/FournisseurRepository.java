package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
