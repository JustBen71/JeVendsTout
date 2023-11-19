package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

@Entity(name="Panier_Article")
public class Panier_Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="SeqPanierArtID")
    @SequenceGenerator(name="SeqPanierArtID", sequenceName="PANIER_ARTICLE_SEQ", allocationSize=1, initialValue = 1)
    private int IdPanierArticle;

    @Column(name="Quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name="IdPanier")
    private Panier FkPanier;

    @ManyToOne
    @JoinColumn(name="IdArticle")
    private Article FkArticle;

    public Panier_Article() {
    }

    public Panier_Article(int idPanierArticle, int quantite, Panier fkPanier, Article fkArticle) {
        IdPanierArticle = idPanierArticle;
        this.quantite = quantite;
        FkPanier = fkPanier;
        FkArticle = fkArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdPanierArticle() {
        return IdPanierArticle;
    }

    public void setIdPanierArticle(int idPanierArticle) {
        IdPanierArticle = idPanierArticle;
    }

    public Panier getFkPanier() {
        return FkPanier;
    }

    public void setFkPanier(Panier fkPanier) {
        FkPanier = fkPanier;
    }

    public Article getFkArticle() {
        return FkArticle;
    }

    public void setFkArticle(Article fkArticle) {
        FkArticle = fkArticle;
    }
}
