package com.abdoulaye.gestionstock.validator;

import com.abdoulaye.gestionstock.dto.UtilisateurDto;
import com.abdoulaye.gestionstock.models.Utilisateur;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateur){
        List<String> errors = new ArrayList<>();
        if(utilisateur == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
            return errors;
        }

        if(!StringUtils.hasLength(utilisateur.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateur.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateur.getMotDePasse())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        if(utilisateur.getDateDeNaissance() == null){
            errors.add("Veuillez renseigner la date de naissace de l'utilisateur");
        }

        errors.addAll(AdresseValidator.validate(utilisateur.getAdresse()));



        return errors;
    }
}
