package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.service.ArticleService;

import java.util.List;

/**
 * Created by михайло on 19.06.2017.
 */
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
@RequestMapping(value = "/all/article",method = RequestMethod.GET)
@ResponseBody
    public List<Article> all(){
        return articleService.findAll();
    }
    @RequestMapping(value = "/all/article/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Article> findAll(@PathVariable Integer id){
        return articleService.findAll(id);
    }
    @RequestMapping(value = "/article/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        articleService.delete(id);
        return "redirect:/profile";
    }
    @RequestMapping(value = "/add/article",method = RequestMethod.POST)
    public String addMyArticle(@RequestParam("post") String post, @RequestParam("mediaFile")MultipartFile multipartFile){
       articleService.addMyArticle(post,multipartFile);
        return "redirect:/profile/";
    }
    @RequestMapping(value = "/add/article/{id}",method = RequestMethod.POST)
    public String addArticle(@RequestParam("post") String post, @PathVariable Integer id, @RequestParam("mediaFile")MultipartFile multipartFile){


        articleService.addArticle(post,multipartFile,id);
        return "redirect:/profile/"+id;
    }

}
