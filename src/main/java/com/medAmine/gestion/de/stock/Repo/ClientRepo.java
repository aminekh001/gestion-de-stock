package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
}
