package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

@Entity(name="Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="SeqArtiID")
    @SequenceGenerator(name="SeqArtiID", sequenceName="ARTICLE_SEQ", allocationSize=1, initialValue = 1000)
    private int IdArticle;

    @Column(name="Libelle_article")
    private String LibelleArticle;

    @Column(name="Prix_article")
    private int PrixArticle;

    @Column(name="TVA_article")
    private int TVAArticle;

    @Column(name="Stock_article")
    private int StockArticle;

    @ManyToOne
    @JoinColumn(name="Id_Categorie")
    private Categorie FkCategorie;

    public Article() {
    }

    public int getIdArticle() {
        return IdArticle;
    }

    public Article(int idArticle, String libelleArticle, int prixArticle, int TVAArticle, int stockArticle, Categorie idCategorie) {
        IdArticle = idArticle;
        LibelleArticle = libelleArticle;
        PrixArticle = prixArticle;
        this.TVAArticle = TVAArticle;
        StockArticle = stockArticle;
        FkCategorie = idCategorie;
    }

    public void setIdArticle(int idArticle) {
        IdArticle = idArticle;
    }

    public String getLibelleArticle() {
        return LibelleArticle;
    }

    public void setLibelleArticle(String libelleArticle) {
        LibelleArticle = libelleArticle;
    }

    public int getPrixArticle() {
        return PrixArticle;
    }

    public void setPrixArticle(int prixArticle) {
        PrixArticle = prixArticle;
    }

    public int getTVAArticle() {
        return TVAArticle;
    }

    public void setTVAArticle(int TVAArticle) {
        this.TVAArticle = TVAArticle;
    }

    public int getStockArticle() {
        return StockArticle;
    }

    public void setStockArticle(int stockArticle) {
        StockArticle = stockArticle;
    }

    public Categorie getFkCategorie() {
        return FkCategorie;
    }

    public void setFkCategorie(Categorie fkCategorie) {
        FkCategorie = fkCategorie;
    }
}
