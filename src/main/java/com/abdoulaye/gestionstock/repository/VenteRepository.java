package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Long> {
}
