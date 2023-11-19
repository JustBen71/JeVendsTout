package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.model.Utilisateur;
import com.jevendtout.jevendstout.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable("id") int id)
    {
        return utilisateurService.getUtilisateur(id);
    }

    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs()
    {
        return utilisateurService.getUtilisateurs();
    }

    @PostMapping(value = "/utilisateur/new")
    public ResponseEntity<Utilisateur> newUtilisateur(@RequestBody Utilisateur utilisateur)
    {
        if(utilisateur != null)
        {
            try{
                Utilisateur utilisateur_result = utilisateurService.addUtilisateur(utilisateur);
                if(utilisateur_result != null)
                {
                    return ResponseEntity.ok(utilisateur_result);
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

    @PutMapping(value = "/utilisateur/edit/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable("id") int id)
    {
        if(utilisateurService.getUtilisateur(id) != null)
        {
            if(utilisateur != null)
            {
                try{
                    Utilisateur utilisateur_result = utilisateurService.editUtilisateur(utilisateur);
                    if(utilisateur_result != null)
                    {
                        return ResponseEntity.ok(utilisateur_result);
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

    @DeleteMapping(value = "/utilisateur/delete/{id}")
    public ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateur(id);
            if(utilisateur != null)
            {
                try{
                    utilisateurService.deleteUtilisateur(utilisateur.get());
                    return ResponseEntity.ok(utilisateur.get());
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
