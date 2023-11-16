package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentesRepo extends JpaRepository<Long, Ventes> {
}
