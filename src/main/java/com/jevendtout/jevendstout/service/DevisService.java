package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.repository.DevisRepository;
import com.jevendtout.jevendstout.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;

    public Optional<Devis> getDevis(int id)
    {
        return devisRepository.findById(id);
    }

    public Iterable<Devis> getsDevis()
    {
        return devisRepository.findAll();
    }

    public Devis addDevis(Devis devis)
    {
        return devisRepository.save(devis);
    }

    public Devis editDevis(Devis devis)
    {
        if (devis.getIdDevis() != 0 && devisRepository.existsById(devis.getIdDevis())) {
            return devisRepository.save(devis);
        }
        return null;
    }

    public void deleteDevis(Devis devis)
    {
        devisRepository.delete(devis);
    }
}
