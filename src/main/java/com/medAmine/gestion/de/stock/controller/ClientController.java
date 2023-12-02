package com.medAmine.gestion.de.stock.controller;

import com.medAmine.gestion.de.stock.dto.ClientDto;
import com.medAmine.gestion.de.stock.services.impl.ClientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/client")

public class ClientController {
    private final ClientServicesImpl clientServices;


    @Autowired
    public ClientController(ClientServicesImpl clientServices) {
        this.clientServices = clientServices;
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientServices.Save(clientDto), HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable("id") Long id){

        ClientDto client = clientServices.findById(id);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    ResponseEntity<List<ClientDto>> findAll(){
        List<ClientDto> clientDtos =clientServices.findAll();
        return new ResponseEntity<>(clientDtos,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        clientServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
