package com.jevendtout.jevendstout.service;

import com.jevendtout.jevendstout.model.Devis;
import com.jevendtout.jevendstout.model.Utilisateur;
import com.jevendtout.jevendstout.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Optional<Utilisateur> getUtilisateur(int id)
    {
        return utilisateurRepository.findById(id);
    }

    public Iterable<Utilisateur> getUtilisateurs()
    {
        return utilisateurRepository.findAll();
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur)
    {
        return utilisateurRepository.saveAndFlush(utilisateur);
    }

    public Utilisateur editUtilisateur(Utilisateur utilisateur)
    {
        if (utilisateur.getIdUtilisateur() != 0 && utilisateurRepository.existsById(utilisateur.getIdUtilisateur())) {
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    public void deleteUtilisateur(Utilisateur utilisateur)
    {
        utilisateurRepository.delete(utilisateur);
    }
}
