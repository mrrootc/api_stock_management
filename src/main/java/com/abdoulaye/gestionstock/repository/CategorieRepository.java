package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Integer> {

  Optional<Categorie> findCategoryByCode(String code);

}
