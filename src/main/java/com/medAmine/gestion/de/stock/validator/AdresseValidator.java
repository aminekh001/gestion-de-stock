package com.medAmine.gestion.de.stock.validator;

import com.medAmine.gestion.de.stock.dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {
    public static List<String> validate(AdresseDto adresseDto){
        List<String> errors =new ArrayList<>();

        if (adresseDto==null){
            if (adresseDto == null) {
                errors.add("Veuillez renseigner l'adresse 1'");
                errors.add("Veuillez renseigner la ville'");
                errors.add("Veuillez renseigner le pays'");

                return errors;
        }

        if (adresseDto.getAdress1()==null || !StringUtils.hasLength(adresseDto.getAdress1())){
            errors.add("Veuillez renseigner l'adresse 1");


        }
        if (!StringUtils.hasLength(adresseDto.getVille())){
        errors.add("Veuillez renseigner la ville");
        }
        if(!StringUtils.hasLength(adresseDto.getPays())){
            errors.add("Veuillez renseigner le pays'");
        }
        }
    return errors;
    }
}
