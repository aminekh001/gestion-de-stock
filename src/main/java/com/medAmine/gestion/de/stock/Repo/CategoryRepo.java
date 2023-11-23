package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
