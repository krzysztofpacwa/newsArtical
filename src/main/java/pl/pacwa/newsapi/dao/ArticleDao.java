package pl.pacwa.newsapi.dao;

import pl.pacwa.newsapi.dto.ArticleDto;

import java.util.List;

public interface ArticleDao {

    ArticleDto getArticleById(Long id);
    List<ArticleDto> findAllArticle();
    int updateArticle(ArticleDto updatedNews);
}
