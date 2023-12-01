package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentesRepo extends JpaRepository< Ventes,Long> {
    Optional<Ventes> findByCode(String code);
}
