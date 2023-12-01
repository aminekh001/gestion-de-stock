package com.medAmine.gestion.de.stock.validator;

import com.medAmine.gestion.de.stock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;





// api consumed by multiple client
// that's why I  did the validation in the backend











public class ClientValidator {

    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner le Mail du client");
            errors.add("Veuillez renseigner le numero de telephone du client");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("Veuillez renseigner le Mail du client");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez renseigner le numero de telephone du client");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }
}
