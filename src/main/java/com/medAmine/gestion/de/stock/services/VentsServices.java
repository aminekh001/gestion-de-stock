package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.VentesDto;

public interface VentsServices {

    VentesDto save(VentesDto ventesDto);
    VentesDto findById(Long id);
    VentesDto findByCode(String code);
    void deleteById(Long id);
}
