package com.abdoulaye.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategorieDto {
    private int id;
    private int codeCategorie;
    private String description;
    private List<ArticleDto> article;
}
