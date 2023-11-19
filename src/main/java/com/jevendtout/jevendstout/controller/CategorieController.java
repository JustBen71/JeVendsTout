package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.Associer;
import com.jevendtout.jevendstout.model.Categorie;
import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.model.Utilisateur;
import com.jevendtout.jevendstout.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories")
    public Iterable<Categorie> getCategories(){
        Iterable<Categorie> listCategorie = categorieService.getCategories();
        return listCategorie;
    }

    @GetMapping("/categorie/{id}")
    @ResponseBody
    public Optional<Categorie> getCategorie(@PathVariable("id") int id){
        Optional<Categorie> categorie = categorieService.getCategorie(id);
        return categorie;
    }

    @PostMapping(value = "/categorie/new")
    public ResponseEntity<Categorie> newCategorie(@RequestBody Categorie categorie)
    {
        if(categorie != null)
        {
            try{
                System.out.println(categorie.getNomCategorie());
                Categorie categorie_result = categorieService.addCategorie(categorie);
                if(categorie_result != null)
                {
                    return ResponseEntity.ok(categorie_result);
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

    @PutMapping(value = "/categorie/edit/{id}")
    public ResponseEntity<Categorie> newCategorie(@RequestBody Categorie categorie, @PathVariable("id") int id)
    {
        if(id != 0)
        {
            if(categorie != null)
            {
                try{
                    Categorie categorie_result = categorieService.editCategorie(categorie);
                    if(categorie_result != null)
                    {
                        return ResponseEntity.ok(categorie_result);
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

    @DeleteMapping(value = "/categorie/delete/{id}")
    public ResponseEntity<Categorie> deleteCategorie(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Categorie> categorie = categorieService.getCategorie(id);
            if(categorie != null)
            {
                try{
                    categorieService.deleteCategorie(categorie.get());
                    return ResponseEntity.ok(categorie.get());
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
