package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    public Optional<Panier> getPanier(int id)
    {
        return panierRepository.findById(id);
    }

    public Iterable<Panier> getPaniers()
    {
        return panierRepository.findAll();
    }

    public Panier addPanier(Panier panier)
    {
        return panierRepository.save(panier);
    }

    public Panier editPanier(Panier panier)
    {

        return panierRepository.save(panier);
    }

    public void deletePanier(Panier panier)
    {
        panierRepository.delete(panier);
    }
}
