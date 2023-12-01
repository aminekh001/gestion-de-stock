package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.*;
import com.medAmine.gestion.de.stock.dto.CommandeFournisserDto;
import com.medAmine.gestion.de.stock.dto.LigneCommandeFournisserDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Article;
import com.medAmine.gestion.de.stock.model.CommandeFournisser;
import com.medAmine.gestion.de.stock.model.Fournisser;
import com.medAmine.gestion.de.stock.model.LigneCommandeFournisser;
import com.medAmine.gestion.de.stock.services.CommandeFournisserServices;
import com.medAmine.gestion.de.stock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CommandeFournisserServicesImpl implements CommandeFournisserServices {

    private final FournisserRepo fournisserRepo;
    private final CommandeFournisserRepo commandeFournisserRepo;
    private final ArticleRepo articleRepo;
    private final LigneCommandeFournisserRepo ligneCommandeFournisserRepo;

    @Autowired
    public CommandeFournisserServicesImpl(FournisserRepo fournisserRepo, CommandeFournisserRepo commandeFournisserRepo, ArticleRepo articleRepo, LigneCommandeFournisserRepo ligneCommandeFournisserRepo) {
        this.fournisserRepo = fournisserRepo;
        this.commandeFournisserRepo = commandeFournisserRepo;
        this.articleRepo = articleRepo;
        this.ligneCommandeFournisserRepo = ligneCommandeFournisserRepo;
    }


    @Override
    public CommandeFournisserDto save(CommandeFournisserDto commandeFournisserDto) {
        List<String> cmdFORValide = new ArrayList<>();
        cmdFORValide = CommandeFournisseurValidator.validate(commandeFournisserDto);
        if (!cmdFORValide.isEmpty()) {
            log.error("commande fournisseur n'est pas valide ", commandeFournisserDto);
            throw new InvalidEntityException("commande Fournisseur n'est pas valide ", ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID, cmdFORValide);
        }


        Optional<Fournisser> fourChek = fournisserRepo.findById(commandeFournisserDto.getFournisser().getId());

        if (fourChek.isEmpty()) {
            log.warn("fournisseur with ID {} was not found in the DB", commandeFournisserDto.getFournisser().getId());

            throw new EntityNotFoundException("aucun fournisseur avec l'id" + commandeFournisserDto.getFournisser().getId(), ErrorCode.FOURNISSEUR_NOT_FOUND);
        }


        List<String> articleVerif = new ArrayList<>();
        if (commandeFournisserDto.getLigneCommandeFournissers()!=null){

        commandeFournisserDto.getLigneCommandeFournissers().forEach(listArticle -> {
            if (listArticle.getArticle()!=null) {
                Optional<Article> articleChek = articleRepo.findById(listArticle.getArticle().getId());
                if (articleChek.isEmpty()) {
                    articleVerif.add("aucun article avec l'id" + listArticle.getArticle().getId());
                }

            }else{
                articleVerif.add("Impossible d'enregister une commande avec un aticle NULL");
            }
        });
    }



        if (!articleVerif.isEmpty()){
            log.warn("Article n'existe pas dans la BDD");

            throw new InvalidEntityException("Article n'existe pas dans la BDD",ErrorCode.ARTICLE_NOT_FOUND,articleVerif);
        }

            CommandeFournisser saveCmdFour=commandeFournisserRepo.save(CommandeFournisserDto.toEntity(commandeFournisserDto));
             commandeFournisserDto.getLigneCommandeFournissers().forEach(ligneCommandeFournisserDto -> {

               LigneCommandeFournisser ligneCommandeFournisser1= LigneCommandeFournisserDto.toEntity(ligneCommandeFournisserDto);
                 ligneCommandeFournisser1.setCommandeFournisser(saveCmdFour);


                 ligneCommandeFournisserRepo.save(ligneCommandeFournisser1);


            });

        return CommandeFournisserDto.fromEntity(saveCmdFour);

    }

    @Override
    public CommandeFournisserDto findById(Long id) {
        if (id==null){
            log.warn("id is null");
            return null;
        }
        Optional<CommandeFournisser> commandeFournisser1=commandeFournisserRepo.findById(id);
        return Optional.of(CommandeFournisserDto.fromEntity(commandeFournisser1
                .get()))
                .orElseThrow(()-> new EntityNotFoundException("aucun fournisser avec l'id"+id,ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisserDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.warn("code is null");
            return null;
        }
        Optional<CommandeFournisser> commandeFournisser1=commandeFournisserRepo.findByCode(code);
        return Optional.of(CommandeFournisserDto.fromEntity(commandeFournisser1
                        .get()))
                .orElseThrow(()-> new EntityNotFoundException("aucun fournisser avec le code"+code,ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
        commandeFournisserRepo.deleteById(id);

    }
}
