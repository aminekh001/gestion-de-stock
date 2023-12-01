package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepo extends JpaRepository < CommandeClient,Long>{
    Optional<CommandeClient> findByCode(String code);
}
