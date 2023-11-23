package com.medAmine.gestion.de.stock.services.impl;

import com.medAmine.gestion.de.stock.Repo.ArticleRepo;
import com.medAmine.gestion.de.stock.dto.ArticleDto;
import com.medAmine.gestion.de.stock.exeption.EntityNotFoundException;
import com.medAmine.gestion.de.stock.exeption.ErrorCode;
import com.medAmine.gestion.de.stock.exeption.InvalidEntityException;
import com.medAmine.gestion.de.stock.model.Article;
import com.medAmine.gestion.de.stock.services.ArticleServices;
import com.medAmine.gestion.de.stock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServicesImpl implements ArticleServices {
    private final ArticleRepo articleRepo;

    @Autowired
    public ArticleServicesImpl(ArticleRepo articleRepo){
        this.articleRepo=articleRepo;

    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errers=  ArticleValidator.Validate(articleDto);
        if (!errers.isEmpty()){
            log.error("article no valide",articleDto);
            throw new  InvalidEntityException("l'article n'est pas valide", ErrorCode.ARTICLE_NOT_VALID,errers);

        }
        return ArticleDto.fromEntity(articleRepo.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Long id) {
        if (id==null){
            log.error("article id is null");
            return  null;
        }
        Optional<Article> article = articleRepo.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException("aucun article avec l'ID "+ id +"n'ete trouve dans la base de donné",ErrorCode.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("article code is null");
            return null;
        }
        Optional<Article> article=articleRepo.findByCode(code);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException("aucun article le code "+code+"n'ete trouve dans la base de donne  ",ErrorCode.ARTICLE_NOT_FOUND));

    }

    @Override
    public List<ArticleDto> findAll() {

        return articleRepo.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Void deleteById(Long id) {
        return null;
    }
}
