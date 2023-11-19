package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

@Entity(name="Panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="SeqPanierID")
    @SequenceGenerator(name="SeqPanierID", sequenceName="PANIER_SEQ", allocationSize=1, initialValue = 1)
    private int idPanier;

    @Column(name="Validation_Panier")
    private int validationPanier;

    @ManyToOne
    @JoinColumn(name="Id_Utilisateur")
    private Utilisateur fkUtilisateur;

    public Panier() {
    }

    public Panier(int idPanier, int validationPanier, Utilisateur fkUtilisateur) {
        this.idPanier = idPanier;
        this.validationPanier = validationPanier;
        this.fkUtilisateur = fkUtilisateur;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public int getValidationPanier() {
        return validationPanier;
    }

    public void setValidationPanier(int validationPanier) {
        this.validationPanier = validationPanier;
    }

    public Utilisateur getFkUtilisateur() {
        return fkUtilisateur;
    }

    public void setFkUtilisateur(Utilisateur fkUtilisateur) {
        this.fkUtilisateur = fkUtilisateur;
    }
}
