package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.FournisserRepo;
import com.medAmine.gestion.de.stock.dto.FournisserDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Fournisser;
import com.medAmine.gestion.de.stock.services.FournisserService;
import com.medAmine.gestion.de.stock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisserServiceImpl implements FournisserService {
    public final FournisserRepo fournisserRepo;

    public FournisserServiceImpl(FournisserRepo fournisserRepo) {
        this.fournisserRepo = fournisserRepo;
    }


    @Override
    public FournisserDto save(FournisserDto fournisserDto) {
         List<String> err = FournisseurValidator.validate(fournisserDto);
         if (!err.isEmpty()){
             log.error("fournisser n'est pas valide",fournisserDto);
             throw new InvalidEntityException("fournisser n'est pas valide ", ErrorCode.FOURNISSEUR_NOT_VALID,err);
         }else {
             return FournisserDto.fromEntity(fournisserRepo.save(FournisserDto.toEntity(fournisserDto)));
         }
    }

    @Override
    public FournisserDto findById(Long id) {
        if (id==null){
            log.error("id est null");

            return null;
        }
        Optional<Fournisser> fournisser= fournisserRepo.findById(id);

        return Optional.of(FournisserDto.fromEntity(fournisser.get()))
                .orElseThrow(()->new EntityNotFoundException("aucun article avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.FOURNISSEUR_NOT_FOUND)) ;

    }

    @Override
    public List<FournisserDto> findAll() {
        return fournisserRepo.findAll().stream().map(FournisserDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void deleteById(Long id) {
        fournisserRepo.deleteById(id);


    }
}
