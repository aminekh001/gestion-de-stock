package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.CatrgoryDto;
import java.util.List;

public interface CategoryServices  {

    CatrgoryDto save(CatrgoryDto catrgoryDto);
    CatrgoryDto findById(Long id);
    CatrgoryDto findByCode(String code);
    List<CatrgoryDto> findAll();
    void deleteById(Long id);

}
