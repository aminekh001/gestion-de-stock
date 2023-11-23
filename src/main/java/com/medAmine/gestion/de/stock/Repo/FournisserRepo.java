package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Fournisser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisserRepo extends JpaRepository<Fournisser,Long> {
}
