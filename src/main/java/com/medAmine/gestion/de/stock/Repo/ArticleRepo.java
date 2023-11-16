package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Long, Article> {
}
