package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findByCode(String code);
}
