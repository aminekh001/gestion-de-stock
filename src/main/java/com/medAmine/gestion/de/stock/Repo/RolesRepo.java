package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository< Roles,Long> {
}
