package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.FournisserDto;

import java.util.List;

public interface FournisserService {

    FournisserDto save(FournisserDto fournisserDto);
    FournisserDto findById(Long id);
    List<FournisserDto> findAll();

    void deleteById(Long id);
}
