package com.medAmine.gestion.de.stock.services.impl;
import com.medAmine.gestion.de.stock.Repo.UtilisateurRepo;
import com.medAmine.gestion.de.stock.dto.UtilisateurDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Utilisateur;
import com.medAmine.gestion.de.stock.services.UtilisateurServices;
import com.medAmine.gestion.de.stock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServicesImpl implements UtilisateurServices {
    public final UtilisateurRepo utilisateurRepo;

    public UtilisateurServicesImpl(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }


    @Override
    public UtilisateurDto save( UtilisateurDto utilisateurDto) {
        List<String> err= UtilisateurValidator.validate(utilisateurDto);
        if (!err.isEmpty()){
            log.error("utilisateur n'est pas valide",utilisateurDto);
            throw new InvalidEntityException("utilisateur n'est pas valide", ErrorCode.UTILISATEUR_NOT_VALID,err);
        }
        return UtilisateurDto.fromEntity(utilisateurRepo.save(UtilisateurDto.toEntity(utilisateurDto)));
    }

    @Override
    public UtilisateurDto findById(Long id) {
        if (id==null){
            log.error("id est null");
            return null;

        }
        Optional<Utilisateur> utilisateur = utilisateurRepo.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get()))
                .orElseThrow(()-> new EntityNotFoundException
                        ("aucun utilisateur avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepo.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id==null){
            log.error("id est nul");
        }else{
            utilisateurRepo.deleteById(id);
        }

    }
}
