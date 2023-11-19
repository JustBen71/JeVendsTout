package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.Panier_Article;
import com.jevendtout.jevendstout.model.Utilisateur;
import com.jevendtout.jevendstout.service.PanierArticleService;
import com.jevendtout.jevendstout.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PanierArticleController {

    @Autowired
    private PanierArticleService panierArticleService;

    @GetMapping("/panierarticle/{id}")
    public Optional<Panier_Article> getPanierArticle(@PathVariable("id") int id)
    {
        return panierArticleService.getPanierArticle(id);
    }

    @GetMapping("/panierarticle")
    public Iterable<Panier_Article> getPaniersArticles()
    {
        return panierArticleService.getsPaniersArticles();
    }

    @PostMapping(value = "/panierarticle/new")
    public ResponseEntity<Panier_Article> newPanierArticle(@RequestBody Panier_Article panierArticle)
    {
        if(panierArticle != null)
        {
            try{
                Panier_Article panierarticle_result = panierArticleService.addPanierArticle(panierArticle);
                if(panierarticle_result != null)
                {
                    return ResponseEntity.ok(panierarticle_result);
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

    @PutMapping(value = "/panierarticle/edit/{id}")
    public ResponseEntity<Panier_Article> updatePanierArticle(@RequestBody Panier_Article panierArticle, @PathVariable("id") int id)
    {
        if(panierArticleService.getPanierArticle(id) != null)
        {
            if(panierArticle != null)
            {
                try{
                    Panier_Article panierarticle_result = panierArticleService.editPanierArticle(panierArticle);
                    if(panierarticle_result != null)
                    {
                        return ResponseEntity.ok(panierarticle_result);
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

    @DeleteMapping(value = "/panierarticle/delete/{id}")
    public ResponseEntity<Panier_Article> deletePanierArticle(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Panier_Article> panierArticle = panierArticleService.getPanierArticle(id);
            if(panierArticle != null)
            {
                try{
                    panierArticleService.deletePanierArticle(panierArticle.get());
                    return ResponseEntity.ok(panierArticle.get());
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
