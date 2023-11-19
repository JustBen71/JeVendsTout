package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Associer;
import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.repository.AssocierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssocierService {

    @Autowired
    private AssocierRepository associerRepository;

    public Optional<Associer> getAssocier(int id)
    {
        return associerRepository.findById(id);
    }

    public Iterable<Associer> getAssociers()
    {
        return associerRepository.findAll();
    }

    public Associer addAssocier(Associer associer)
    {
        return associerRepository.save(associer);
    }

    public Associer editAssocier(Associer associer)
    {

        return associerRepository.save(associer);
    }

    public void deleteAssocier(Associer associer)
    {
        associerRepository.delete(associer);
    }
}
