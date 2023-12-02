package com.medAmine.gestion.de.stock.controller;

import com.medAmine.gestion.de.stock.dto.FournisserDto;
import com.medAmine.gestion.de.stock.services.impl.FournisserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisser")
public class FournisserController {
    private final FournisserServiceImpl fournisserService;

    @Autowired
    public FournisserController(FournisserServiceImpl fournisserService) {
        this.fournisserService = fournisserService;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FournisserDto> save(@RequestBody FournisserDto fournisserDto){
        return new ResponseEntity<>(fournisserService.save(fournisserDto), HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FournisserDto> findById(@PathVariable("id") Long id){

        FournisserDto fournisser = fournisserService.findById(id);
        return new ResponseEntity<>(fournisser,HttpStatus.OK);
    }


    @GetMapping("/findAll")
    ResponseEntity<List<FournisserDto>> findAll(){
        List<FournisserDto> fournisserDtos =fournisserService.findAll();
        return new ResponseEntity<>(fournisserDtos,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        fournisserService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
