package com.abdoulaye.gestionstock.services;

import com.abdoulaye.gestionstock.dto.ArticleDto;
import com.abdoulaye.gestionstock.dto.LigneCommandeClientDto;
import com.abdoulaye.gestionstock.dto.LigneCommandeFournisseurDto;
import com.abdoulaye.gestionstock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

  ArticleDto save(ArticleDto dto);

  ArticleDto findById(Integer id);

//  ArticleDto findByCodeArticle(String codeArticle);


  List<ArticleDto> findAll();

  List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

  List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

 // List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

  void delete(Integer id);

}
