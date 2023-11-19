package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

@Entity(name="Devis")
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seqDevisId")
    @SequenceGenerator(name="seqDevisId", sequenceName="DEVIS_SEQ", allocationSize=1, initialValue = 1)
    private int IdDevis;

    @Column(name="Validation_devis")
    private int ValidationDevis;

    @ManyToOne
    @JoinColumn(name="Id_Panier")
    private Panier FkPanier;

    public Devis() {
    }

    public Devis(int validationDevis, Panier fkPanier) {
        ValidationDevis = validationDevis;
        FkPanier = fkPanier;
    }

    public Devis(int idDevis, int validationDevis, Panier fkPanier) {
        IdDevis = idDevis;
        ValidationDevis = validationDevis;
        FkPanier = fkPanier;
    }

    public int getIdDevis() {
        return IdDevis;
    }

    public void setIdDevis(int idDevis) {
        IdDevis = idDevis;
    }

    public int getValidationDevis() {
        return ValidationDevis;
    }

    public void setValidationDevis(int validationDevis) {
        ValidationDevis = validationDevis;
    }

    public Panier getFkPanier() {
        return FkPanier;
    }

    public void setFkPanier(Panier fkPanier) {
        FkPanier = fkPanier;
    }
}
