package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.CommandeClientDto;
import com.medAmine.gestion.de.stock.dto.CommandeFournisserDto;

public interface CommandeFournisserServices {

    CommandeFournisserDto save(CommandeFournisserDto commandeFournisserDto);

    CommandeFournisserDto findById(Long id);
    CommandeFournisserDto findByCode(String code);

    void  deleteById(Long id);
}
