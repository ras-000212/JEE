DROP TABLE Utilisateur CASCADE CONSTRAINT PURGE
/
CREATE TABLE Utilisateur
(Login VARCHAR(30) CONSTRAINT PK_PRODUIT PRIMARY KEY,
Mdp VARCHAR(30)
)
/
INSERT INTO Utilisateur (Login, Mdp) VALUES ('Alexis', '123456');
INSERT INTO Utilisateur (Login, Mdp) VALUES ('Antoine', '123456');

commit;