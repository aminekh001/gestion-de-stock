package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurServices {

    UtilisateurDto save( UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Long id);

    List<UtilisateurDto> findAll();

    void deleteById(Long id);

}
