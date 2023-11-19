CREATE TABLE Categorie(
   Id_Categorie NUMBER(10),
   Nom_categorie VARCHAR2(50)  NOT NULL,
   PRIMARY KEY(Id_Categorie)
);

CREATE TABLE Utilisateur(
   Id_Utilisateur NUMBER(10),
   Nom_utilisateur VARCHAR2(50)  NOT NULL,
   Prenom_utilisateur VARCHAR2(50)  NOT NULL,
   Role VARCHAR2(50) ,
   PRIMARY KEY(Id_Utilisateur)
);

CREATE TABLE Panier(
   Id_Panier NUMBER(10),
   Validation_panier NUMBER(3) NOT NULL,
   Id_Utilisateur NUMBER(10) NOT NULL,
   PRIMARY KEY(Id_Panier),
   FOREIGN KEY(Id_Utilisateur) REFERENCES Utilisateur(Id_Utilisateur)
);

CREATE TABLE Devis(
   Id_Devis NUMBER(10),
   Validation_devis NUMBER(10),
   Id_Panier NUMBER(10),
   PRIMARY KEY(Id_Devis),
   FOREIGN KEY(Id_Panier) REFERENCES Panier(Id_Panier)
);

CREATE TABLE Article(
   Id_Article NUMBER(10),
   Libelle_article VARCHAR2(50)  NOT NULL,
   Prix_article NUMBER(10) NOT NULL,
   TVA_article NUMBER(10) NOT NULL,
   Stock_article NUMBER(5) NOT NULL,
   Id_Categorie NUMBER(10),
   PRIMARY KEY(Id_Article),
   FOREIGN KEY(Id_Categorie) REFERENCES Categorie(Id_Categorie)
);

CREATE TABLE Associer(
   Id_Associer NUMBER(20),
   Id_Categorie NUMBER(10),
   Id_Employee NUMBER(10),
   PRIMARY KEY(Id_Associer),
   FOREIGN KEY(Id_Categorie) REFERENCES Categorie(Id_Categorie),
   FOREIGN KEY(Id_Employee) REFERENCES Utilisateur(Id_Utilisateur)
);

CREATE TABLE Panier_Article(
   Id_Panier_Article NUMBER(20),
   Id_Article NUMBER(10),
   Id_Panier NUMBER(10),
   PRIMARY KEY(Id_Panier_Article),
   FOREIGN KEY(Id_Article) REFERENCES Article(Id_Article),
   FOREIGN KEY(Id_Panier) REFERENCES Panier(Id_Panier)
);
