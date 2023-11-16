package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeClientRepo extends JpaRepository<Long, LigneCommandeClient> {
}
