package com.medAmine.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medAmine.gestion.de.stock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatrgoryDto {
    private Long id;
    private String code;
    private  String designation;
    @JsonIgnore
    private List<ArticleDto> articles;

    public static CatrgoryDto  fromEntity(Category  category){
        if (category==null){
            // exp to do
            return null;
        }
        return CatrgoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();


    }
    public static Category toEntity(CatrgoryDto catrgoryDto){
        if (catrgoryDto==null) {
            // exp to do
            return null;
        }
        Category category = new Category();
        category.setId(catrgoryDto.getId());
        category.setCode(catrgoryDto.getCode());
        category.setDesignation(catrgoryDto.getDesignation());
        return category;
    }

}
