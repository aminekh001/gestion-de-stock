package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvtStkRepo extends JpaRepository<MvtStk,Long> {
}
