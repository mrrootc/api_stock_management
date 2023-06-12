package com.abdoulaye.gestionstock.validator;

import com.abdoulaye.gestionstock.dto.ArticleDto;
import com.abdoulaye.gestionstock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veuillez renseigner le champ nom du client");
            errors.add("Veuillez renseigner le champ prenom du client");
            errors.add("Veuillez renseigner le champ  du client");
            errors.add("Veuillez renseigner le numero  du client");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getNom()))
        {
            errors.add("Veuillez renseigner le nom du client");
        }
        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez renseigner le prenom du client");
        }
        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l'email  du client");
        }
        if(!StringUtils.hasLength(dto.getPhone())){
            errors.add("Veuillez renseigner le numero  du client");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));

        return errors;
    }
}
