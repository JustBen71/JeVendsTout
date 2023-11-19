package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Article;
import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticle(int id)
    {
        return articleRepository.findById(id);
    }

    public Iterable<Article> getArticles()
    {
        return articleRepository.findAll();
    }

    public Article addArticle(Article article)
    {
        return articleRepository.save(article);
    }

    public Article editDArticle(Article article)
    {
        if (article.getIdArticle() != 0 && articleRepository.existsById(article.getIdArticle())) {
            return articleRepository.save(article);
        }
        return null;
    }

    public void deleteArticle(Article article)
    {
        articleRepository.delete(article);
    }
}
