package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.ClientDto;

import java.util.List;

public interface ClientServices {
    ClientDto Save(ClientDto clientDto);
    List<ClientDto> findAll();
    ClientDto findById(Long id);
    void deleteById(Long id);

}
