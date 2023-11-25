package com.medAmine.gestion.de.stock.services;

import com.medAmine.gestion.de.stock.dto.ArticleDto;

import java.util.List;

public interface ArticleServices {
    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Long id);
    ArticleDto findByCode(String code);
    List<ArticleDto> findAll();
    void deleteById(Long id);
}
