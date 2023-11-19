package com.jevendtout.jevendstout.controller;

import com.jevendtout.jevendstout.model.Article;
import com.jevendtout.jevendstout.model.Associer;
import com.jevendtout.jevendstout.model.Panier;
import com.jevendtout.jevendstout.service.AssocierService;
import com.jevendtout.jevendstout.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AssocierController {

    @Autowired
    private AssocierService associerService;

    @GetMapping("/associer/{id}")
    public Optional<Associer> getAssocier(@PathVariable("id") int id)
    {
        Optional<Associer> associer = associerService.getAssocier(id);
        return associer;
    }

    @GetMapping("/associers")
    public Iterable<Associer> getAssociers()
    {
        Iterable<Associer> associer = associerService.getAssociers();
        return associer;
    }

    @PostMapping(value = "/associer/new")
    public ResponseEntity<Associer> newAssocier(@RequestBody Associer associer)
    {
        if(associer != null)
        {
            try{
                Associer associer_result = associerService.addAssocier(associer);
                if(associer_result != null)
                {
                    return ResponseEntity.ok(associer_result);
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

    @PutMapping(value = "/associer/edit/{id}")
    public ResponseEntity<Associer> updateAssocier(@RequestBody Associer associer, @PathVariable("id") int id)
    {
        if(associerService.getAssocier(id) != null)
        {
            if(associer != null)
            {
                try{
                    Associer associer_result = associerService.editAssocier(associer);
                    if(associer_result != null)
                    {
                        return ResponseEntity.ok(associer_result);
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

    @DeleteMapping(value = "/associer/delete/{id}")
    public ResponseEntity<Associer> deleteAssocier(@PathVariable("id") int id)
    {
        if(id != 0)
        {
            Optional<Associer> associer = associerService.getAssocier(id);
            if(associer != null)
            {
                try{
                    associerService.deleteAssocier(associer.get());
                    return ResponseEntity.ok(associer.get());
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
