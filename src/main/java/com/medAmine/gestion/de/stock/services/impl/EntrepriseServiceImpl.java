package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.EntrepriseRepo;

import com.medAmine.gestion.de.stock.dto.EntrepriseDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Entreprise;
import com.medAmine.gestion.de.stock.services.EntrepriseServices;
import com.medAmine.gestion.de.stock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class EntrepriseServiceImpl implements EntrepriseServices {
    public  final EntrepriseRepo entrepriseRepo;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepo entrepriseRepo) {
        this.entrepriseRepo = entrepriseRepo;
    }




    @Override
    public EntrepriseDto findById( Long id) {
        if (id == null){
            log.error("entreprise id est null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepo.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get()))
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Entreprise avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {

        return entrepriseRepo.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
         List<String> err = EntrepriseValidator.validate(entrepriseDto);
         if (!err.isEmpty()){
             log.error("entreprise n'est pas valide");
             throw new InvalidEntityException("entreprise n'est pas valide",ErrorCode.ENTREPRISE_NOT_VALID);
         }

         else {
             return EntrepriseDto.fromEntity(entrepriseRepo.save(EntrepriseDto.toEntity(entrepriseDto)));
         }
    }

    @Override
    public void deleteById(Long id) {
        if (id==null){
            log.error("id Null");


        }else {
            entrepriseRepo.deleteById(id);
        }


    }
}

