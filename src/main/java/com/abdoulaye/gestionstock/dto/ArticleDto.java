package com.abdoulaye.gestionstock.dto;




import com.abdoulaye.gestionstock.models.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Builder
@Data
public class ArticleDto {
    private Long id;
    private String codeArticle;
    private BigDecimal prixUnitaire;
    private String description;
    private String image;
    private Instant dateFab;
    private Instant dateExp;
    private CategorieDto categorie;

    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .description(article.getDescription())
                .image(article.getImage())
                .prixUnitaire(article.getPrixUnitaire())
                .dateFab(article.getDateFab())
                .dateExp(article.getDateExp())
                .categorie(CategorieDto.fromEntity(article.getCategorie()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDescription(articleDto.getDescription());
        article.setPrixUnitaire(articleDto.getPrixUnitaire());
        article.setImage(articleDto.getImage());
        article.setDateFab(articleDto.getDateFab());
        article.setDateExp(articleDto.getDateExp());
        article.setCategorie(CategorieDto.toEntity(articleDto.getCategorie()));
        return article;
    }
}
