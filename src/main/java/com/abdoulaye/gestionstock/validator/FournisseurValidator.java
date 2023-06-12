package com.abdoulaye.gestionstock.validator;

import com.abdoulaye.gestionstock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veuillez renseigner le champ nom du fournisseur");
            errors.add("Veuillez renseigner le champ prenom du fournisseur");
            errors.add("Veuillez renseigner le champ  du fournisseur");
            errors.add("Veuillez renseigner le numero  du fournisseur");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom()))
        {
            errors.add("Veuillez renseigner le nom du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez renseigner le prenom du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l'email  du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getPhone())){
            errors.add("Veuillez renseigner le numero  du fournisseur");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));

        return errors;
    }
}
