package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeClientRepo extends JpaRepository < CommandeClient,Long>{
}
