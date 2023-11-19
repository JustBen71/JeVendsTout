package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Article;
import com.jevendtout.jevendstout.model.Associer;
import com.jevendtout.jevendstout.model.Categorie;
import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Optional<Categorie> getCategorie(final int id)
    {
        return categorieRepository.findById(id);
    }

    public Iterable<Categorie> getCategories()
    {
        return categorieRepository.findAll();
    }

    public Categorie addCategorie(Categorie categorie)
    {
        return categorieRepository.save(categorie);
    }

    public Categorie editCategorie(Categorie categorie)
    {
        if (categorie.getIdCategorie() != 0 && categorieRepository.existsById(categorie.getIdCategorie())) {
            return categorieRepository.save(categorie);
        }
        return null;
    }

    public void deleteCategorie(Categorie categorie)
    {
        categorieRepository.delete(categorie);
    }
}
