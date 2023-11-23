package com.medAmine.gestion.de.stock.Repo;

import com.medAmine.gestion.de.stock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository< Article,Long> {
    Optional<Article> findByCode(String code);
}
