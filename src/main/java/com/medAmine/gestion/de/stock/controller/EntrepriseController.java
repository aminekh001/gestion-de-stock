package com.medAmine.gestion.de.stock.controller;


import com.medAmine.gestion.de.stock.dto.EntrepriseDto;
import com.medAmine.gestion.de.stock.services.impl.EntrepriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entreprise")
public class EntrepriseController {
    private final EntrepriseServiceImpl entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseServiceImpl entrepriseService) {
        this.entrepriseService = entrepriseService;
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntrepriseDto> save(@RequestBody EntrepriseDto entrepriseDto){
        return new ResponseEntity<>(entrepriseService.save(entrepriseDto), HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EntrepriseDto> findById(@PathVariable("id") Long id){

        EntrepriseDto entreprise = entrepriseService.findById(id);
        return new ResponseEntity<>(entreprise,HttpStatus.OK);
    }


    @GetMapping("/findAll")
    ResponseEntity<List<EntrepriseDto>> findAll(){
        List<EntrepriseDto> entrepriseDtos =entrepriseService.findAll();
        return new ResponseEntity<>(entrepriseDtos,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        entrepriseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
