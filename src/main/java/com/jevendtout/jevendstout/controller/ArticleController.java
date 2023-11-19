package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.Article;
import com.jevendtout.jevendstout.model.Categorie;
import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public Optional<Article> getArticle(@PathVariable("id") int id)
    {
        Optional<Article> article = articleService.getArticle(id);
        return article;
    }

    @GetMapping("/articles")
    public Iterable<Article> getArticles()
    {
        Iterable<Article> articles = articleService.getArticles();
        return articles;
    }

    @PostMapping(value = "/article/new")
    public ResponseEntity<Article> newArticle(@RequestBody Article article)
    {
        if(article != null)
        {
            try{
                Article article_result = articleService.addArticle(article);
                if(article_result != null)
                {
                    return ResponseEntity.ok(article_result);
                }
                else
                {
                    return ResponseEntity.notFound().build();
                }
            }
            catch (Exception e)
            {
                return ResponseEntity.notFound().build();
            }
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/article/edit/{id}")
    public ResponseEntity<Article> newArticle(@RequestBody Article article, @PathVariable("id") int id)
    {
        if(id != 0)
        {
            if(article != null)
            {
                try{
                    Article article_result = articleService.editDArticle(article);
                    if(article_result != null)
                    {
                        return ResponseEntity.ok(article_result);
                    }
                    else
                    {
                        return ResponseEntity.notFound().build();
                    }
                }
                catch (Exception e)
                {
                    return ResponseEntity.notFound().build();
                }
            }
            else
            {
                return ResponseEntity.notFound().build();
            }
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/article/delete/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Article> article = articleService.getArticle(id);
            if(article != null)
            {
                try{
                    articleService.deleteArticle(article.get());
                    return ResponseEntity.ok(article.get());
                }
                catch (Exception e)
                {
                    return ResponseEntity.notFound().build();
                }
            }
            else
            {
                return ResponseEntity.notFound().build();
            }
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
