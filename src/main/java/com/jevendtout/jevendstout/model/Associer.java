package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

@Entity(name="Associer")
public class Associer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="SeqAssoID")
    @SequenceGenerator(name="SeqAssoID", sequenceName="ASSOCIER_SEQ", allocationSize=1, initialValue = 1)
    private int IdAssocier;

    @ManyToOne
    @JoinColumn(name="Id_Categorie")
    private Categorie FkCategorie;

    @ManyToOne
    @JoinColumn(name="Id_Employee")
    private Utilisateur FkUtilisateur;

    public Associer() {
    }

    public Associer(int idAssocier, Categorie fkCategorie, Utilisateur fkUtilisateur) {
        IdAssocier = idAssocier;
        FkCategorie = fkCategorie;
        FkUtilisateur = fkUtilisateur;
    }

    public int getIdAssocier() {
        return IdAssocier;
    }

    public void setIdAssocier(int idAssocier) {
        IdAssocier = idAssocier;
    }

    public Categorie getFkCategorie() {
        return FkCategorie;
    }

    public void setFkCategorie(Categorie fkCategorie) {
        FkCategorie = fkCategorie;
    }

    public Utilisateur getFkUtilisateur() {
        return FkUtilisateur;
    }

    public void setFkUtilisateur(Utilisateur fkUtilisateur) {
        FkUtilisateur = fkUtilisateur;
    }
}
