package com.medAmine.gestion.de.stock.validator;

import com.medAmine.gestion.de.stock.dto.CommandeFournisserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;




// api consumed by multiple client
// that's why I  did the validation in the backend







public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisserDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (dto.getFournisser() == null || dto.getFournisser().getId() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }

        return errors;
    }

}
