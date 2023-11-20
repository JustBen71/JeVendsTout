INSERT INTO CATEGORIE VALUES (1, 'Maison');
INSERT INTO CATEGORIE VALUES (2,'Scierie');
INSERT INTO CATEGORIE VALUES (3,'Litrie');
INSERT INTO CATEGORIE VALUES (4,'Vaiselle');
INSERT INTO CATEGORIE VALUES (5,'Céramique');
INSERT INTO CATEGORIE VALUES (6,'Luxe');
INSERT INTO CATEGORIE VALUES (7,'Exploration');
INSERT INTO CATEGORIE VALUES (8,'Autour du Monde');
INSERT INTO CATEGORIE VALUES (9,'Ocean');
INSERT INTO CATEGORIE VALUES (10,'Caraïbes');
INSERT INTO CATEGORIE VALUES (11,'Ciment');
INSERT INTO CATEGORIE VALUES (12,'Vidéo');
INSERT INTO CATEGORIE VALUES (13,'Charbon');
INSERT INTO CATEGORIE VALUES (14,'Touristique');
INSERT INTO CATEGORIE VALUES (15,'Balai');
INSERT INTO CATEGORIE VALUES (16,'Étriers');
INSERT INTO CATEGORIE VALUES (17,'Toile');
INSERT INTO CATEGORIE VALUES (18,'Camp');
INSERT INTO CATEGORIE VALUES (19,'Bricolage');
INSERT INTO CATEGORIE VALUES (20,'Fenetre');

CREATE OR REPLACE PROCEDURE creer_Article IS
DECLARE
    v_id_article NUMBER;
    v_libelle_article VARCHAR2(50);
    v_prix_article NUMBER;
    v_tva_article NUMBER;
    v_stock_article NUMBER;
    v_id_categorie NUMBER;
BEGIN
    FOR i IN 1..1000 LOOP
            -- Génération de valeurs aléatoires pour chaque champ
            v_id_article := i;
            v_libelle_article := 'Article ' || TO_CHAR(i);
            v_prix_article := DBMS_RANDOM.VALUE(10, 100); -- Valeurs de prix entre 10 et 100
            v_tva_article := 20;
            v_stock_article := DBMS_RANDOM.VALUE(1, 100); -- Valeurs de stock entre 1 et 100
            v_id_categorie := DBMS_RANDOM.VALUE(1, 20); -- Valeurs d'Id_Categorie entre 1 et 20

            -- Insertion dans la table Article
            INSERT INTO Article(Id_Article, Libelle_article, Prix_article, TVA_article, Stock_article, Id_Categorie)
            VALUES(v_id_article, v_libelle_article, v_prix_article, v_tva_article, v_stock_article, ROUND(v_id_categorie));
        END LOOP;

    COMMIT; -- Valider les modifications
END;