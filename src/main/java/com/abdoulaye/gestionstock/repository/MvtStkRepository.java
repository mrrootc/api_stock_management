package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface MvtStkRepository extends JpaRepository<MouvementStock, Integer> {

  @Query("select sum(m.quantite) from MouvementStock m where m.article.id = :idArticle")
  BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

  List<MouvementStock> findAllByArticleId(Integer idArticle);

}
