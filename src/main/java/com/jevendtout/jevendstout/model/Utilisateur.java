package com.jevendtout.jevendstout.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seqUtiId")
    @SequenceGenerator(name="seqUtiId", sequenceName="UTILISATEUR_SEQ", allocationSize=1, initialValue = 5)
    private int IdUtilisateur;

    @Column(name="Nom_utilisateur")
    private String NomUtilisateur;

    @Column(name="Prenom_utilisateur")
    private String PrenomUtilisateur;

    @Column(name="Role")
    private String RoleUtilisateur;

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String roleUtilisateur) {
        IdUtilisateur = idUtilisateur;
        NomUtilisateur = nomUtilisateur;
        PrenomUtilisateur = prenomUtilisateur;
        RoleUtilisateur = roleUtilisateur;
    }

    public int getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return NomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        NomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return PrenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        PrenomUtilisateur = prenomUtilisateur;
    }

    public String getRoleUtilisateur() {
        return RoleUtilisateur;
    }

    public void setRoleUtilisateur(String roleUtilisateur) {
        RoleUtilisateur = roleUtilisateur;
    }
}
