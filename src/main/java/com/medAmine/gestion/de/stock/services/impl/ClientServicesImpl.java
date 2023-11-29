package com.medAmine.gestion.de.stock.services.impl;
import com.medAmine.gestion.de.stock.Repo.ClientRepo;
import com.medAmine.gestion.de.stock.dto.ClientDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Client;
import com.medAmine.gestion.de.stock.services.ClientServices;
import com.medAmine.gestion.de.stock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServicesImpl implements ClientServices {
    public  final ClientRepo clientRepo;

    @Autowired
    public ClientServicesImpl(ClientRepo clientRepo)
    {
        this.clientRepo = clientRepo;
    }

    @Override
    public ClientDto Save(ClientDto clientDto) {
        List<String> err= ClientValidator.validate(clientDto);
        if (!err.isEmpty()){
            log.error("Client n'est pas Valide",clientDto);
            throw new InvalidEntityException("Client n'est pas Valide", ErrorCode.CLIENT_NOT_VALID,err);


        }

        return ClientDto.fromEntity(clientRepo.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public List<ClientDto> findAll() {

        return clientRepo.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Long id) {
        if (id==null){
            log.error("Client n'est pas valide");
            return null;
        }
        Optional<Client> client= clientRepo.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get()))
                .orElseThrow(()-> new EntityNotFoundException
                        ("aucun Client avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.CLIENT_NOT_FOUND));
    }

    @Override
    public void  deleteById(Long id) {
         clientRepo.deleteById(id);
    }
}
