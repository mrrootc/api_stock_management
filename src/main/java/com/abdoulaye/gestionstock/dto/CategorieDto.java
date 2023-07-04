package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Categorie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategorieDto {
    private int id;
    private String codeCategorie;
    private String description;
    private Integer idEntreprise;
    @JsonIgnore
    private List<ArticleDto> article;
    public static CategorieDto fromEntity(Categorie categorie){
        if(categorie == null){
            return null;
            //TODO trow an exception
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .codeCategorie(categorie.getCodeCategorie())
                .description(categorie.getDescription())
                .idEntreprise(categorie.getIdEntreprise())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto == null){
            return null;

        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCodeCategorie(categorieDto.getCodeCategorie());
        categorie.setDescription(categorieDto.getDescription());
        categorie.setIdEntreprise(categorieDto.getIdEntreprise());

        return categorie;

    }
}
