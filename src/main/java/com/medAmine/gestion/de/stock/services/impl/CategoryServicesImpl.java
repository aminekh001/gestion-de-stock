package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.CategoryRepo;
import com.medAmine.gestion.de.stock.dto.CatergoryDto;
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
    public CatergoryDto save(CatergoryDto catergoryDto) {
        List<String> errers= CategoryValidator.validate(catergoryDto);
         if (errers.isEmpty()){
             log.error("Category n'est pas valide");
             throw new InvalidEntityException("category n'est pas valide", ErrorCode.CATEGORY_NOT_VALID);
         }else {
             return CatergoryDto.fromEntity(categoryRepo.save(catergoryDto.toEntity(catergoryDto)));
         }


    }

    @Override
    public CatergoryDto findById(Long id) {
        if (id==null){
            log.error("category id est null");
            return null;
        }

        Optional<Category> category = categoryRepo.findById(id);
        return Optional.of(CatergoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException("aucun category avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.CATEGORY_NOT_FOUND )) ;
    }

    @Override
    public CatergoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("code est null ");
            return null;
        }
        Optional<Category> category = categoryRepo.findByCode(code);

        return Optional.of(CatergoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException( "aucun Category avec le code "+ code +"n'est trouve dans la base de donne",ErrorCode.CATEGORY_NOT_FOUND)) ;


    }

    @Override
    public List<CatergoryDto> findAll() {

        return categoryRepo.findAll().stream().map(CatergoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}
