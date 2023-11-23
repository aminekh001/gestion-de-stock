package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.LigneCommandeFournisser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeFournisserRepo extends JpaRepository<LigneCommandeFournisser,Long> {
}
