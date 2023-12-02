package com.medAmine.gestion.de.stock.controller;


import com.medAmine.gestion.de.stock.dto.CatergoryDto;
import com.medAmine.gestion.de.stock.services.impl.CategoryServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    private final CategoryServicesImpl categoryServices;

    @Autowired
    public CategoryController(CategoryServicesImpl categoryServices) {
        this.categoryServices = categoryServices;
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CatergoryDto> save(@RequestBody CatergoryDto catergoryDto){
        return new ResponseEntity<>(categoryServices.save(catergoryDto), HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CatergoryDto> findById(@PathVariable("id") Long id){

        CatergoryDto category = categoryServices.findById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("/findBycode/{code}")
    public ResponseEntity<CatergoryDto> findByCode(@PathVariable String code){
        CatergoryDto category = categoryServices.findByCode(code);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    ResponseEntity<List<CatergoryDto>> findAll(){
        List<CatergoryDto> catergoryDtos =categoryServices.findAll();
        return new ResponseEntity<>(catergoryDtos,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        categoryServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

