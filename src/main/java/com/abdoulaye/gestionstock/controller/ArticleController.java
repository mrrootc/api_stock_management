package com.abdoulaye.gestionstock.controller;

import com.abdoulaye.gestionstock.controller.api.ArticleApi;
import com.abdoulaye.gestionstock.dto.ArticleDto;
import com.abdoulaye.gestionstock.dto.LigneCommandeClientDto;
import com.abdoulaye.gestionstock.dto.LigneCommandeFournisseurDto;
import com.abdoulaye.gestionstock.dto.LigneVenteDto;
import com.abdoulaye.gestionstock.services.ArticleService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

  private final ArticleService articleService;
  @Override
  public ArticleDto save(ArticleDto dto) {
    return articleService.save(dto);
  }

  @Override
  public ArticleDto findById(Integer id) {
    return articleService.findById(id);
  }


//  @Override
//  public ArticleDto findByCodeArticle(String codeArticle) {
//    return articleService.findByCodeArticle(codeArticle);
//  }

  @Override
  public List<ArticleDto> findAll() {
    return articleService.findAll();
  }

  @Override
  public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
    return articleService.findHistoriqueVentes(idArticle);
  }

  @Override
  public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
    return articleService.findHistoriaueCommandeClient(idArticle);
  }

  @Override
  public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
    return articleService.findHistoriqueCommandeFournisseur(idArticle);
  }

//  @Override
//  public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
//    return articleService.findAllArticleByIdCategory(idCategory);
//  }

  @Override
  public void delete(Integer id) {
    articleService.delete(id);
  }
}
