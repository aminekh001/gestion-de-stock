package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepo extends JpaRepository<Long, Entreprise> {

}
