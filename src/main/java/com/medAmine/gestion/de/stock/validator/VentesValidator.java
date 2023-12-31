package com.medAmine.gestion.de.stock.validator;

import com.medAmine.gestion.de.stock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;




// api consumed by multiple client
// that's why I  did the validation in the backend






public class VentesValidator {
    public static List<String> validate(VentesDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.getDateVente() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }

        return errors;
    }
}
