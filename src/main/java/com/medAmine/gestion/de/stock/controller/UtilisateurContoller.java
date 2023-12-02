package com.medAmine.gestion.de.stock.controller;


import com.medAmine.gestion.de.stock.dto.UtilisateurDto;
import com.medAmine.gestion.de.stock.services.impl.UtilisateurServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/utilisateur")
public class UtilisateurContoller {
    private final UtilisateurServicesImpl utilisateurServices;

    @Autowired
    public UtilisateurContoller(UtilisateurServicesImpl utilisateurServices) {
        this.utilisateurServices = utilisateurServices;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto utilisateurDto){
        return new ResponseEntity<>(utilisateurServices.save(utilisateurDto), HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UtilisateurDto> findById(@PathVariable("id") Long id){

        UtilisateurDto user = utilisateurServices.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }



    @GetMapping("/findAll")
    ResponseEntity<List<UtilisateurDto>> findAll(){
        List<UtilisateurDto> users =utilisateurServices.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        utilisateurServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
