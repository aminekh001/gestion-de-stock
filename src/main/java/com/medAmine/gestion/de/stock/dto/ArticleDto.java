package com.medAmine.gestion.de.stock.dto;



import com.medAmine.gestion.de.stock.model.Article;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {
    private Long id;


    private String CodeArticle;

    private String designation;

    private BigDecimal prixunitareHt;

    private BigDecimal tauxTva;

    private String photo;

    private CatrgoryDto category;


    public static  ArticleDto  fromEntity (Article article){
     if (article==null){
         //exep to do
         return null ;
     } return ArticleDto.builder()
                .CodeArticle(article.getCodeArticle())
                .id(article.getId())
                .designation(article.getDesignation())
                .prixunitareHt(article.getPrixunitareHt())
                .tauxTva(article.getTauxTva())
                .photo(article.getPhoto())
                .category(CatrgoryDto.fromEntity(article.getCategory()))
                .build();
    }
    public static Article toEntity(ArticleDto articleDto){
        if (articleDto==null){
            return null;
        }
            Article article = new Article();
            article.setCodeArticle(articleDto.getCodeArticle());
            article.setId(articleDto.getId());
            article.setDesignation(articleDto.getDesignation());
            article.setPrixunitareHt(articleDto.getPrixunitareHt());
            article.setTauxTva(articleDto.getTauxTva());
            article.setPhoto(articleDto.getPhoto());
            article.setCategory(CatrgoryDto.toEntity(articleDto.getCategory()));
            return article;

    }
}
