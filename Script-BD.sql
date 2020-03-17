DROP TABLE Utilisateur CASCADE CONSTRAINT PURGE
/
CREATE TABLE Utilisateur
(Login VARCHAR(30) CONSTRAINT PK_PRODUIT PRIMARY KEY,
Mdp VARCHAR(30),
isBibliothecaire NUMBER(1)
)
/
INSERT INTO Utilisateur (Login, Mdp, isBibliothecaire) VALUES ('Alexis', '123456',0);
INSERT INTO Utilisateur (Login, Mdp, isBibliothecaire) VALUES ('Antoine', '123456',1);

commit;