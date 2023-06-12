package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
