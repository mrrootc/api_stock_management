package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
}
