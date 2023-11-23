package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository< Utilisateur,Long> {
}
