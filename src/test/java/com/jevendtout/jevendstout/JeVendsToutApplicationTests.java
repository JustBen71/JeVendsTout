package com.jevendtout.jevendstout;

import com.jevendtout.jevendstout.model.*;
import com.jevendtout.jevendstout.repository.AssocierRepository;
import com.jevendtout.jevendstout.service.AssocierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JeVendsToutApplicationTests {

    @InjectMocks
    private AssocierService associerService;

    @Mock
    private AssocierRepository associerRepository;

    @Test
    public void testGetAssocier() {
        Associer associer = new Associer();
        when(associerRepository.findById(1)).thenReturn(Optional.of(associer));

        Optional<Associer> result = associerService.getAssocier(1);

        assertEquals(associer, result.orElse(null));
    }

    @Test
    public void testArticleGetterAndSetter() {
        Article article = new Article();
        article.setIdArticle(1);
        article.setLibelleArticle("Test Article");

        assertEquals(1, article.getIdArticle());
        assertEquals("Test Article", article.getLibelleArticle());
    }

    @Test
    public void testCategorieGetterAndSetter() {
        Categorie categorie = new Categorie();
        categorie.setIdCategorie(1);
        categorie.setNomCategorie("TestCategory");

        assertEquals(1, categorie.getIdCategorie());
        assertEquals("TestCategory", categorie.getNomCategorie());
    }

    @Test
    public void testDevisGetterAndSetter() {
        Panier panier = new Panier();
        Devis devis = new Devis(1, panier);

        assertEquals(1, devis.getValidationDevis());
        assertEquals(panier, devis.getFkPanier());
    }

    @Test
    public void testPanierGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur();
        Panier panier = new Panier(1, 0, utilisateur);

        assertEquals(1, panier.getIdPanier());
        assertEquals(0, panier.getValidationPanier());
        assertEquals(utilisateur, panier.getFkUtilisateur());
    }

    @Test
    public void testPanierArticleGetterAndSetter() {
        Panier panier = new Panier();
        Article article = new Article();
        Panier_Article panierArticle = new Panier_Article(1, 5, panier, article);

        assertEquals(1, panierArticle.getIdPanierArticle());
        assertEquals(5, panierArticle.getQuantite());
        assertEquals(panier, panierArticle.getFkPanier());
        assertEquals(article, panierArticle.getFkArticle());
    }

    @Test
    public void testUtilisateurGetterAndSetter() {
        Utilisateur utilisateur = new Utilisateur(1, "John", "Doe", "USER");

        assertEquals(1, utilisateur.getIdUtilisateur());
        assertEquals("John", utilisateur.getNomUtilisateur());
        assertEquals("Doe", utilisateur.getPrenomUtilisateur());
        assertEquals("USER", utilisateur.getRoleUtilisateur());
    }
}
