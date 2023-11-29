package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseServices {
    EntrepriseDto findById(Long id);

    List<EntrepriseDto> findAll();
    EntrepriseDto save(EntrepriseDto entrepriseDto);

    void deleteById(Long id);

}
