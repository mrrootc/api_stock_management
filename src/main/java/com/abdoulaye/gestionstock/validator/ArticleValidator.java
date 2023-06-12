package com.abdoulaye.gestionstock.validator;

import com.abdoulaye.gestionstock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veuillez renseigner le code de l'article !");
            errors.add("Veuillez renseigner la description de l'article !");
            errors.add("Veuillez renseigner le prix unitaire de l'article !");
            errors.add("Veuillez renseigner la date de fabrication de l'article !");
            errors.add("Veuillez renseigner la date d'expiration de l'article !");
            errors.add("Veuillez selectionner une categorie");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getCodeArticle())){
            errors.add("Veuillez renseigner le code de l'article !");
        }

        if(!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuillez renseigner la description de l'article !");
        }
        if(dto.getPrixUnitaire() == null){
            errors.add("Veuillez renseigner le prix unitaire de l'article !");
        }

        if(dto.getDateFab() == null){
            errors.add("Veuillez renseigner la date de fabrication de l'article !");
        }

        if(dto.getDateExp() == null){
            errors.add("Veuillez renseigner la date d'expiration de l'article !");
        }
        else if(dto.getDateExp().isAfter(dto.getDateFab())){
            errors.add("Desolé mais la date d'expiration ne pas est inferieur a la date d'expiration");
        }

        if(dto.getCategorie() == null){
            errors.add("Veuillez selectionner une categorie");
        }


        return errors;
    }
}
