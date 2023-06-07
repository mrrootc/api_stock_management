package com.abdoulaye.gestionstock.dto;



import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Builder
@Data
public class ArticleDto {
    private int id;
    private int codeArticle;
    private String designation;
    private BigDecimal prixUnitaire;
    private String description;
    private String image;
    private Instant dateFab;
    private Instant dateExp;
    private CategorieDto categorieDto;
}
