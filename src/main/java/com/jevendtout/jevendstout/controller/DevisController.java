package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.*;
import com.jevendtout.jevendstout.service.AssocierService;
import com.jevendtout.jevendstout.service.DevisService;
import com.jevendtout.jevendstout.service.PanierArticleService;
import com.jevendtout.jevendstout.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@RestController
public class DevisController {

    @Autowired
    private DevisService devisService;

    @Autowired
    private PanierArticleService panierArticleService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private AssocierService associerService;

    @GetMapping("/devis/{id}")
    public Optional<Devis> getDevis(@PathVariable("id") int id)
    {
        return devisService.getDevis(id);
    }

    @GetMapping("/devis")
    public Iterable<Devis> getAllDevis()
    {
        return devisService.getsDevis();
    }

    @PostMapping(value = "/devis/new")
    public ResponseEntity<Devis> newDevis(@RequestBody Devis devis)
    {
        if(devis != null)
        {
            try{
                Devis devis_result = devisService.addDevis(devis);
                if(devis_result != null)
                {
                    return ResponseEntity.ok(devis_result);
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

    @PutMapping(value = "/devis/edit/{id}")
    public ResponseEntity<Devis> newDevis(@RequestBody Devis devis, @PathVariable("id") int id)
    {
        if(id != 0)
        {
            if(devis != null)
            {
                try{
                    Devis devis_result = devisService.editDevis(devis);
                    if(devis_result != null)
                    {
                        return ResponseEntity.ok(devis_result);
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

    @DeleteMapping(value = "/devis/delete/{id}")
    public ResponseEntity<Devis> newDevis(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Devis> devis = devisService.getDevis(id);
            if(devis != null)
            {
                try{
                    devisService.deleteDevis(devis.get());
                    return ResponseEntity.ok(devis.get());
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

    @GetMapping(value="/devis/validation/{idDevis}/{idUtilisateur}")
    public ResponseEntity<Devis> validationDevis(@PathVariable("idDevis") int idDevis, @PathVariable("idUtilisateur") int idUtilisateur)
    {
        if(idDevis != 0)
        {
            if(idUtilisateur != 0)
            {
                Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateur(idUtilisateur);
                Optional<Devis> devis = devisService.getDevis(idDevis);
                if(devis.get().getValidationDevis() != 1)
                {
                    Iterator<Panier_Article> panierArticles = panierArticleService.getsPaniersArticles().iterator();
                    ArrayList<Article> articles = new ArrayList<>();
                    double montant = 0;
                    int leplusChere = 0;
                    Article lepluschereArticle = new Article();
                    while(panierArticles.hasNext())
                    {
                        Panier_Article panier_article_tmp = panierArticles.next();
                        if(panier_article_tmp.getFkPanier().getIdPanier() == devis.get().getFkPanier().getIdPanier())
                        {
                            articles.add(panier_article_tmp.getFkArticle());
                            montant += panier_article_tmp.getFkArticle().getPrixArticle()*panier_article_tmp.getQuantite();
                            if(leplusChere < panier_article_tmp.getFkArticle().getPrixArticle())
                            {
                                lepluschereArticle = panier_article_tmp.getFkArticle();
                            }
                        }
                    }
                    if(montant >= 10000)
                    {
                        if(utilisateur.get().getRoleUtilisateur().equals("Directeur"))
                        {
                            devis.get().setValidationDevis(1);
                            devisService.editDevis(devis.get());
                            return ResponseEntity.ok(devis.get());
                        }
                    }
                    else
                    {
                        Iterator<Associer> associer = associerService.getAssociers().iterator();
                        while (associer.hasNext())
                        {
                            Associer associer_tmp = associer.next();

                            if(associer_tmp.getFkUtilisateur().getIdUtilisateur() == utilisateur.get().getIdUtilisateur())
                            {
                                if(associer_tmp.getFkCategorie().getIdCategorie() == lepluschereArticle.getFkCategorie().getIdCategorie())
                                {
                                    devis.get().setValidationDevis(1);
                                    devisService.editDevis(devis.get());
                                    return ResponseEntity.ok(devis.get());
                                }
                            }
                        }
                    }
                    return ResponseEntity.notFound().build();
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
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value="/devis/validation/all/{idUtilisateur}")
    public Iterable<Devis> validationDevis(@PathVariable("idUtilisateur") int idUtilisateur)
    {
        if(idUtilisateur != 0)
        {
            Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateur(idUtilisateur);
            ArrayList<Devis> devisValidable = new ArrayList<>();
            if(utilisateur.get().getRoleUtilisateur().equals("Directeur"))
            {
                Iterator<Devis> devis = devisService.getsDevis().iterator();
                while(devis.hasNext())
                {
                    double montantDevis = 0;
                    Devis devis_tmp = devis.next();
                    Iterator<Panier_Article> panier_article = panierArticleService.getsPaniersArticles().iterator();
                    while(panier_article.hasNext())
                    {
                        Panier_Article panier_article_tmp = panier_article.next();
                        if(panier_article_tmp.getFkPanier().getIdPanier() == devis_tmp.getFkPanier().getIdPanier() && devis_tmp.getValidationDevis() != 1)
                        {
                            montantDevis += panier_article_tmp.getFkArticle().getPrixArticle()*panier_article_tmp.getQuantite();
                        }
                    }
                    if(montantDevis > 10000)
                    {
                        devisValidable.add(devis_tmp);
                    }
                }
                for(int i  = 0; i < devisValidable.size(); i++)
                {
                    devisValidable.get(i).setValidationDevis(1);
                    devisService.editDevis(devisValidable.get(i));
                }
                Iterable<Devis> result_devis = devisValidable;
                return result_devis;
            }
            return null;
        }
        else
        {
            return null;
        }
    }
}
