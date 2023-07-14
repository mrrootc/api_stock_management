package com.abdoulaye.gestionstock.repository;


import com.abdoulaye.gestionstock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentesRepository extends JpaRepository<Vente, Integer> {

  Optional<Vente> findVentesByCode(String code);
}
