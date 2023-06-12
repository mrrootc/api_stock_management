package com.abdoulaye.gestionstock.validator;

import com.abdoulaye.gestionstock.dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {
    public static List<String>  validate(AdresseDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Le champ Adresse 1 est obligatoire");
            errors.add("Le champ ville est obligatoire");
            errors.add("Le champ Code postale est obligatoire");

            return errors;
        }

        if(!StringUtils.hasLength(dto.getAdresse1())){
            errors.add("Le champ Adresse 1 est obligatoire");
        }
        if(!StringUtils.hasLength(dto.getVille())){
            errors.add("Le champ ville est obligatoire");
        }
        if(!StringUtils.hasLength(dto.getCodePostal())){
            errors.add("Le champ Code postale est obligatoire");
        }

        return errors;
    }
}
