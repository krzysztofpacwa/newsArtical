package pl.pacwa.newsapi.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.pacwa.newsapi.model.Example;

import java.util.Optional;

@RestController
public class ArticleApi {

    @Value("77c2af16de5f4a5cb28a84585e91fe68")
    private String apiTokien;
    Logger logger = LoggerFactory.getLogger(ArticleApi.class);

    public Optional<Example> getDataRemoteApi(){
        try {
            RestTemplate restTemplateArtical = new RestTemplate();
        String remonteApiUrl = "https://newsapi.org/v2/top-headlines?country=pl&apiKey=" + apiTokien;
        logger.debug("starting fetching from Api.");
        Optional<Example> newsExample = Optional.ofNullable(restTemplateArtical
                .getForObject(remonteApiUrl,Example.class));
        if (newsExample.isEmpty()){
            logger.error("There was an issue during fetching data from remote API. There is no data:" +
                    " \"Info\" fetched.");
        }
            return newsExample;
        } catch (RestClientException ex){
            logger.error("Error fetching data API .",ex);
        }finally {
            logger.debug("fetching data API complete.");
        }
        return Optional.empty();
    };

}
