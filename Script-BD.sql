SET LINESIZE 200

DROP TABLE Utilisateur CASCADE CONSTRAINT PURGE;
DROP TABLE Document CASCADE CONSTRAINT PURGE;
DROP SEQUENCE seq_document;

CREATE TABLE Utilisateur
(Login VARCHAR(30) CONSTRAINT PK_UTILISATEUR PRIMARY KEY,
Mdp VARCHAR(30),
isBibliothecaire NUMBER(1)
)
;
CREATE TABLE Document
(NumDoc Number(5) CONSTRAINT PK_DOCUMENT PRIMARY KEY,
TypeDoc NUMBER(1),
Titre VARCHAR(30),
Auteur VARCHAR(30)
)
;

CREATE SEQUENCE seq_document
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

--INSERT INTO UTILISATEUR
INSERT INTO Utilisateur (Login, Mdp, isBibliothecaire) VALUES ('Alexis', '123456',0);
INSERT INTO Utilisateur (Login, Mdp, isBibliothecaire) VALUES ('Antoine', '123456',1);


--INSERT INTO DOCUMENT
INSERT INTO Document (NumDoc,TypeDoc,Titre,Auteur) VALUES (seq_document.NEXTVAL, 1,'Ulysse','Homere');
INSERT INTO Document (NumDoc,TypeDoc,Titre,Auteur) VALUES (seq_document.NEXTVAL, 2,'Cassiopee','Homere');
commit;