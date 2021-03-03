package pl.pacwa.newsapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.pacwa.newsapi.api.ArticleApi;
import pl.pacwa.newsapi.model.Example;

import javax.sql.DataSource;
import java.util.Optional;

@Configuration
public class DbConfig {

    private DataSource dataSource;
    private ArticleApi articleApi;

    @Autowired
    public DbConfig(DataSource dataSource, ArticleApi articleApi) {
        this.dataSource = dataSource;
        this.articleApi = articleApi;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDb(){
        String dropTable =  "DROP TABLE IF EXISTS `article`";
        jdbcTemplate().update(dropTable);

        String createTable = "CREATE TABLE article (article_id int  AUTO_INCREMENT PRIMARY KEY ,"+
        " title varchar (1000), url_image varchar (1000), description varchar (10000), published_art varchar (150))";
        jdbcTemplate().update(createTable);

        String sql = "INSERT INTO article(title, url_image, description, published_art ) VALUES (?, ?, ?, ?)";
        Optional<Example> exampleOptional = articleApi.getDataRemoteApi();
        exampleOptional.ifPresent(example -> example.getArticles()
                .forEach(article ->jdbcTemplate().update(sql, article.getTitle(),
                        article.getUrlToImage(), article.getDescription(), article.getPublishedAt())));
    }
}
