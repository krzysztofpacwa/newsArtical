package pl.pacwa.newsapi.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pacwa.newsapi.dao.ArticleDao;
import pl.pacwa.newsapi.dto.ArticleDto;

@Controller
public class Controler {

    private ArticleDao articleDao;

    @Autowired
    public Controler(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getNews( Model model){
        model.addAttribute("allArticle", articleDao.findAllArticle());
        return "index";
    }
    @RequestMapping(value = "/getArticle", method = RequestMethod.GET)
    @ResponseBody
    public ArticleDto getOneArticle(Long id){
        return articleDao.getArticleById(id);
    }

    @RequestMapping(value = "/updateArticle", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    public String updateArticle (@Validated ArticleDto updatedNews){
        int modification = articleDao.updateArticle(updatedNews);
        if (modification ==1){
            return "redirect:/index";
        }
        return "error";
    }

}
