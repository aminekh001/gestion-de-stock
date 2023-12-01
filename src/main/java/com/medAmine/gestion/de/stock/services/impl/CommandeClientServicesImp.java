package com.medAmine.gestion.de.stock.services.impl;
import com.medAmine.gestion.de.stock.Repo.ArticleRepo;
import com.medAmine.gestion.de.stock.Repo.ClientRepo;
import com.medAmine.gestion.de.stock.Repo.CommandeClientRepo;
import com.medAmine.gestion.de.stock.Repo.LigneCommandeClientRepo;
import com.medAmine.gestion.de.stock.dto.CommandeClientDto;
import com.medAmine.gestion.de.stock.dto.LigneCommandeClientDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Article;
import com.medAmine.gestion.de.stock.model.Client;
import com.medAmine.gestion.de.stock.model.CommandeClient;
import com.medAmine.gestion.de.stock.model.LigneCommandeClient;
import com.medAmine.gestion.de.stock.services.CommandeClientServices;
import com.medAmine.gestion.de.stock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeClientServicesImp implements CommandeClientServices {
    private final CommandeClientRepo commandeClientRepo;
    private final ClientRepo clientRepo;
    private final ArticleRepo articleRepo;
    private final LigneCommandeClientRepo ligneCommandeClientRepo;

    @Autowired
    public CommandeClientServicesImp(CommandeClientRepo commandeClientRepo, ClientRepo clientRepo, ArticleRepo articleRepo, LigneCommandeClientRepo ligneCommandeClientRepo) {
        this.commandeClientRepo = commandeClientRepo;
        this.clientRepo = clientRepo;
        this.articleRepo = articleRepo;
        this.ligneCommandeClientRepo = ligneCommandeClientRepo;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        List<String> err = CommandeClientValidator.validate(commandeClientDto);
        if (!err.isEmpty()){
            log.error("command clientt n'est pas valide ",commandeClientDto);
            throw new InvalidEntityException("command clientt n'est pas valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID,err);
        }





        Optional<Client> clientVerif= clientRepo.findById(commandeClientDto.getClient().getId());

        if (clientVerif.isEmpty()){
            log.warn("Client with ID {} was not found in the DB",commandeClientDto.getClient().getId());
            throw new EntityNotFoundException
                    ("Aucun client avec l'ID"+commandeClientDto.getClient().getId()+"n'a ete trouve dans la BDD",ErrorCode.CLIENT_NOT_FOUND);
        }






        List<String> articleErr= new ArrayList<>();

        if (commandeClientDto.getLigneCommandeClients()!=null){
            commandeClientDto.getLigneCommandeClients().forEach(ligneCommandeClient -> {
                if (ligneCommandeClient.getArticle()!= null) {

                    Optional<Article> articleVerif = articleRepo.findById(ligneCommandeClient.getArticle().getId());
                    if (articleVerif.isEmpty()) {

                        articleErr.add("l'article avec l'id " + ligneCommandeClient.getArticle().getId() + "n'existe pas");
                    }
                }else {
                    articleErr.add("Impossible d'enregister une commande avec un aticle NULL");
                }
                    }
                    );

        }




        if (!articleErr.isEmpty()){
            log.warn("Article n'existe pas ");
            throw new InvalidEntityException("Article n'existe pas dans la BDD",ErrorCode.ARTICLE_NOT_FOUND,articleErr);
        }




        CommandeClient saveCommandeClient= commandeClientRepo.save(CommandeClientDto.toEntity(commandeClientDto));
        if (commandeClientDto.getLigneCommandeClients()!=null){

            commandeClientDto.getLigneCommandeClients().forEach(ligneComClt -> {
                LigneCommandeClient ligneCommandeClient1 = LigneCommandeClientDto.toEntity(ligneComClt);
                ligneCommandeClient1.setCommandeClient(saveCommandeClient);
                ligneCommandeClientRepo.save(ligneCommandeClient1);

            });
        }
        return CommandeClientDto.fromEntity(saveCommandeClient);
    }
    @Override
    public CommandeClientDto findById(Long id) {
        if(id==null){
            log.error("id est null");
            return null;
        }
        Optional<CommandeClient> cmdClt = commandeClientRepo.findById(id);
        return Optional.of(CommandeClientDto.fromEntity(cmdClt.get()))
                .orElseThrow(()->new EntityNotFoundException("aucun CommandeClient avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }
    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("code est vide");
            return null;
        }
        Optional<CommandeClient> cmdClT = commandeClientRepo.findByCode(code);
        return Optional.of(CommandeClientDto.fromEntity(cmdClT.get()))
                .orElseThrow(()->new EntityNotFoundException("aucun ClommandeClient avec le code "+ code +"n'ete trouve dans la base de donné",ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
        commandeClientRepo.deleteById(id);

    }
}
