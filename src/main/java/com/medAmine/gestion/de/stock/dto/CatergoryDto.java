package com.medAmine.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medAmine.gestion.de.stock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatergoryDto {
    private Long id;
    private String code;
    private  String designation;
    @JsonIgnore
    private List<ArticleDto> articles;

    public static CatergoryDto fromEntity(Category  category){
        if (category==null){
            // exp to do
            return null;
        }
        return CatergoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();


    }
    public static Category toEntity(CatergoryDto catergoryDto){
        if (catergoryDto ==null) {
            // exp to do
            return null;
        }
        Category category = new Category();
        category.setId(catergoryDto.getId());
        category.setCode(catergoryDto.getCode());
        category.setDesignation(catergoryDto.getDesignation());
        return category;
    }

}
