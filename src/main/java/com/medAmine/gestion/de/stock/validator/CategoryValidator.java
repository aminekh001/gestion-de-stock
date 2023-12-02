package com.medAmine.gestion.de.stock.validator;

import com.medAmine.gestion.de.stock.dto.CatergoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;




// api consumed by multiple client
// that's why I  did the validation in the backend




public class CategoryValidator {
    public static List<String> validate(CatergoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }

}
