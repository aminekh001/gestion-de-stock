package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.CommandeClientDto;

public interface CommandeClientServices {
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto findById(Long id);
    CommandeClientDto findByCode(String code);
    void deleteById(Long id);

}
