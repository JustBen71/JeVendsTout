package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Article;
import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.model.Panier_Article;
import com.jevendtout.jevendstout.repository.PanierArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PanierArticleService {

    @Autowired
    private PanierArticleRepository panierArticleRepository;

    public Optional<Panier_Article> getPanierArticle(int id)
    {
        return panierArticleRepository.findById(id);
    }

    public Iterable<Panier_Article> getsPaniersArticles()
    {
        return panierArticleRepository.findAll();
    }

    public Panier_Article addPanierArticle(Panier_Article devis)
    {
        return panierArticleRepository.save(devis);
    }

    public Panier_Article editPanierArticle(Panier_Article panierArticle)
    {
        if (panierArticle.getIdPanierArticle() != 0 && panierArticleRepository.existsById(panierArticle.getIdPanierArticle())) {
            return panierArticleRepository.save(panierArticle);
        }
        return null;
    }

    public void deletePanierArticle(Panier_Article panierArticle)
    {
        panierArticleRepository.delete(panierArticle);
    }
}
