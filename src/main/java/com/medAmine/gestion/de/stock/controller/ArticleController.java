package com.medAmine.gestion.de.stock.controller;


import com.medAmine.gestion.de.stock.dto.ArticleDto;
import com.medAmine.gestion.de.stock.services.impl.ArticleServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
@Slf4j
public class ArticleController {
    private final ArticleServicesImpl articleServices;

    @Autowired
    public ArticleController(ArticleServicesImpl articleServices) {
        this.articleServices = articleServices;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticleDto> save(@RequestBody  ArticleDto articleDto){
        return new ResponseEntity<>(articleServices.save(articleDto), HttpStatus.CREATED);

    }

    @GetMapping("/find/{idArticle}")
    public ResponseEntity<ArticleDto> findById(@PathVariable("idArticle") Long id){

        ArticleDto article = articleServices.findById(id);
        return new ResponseEntity<>(article,HttpStatus.OK);
    }

    @GetMapping("/findBycode/{code}")
    public ResponseEntity<ArticleDto> findByCode(@PathVariable String code){
        ArticleDto article = articleServices.findByCodeArticle(code);
        return new ResponseEntity<>(article,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    ResponseEntity<List<ArticleDto>> findAll(){
        List<ArticleDto> articleDtos=articleServices.findAll();
        return new ResponseEntity<>(articleDtos,HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        articleServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
