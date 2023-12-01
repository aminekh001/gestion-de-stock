package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.ArticleRepo;
import com.medAmine.gestion.de.stock.Repo.LigneVenteRepo;
import com.medAmine.gestion.de.stock.Repo.VentesRepo;
import com.medAmine.gestion.de.stock.dto.LigneVenteDto;
import com.medAmine.gestion.de.stock.dto.VentesDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Article;
import com.medAmine.gestion.de.stock.model.LigneVente;
import com.medAmine.gestion.de.stock.model.Ventes;
import com.medAmine.gestion.de.stock.services.VentsServices;
import com.medAmine.gestion.de.stock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VentsServicesImpl implements VentsServices {
    private final VentesRepo ventesRepo;
    private final ArticleRepo articleRepo;
    public final LigneVenteRepo ligneVenteRepo;


    @Autowired
    public VentsServicesImpl(VentesRepo ventesRepo, ArticleRepo articleRepo, LigneVenteRepo ligneVenteRepo) {
        this.ventesRepo = ventesRepo;
        this.articleRepo = articleRepo;
        this.ligneVenteRepo = ligneVenteRepo;
    }


    @Override
    public VentesDto save(VentesDto ventesDto) {
         List<String> venteValide= new ArrayList<>();
         venteValide = VentesValidator.validate(ventesDto);


         if (!venteValide.isEmpty()){
             log.error("vent n'est pas valide");
             throw new InvalidEntityException("vente n'est pas valide ", ErrorCode.VENTE_NOT_VALID,venteValide);

         }



         List<String> checkArticle=new ArrayList<>();
         ventesDto.getLigneVentes().forEach(ligneVenteDto1 -> {
             if (ligneVenteDto1!=null){
            Optional<Article> articleVerif = articleRepo.findById(ligneVenteDto1.getArticle().getId());
            if (articleVerif.isEmpty()){
                checkArticle.add("aucun article avec l'id"+ligneVenteDto1.getArticle().getId());

            }
             }else {
                 checkArticle.add("Impossible d'enregister une commande avec un aticle NULL");
             }
         });



         if (!checkArticle.isEmpty()){
             log.warn("article don't exist ");
             throw new InvalidEntityException("aucun article dans la BDD",ErrorCode.ARTICLE_NOT_FOUND,checkArticle);
         }


         Ventes saveVente = ventesRepo.save(VentesDto.toEntity(ventesDto));
         ventesDto.getLigneVentes().forEach(ligVent->{
             LigneVente ligneVente1 =  LigneVenteDto.toEntity(ligVent);
             ligneVente1.setVente(saveVente);
           ligneVenteRepo.save(ligneVente1);
         });

        return VentesDto.fromEntity(saveVente);
    }

    @Override
    public VentesDto findById(Long id) {

        Optional<Ventes> findVente = ventesRepo.findById(id);
        return Optional.of(VentesDto.fromEntity(findVente.get()))
                .orElseThrow(()->new EntityNotFoundException("aucun vente avec l'id"+id,ErrorCode.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCode(String code) {

        Optional<Ventes> findVente = ventesRepo.findByCode(code);
        return Optional.of(VentesDto.fromEntity(findVente.get()))
                .orElseThrow(()->new EntityNotFoundException("aucun vente avec le code"+code,ErrorCode.VENTE_NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
        ventesRepo.deleteById(id);

    }
}
