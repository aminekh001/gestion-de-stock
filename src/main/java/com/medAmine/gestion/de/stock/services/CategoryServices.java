package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.CatergoryDto;
import java.util.List;

public interface CategoryServices  {

    CatergoryDto save(CatergoryDto catergoryDto);
    CatergoryDto findById(Long id);
    CatergoryDto findByCode(String code);
    List<CatergoryDto> findAll();
    void deleteById(Long id);

}
