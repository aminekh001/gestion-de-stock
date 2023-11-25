package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.ArticleRepo;
import com.medAmine.gestion.de.stock.Repo.CategoryRepo;
import com.medAmine.gestion.de.stock.dto.CatrgoryDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Category;
import com.medAmine.gestion.de.stock.services.CategoryServices;
import com.medAmine.gestion.de.stock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServicesImpl implements CategoryServices {
    public final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServicesImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CatrgoryDto save(CatrgoryDto catrgoryDto) {
        List<String> errers= CategoryValidator.validate(catrgoryDto);
         if (errers.isEmpty()){
             log.error("Category n'est pas valide");
             throw new InvalidEntityException("category n'est pas valide", ErrorCode.CATEGORY_NOT_VALID);
         }else {
             return CatrgoryDto.fromEntity(categoryRepo.save(catrgoryDto.toEntity(catrgoryDto)));
         }


    }

    @Override
    public CatrgoryDto findById(Long id) {
        if (id==null){
            log.error("category id est null");
            return null;
        }

        Optional<Category> category = categoryRepo.findById(id);
        return Optional.of(CatrgoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException("aucun category avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.CATEGORY_NOT_FOUND )) ;
    }

    @Override
    public CatrgoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("code est null ");
            return null;
        }
        Optional<Category> category = categoryRepo.findByCode(code);

        return Optional.of(CatrgoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException( "aucun Category avec le code "+ code +"n'est trouve dans la base de donne",ErrorCode.CATEGORY_NOT_FOUND)) ;


    }

    @Override
    public List<CatrgoryDto> findAll() {

        return categoryRepo.findAll().stream().map(CatrgoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}
