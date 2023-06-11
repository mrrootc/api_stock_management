package com.abdoulaye.gestionstock.validator;

import com.abdoulaye.gestionstock.models.Utilisateur;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(Utilisateur utilisateur){
        List<String> errors = new ArrayList<>();
        if(StringUtils.hasLength(utilisateur.getNom())){
            errors.add("Veuillez renseigner le nom svp");
        }

        return errors;
    }
}
