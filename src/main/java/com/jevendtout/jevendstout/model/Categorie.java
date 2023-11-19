package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

@Entity(name="Categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seqCatId")
    @SequenceGenerator(name="seqCatId", sequenceName="CATEGORIE_SEQ", allocationSize=1, initialValue = 21)
    private int IdCategorie;

    @Column(name="Nom_categorie")
    private String NomCategorie;

    public Categorie() {
    }

    public Categorie(int idCategorie) {
        IdCategorie = idCategorie;
    }

    public Categorie(int idCategorie, String nomCategorie) {
        IdCategorie = idCategorie;
        NomCategorie = nomCategorie;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        IdCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        NomCategorie = nomCategorie;
    }
}
