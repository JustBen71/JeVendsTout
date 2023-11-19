package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.*;
import com.jevendtout.jevendstout.service.ArticleService;
import com.jevendtout.jevendstout.service.DevisService;
import com.jevendtout.jevendstout.service.PanierArticleService;
import com.jevendtout.jevendstout.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class PanierController {

    @Autowired
    private PanierService panierService;

    @Autowired
    private PanierArticleService panierArticleService;

    @Autowired
    private DevisService devisService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/panier/{id}")
    public Optional<Panier> getPanier(@PathVariable("id") int id)
    {
        Optional<Panier> panier = panierService.getPanier(id);
        return panier;
    }

    @GetMapping("/paniers")
    public Iterable<Panier> getPaniers()
    {
        Iterable<Panier> paniers = panierService.getPaniers();
        return paniers;
    }

    @PostMapping(value = "/panier/new")
    public ResponseEntity<Panier> newPanier(@RequestBody Panier panier)
    {
        if(panier != null)
        {
            try{
                Panier panier_result = panierService.addPanier(panier);
                if(panier_result != null)
                {
                    return ResponseEntity.ok(panier_result);
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

    @PutMapping(value = "/panier/edit/{id}")
    public ResponseEntity<Panier> updatePanier(@RequestBody Panier panier, @PathVariable("id") int id)
    {
        if(panierService.getPanier(id) != null)
        {
            if(panier != null)
            {
                try{
                    Panier panier_result = panierService.editPanier(panier);
                    if(panier_result != null)
                    {
                        return ResponseEntity.ok(panier_result);
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

    @DeleteMapping(value = "/panier/delete/{id}")
    public ResponseEntity<Panier> deletePanier(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Panier> panier = panierService.getPanier(id);
            if(panier != null)
            {
                try{
                    panierService.deletePanier(panier.get());
                    return ResponseEntity.ok(panier.get());
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

    @GetMapping(value = "/panier/valider/{id}")
    public ResponseEntity<Devis> validationPanier(@PathVariable("id") int id)
    {
        Optional<Panier> panier = panierService.getPanier(id);
        if(panier != null)
        {
            boolean estEnStock = true;
            Iterator<Panier_Article> panierArticles = panierArticleService.getsPaniersArticles().iterator();
            ArrayList<Article> articleList = new ArrayList<>();
            ArrayList<Integer> articleQuantite = new ArrayList<>();
            while(panierArticles.hasNext())
            {
                Panier_Article panierArticle_tmp = panierArticles.next();
                if(panierArticle_tmp.getFkPanier().getIdPanier() == panier.get().getIdPanier())
                {
                    if(panierArticle_tmp.getQuantite() > panierArticle_tmp.getFkArticle().getStockArticle())
                    {
                        estEnStock = false;
                    }
                    else
                    {
                        articleList.add(panierArticle_tmp.getFkArticle());
                        articleQuantite.add(panierArticle_tmp.getQuantite());
                    }
                }
            }
            if(!estEnStock)
            {
                return ResponseEntity.notFound().build();
            }
            else
            {
                for(int i = 0; i < articleList.size(); i++)
                {
                    articleList.get(i).setStockArticle(articleList.get(i).getStockArticle() - articleQuantite.get(i));
                    articleService.editDArticle(articleList.get(i));
                }
                panier.get().setValidationPanier(1);
                panierService.editPanier(panier.get());
                Devis devis = new Devis(0,panier.get());
                devisService.addDevis(devis);
                return ResponseEntity.ok(devis);
            }
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
