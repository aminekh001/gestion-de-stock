package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneVenteRepo extends JpaRepository< LigneVente,Long> {
}
