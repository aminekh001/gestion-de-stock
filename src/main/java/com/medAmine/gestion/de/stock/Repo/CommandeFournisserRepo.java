package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.CommandeFournisser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeFournisserRepo extends JpaRepository<Long, CommandeFournisser> {

}
