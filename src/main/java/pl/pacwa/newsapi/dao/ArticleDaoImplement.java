package pl.pacwa.newsapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.pacwa.newsapi.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ArticleDaoImplement implements ArticleDao {

    private JdbcTemplate jdbcTemplate;
    private static String DEFAULT_LOCAL_IMG_URL = "/img/news.jpg";

    @Autowired
    public ArticleDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArticleDto getArticleById(Long id) {
        String sql = "SELECT * FROM article WHERE article_id= ?";
        try {
            return jdbcTemplate.queryForObject(sql,(rs, rowNum)-> new ArticleDto(
                    rs.getLong("article_id"),
                    rs.getString("title"),
                    rs.getString("url_image"),
                    rs.getString("description"),
                    rs.getString("published_art")
            ), id);
        }catch (IncorrectResultSizeDataAccessException ex){
            System.out.println(ex.getMessage());
            return new ArticleDto();
        }
    }

    @Override
    public List<ArticleDto> findAllArticle() {
        String sql = "SELECT  * FROM article";
        List<Map<String, Object>> dbOutput = jdbcTemplate.queryForList(sql);
        List<ArticleDto> articleDtoList = new ArrayList<>();
        dbOutput.forEach(el-> articleDtoList.add(new ArticleDto(
                Long.parseLong(String.valueOf(el.get("article_id"))),
                String.valueOf(el.get("title")),
                String.valueOf(el.get("url_image")),
                String.valueOf(el.get("description")),
                String.valueOf(el.get("published_art"))

        )) );
        articleDtoList.forEach(artical -> {
            if(artical.getUrlToImage().equals("Nome")){
                artical.setUrlToImage(DEFAULT_LOCAL_IMG_URL );
            }

        });
        return articleDtoList;
    }


    @Override
    public int updateArticle(ArticleDto updatedArticle) {
        String sql = "UPDATE article SET article.title = ?, article.url_image = ?, article.description = ?, " +
                "article.published_art = ? WHERE article_id = ?";
        return jdbcTemplate.update(sql, updatedArticle.getTitle(),updatedArticle.getUrlToImage(),
                updatedArticle.getDescription(), updatedArticle.getPublishedAt(), updatedArticle.getId());
    }
}


