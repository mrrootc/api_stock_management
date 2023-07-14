package com.abdoulaye.gestionstock.repository;


import com.abdoulaye.gestionstock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
