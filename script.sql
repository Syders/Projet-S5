CREATE TABLE Utilisateur
  (IdUtilisateur VARCHAR(30),
   Nom VARCHAR(30),
   Prenom VARCHAR(30),
   MotDePasse VARCHAR(16),
   CONSTRAINT pk_utilisateur PRIMARY KEY(IdUtilisateur)
);
CREATE TABLE GroupeUtilisateur
  (NomGroupe VARCHAR(30),
   CONSTRAINT pk_groupeutilisateur PRIMARY KEY(NomGroupe)
);
CREATE TABLE FilDiscussion
  (IdFilDiscussion INT(3),
   Titre VARCHAR(30),
   IdUtilisateur VARCHAR(30),
   NomGroupe VARCHAR(30),
   CONSTRAINT pk_fildiscussion PRIMARY KEY(IdFilDiscussion),
   CONSTRAINT fk_fildiscussion_utilisateur FOREIGN KEY(IdUtilisateur)
                               REFERENCES Utilisateur(IdUtilisateur),
   CONSTRAINT fk_fildiscussion_groupeutilisateur FOREIGN KEY(NomGroupe)
                               REFERENCES GroupeUtilisateur(NomGroupe)
);
CREATE TABLE Message
  (IdMessage INT(4),
   Texte VARCHAR(200),
   Lue INT(1),
   IdUtilisateur VARCHAR(30),
   IdFilDiscussion INT(3),
   CONSTRAINT pk_message PRIMARY KEY(IdMessage),
   CONSTRAINT ck_lue CHECK (Lue<=2 AND Lue>=1),
   CONSTRAINT fk_message_utilisateur FOREIGN KEY(IdUtilisateur)
                         REFERENCES Utilisateur(IdUtilisateur),
   CONSTRAINT fk_message_fildiscussion FOREIGN KEY(IdFilDiscussion)
                         REFERENCES FilDiscussion(IdFilDiscussion)
);
CREATE TABLE Appartient
  (IdUtilisateur VARCHAR(30),
   NomGroupe VARCHAR(30),
   CONSTRAINT pk_appartient PRIMARY KEY(IdUtilisateur, NomGroupe),
   CONSTRAINT fk_appartient_utilisateur FOREIGN KEY(IdUtilisateur)
                             REFERENCES Utilisateur(IdUtilisateur),
   CONSTRAINT fk_appartient_groupeutilisateur FOREIGN KEY(NomGroupe)
                             REFERENCES GroupeUtilisateur(NomGroupe)   
);

INSERT INTO Utilisateur (IdUtilisateur, prenom, nom, motDePasse)
VALUES
('Alpha','Aaron','James','A158'),
('Bravo','Jones','George','&dsq'),
('Charlie','Vioe','Patrick','m84?'),
('Delta','Parrot','Sael',':)hj'),
('Echo','Farraday','Ilo','kji7'),
('Foxtrot','Geordi','Atori','ndm7'),
('Golf','Lia','Manon','v9d4'),
('Hotel','Poal','Julia','hjup'),
('India','Krap','Masri','hjhk'),
('Juliett','Asop','Rael','qdfq');

INSERT INTO GroupeUtilisateur (NomGroupe)
VALUES
('A'),('Technical'),('B'),('C');

INSERT INTO FilDiscussion (IdFilDiscussion,Titre,IdUtilisateur,NomGroupe)
VALUES
(1,'Souci','Alpha','Technical'),
(2,'Resolu','India','A'),
(3,'Probleme','Echo','C');

INSERT INTO Appartient (IdUtilisateur, NomGroupe)
VALUES
('Alpha','A'),
('Bravo','B'),
('Charlie','C'),
('Delta','Technical'),
('Echo','A'),
('Echo','B'),
('Foxtrot','C'),
('Golf','B'),
('Hotel','A'),
('Hotel','C'),
('India','Technical'),
('Juliett','Technical');

INSERT INTO Message (IdMessage,Texte,Lue,IdUtilisateur,IdFilDiscussion)
VALUES
(1,'Bonjour problème A3',1,'Alpha',1),
(2,'J ai pris en compte votre message',1,'India',1),
(3,'Problème résolu sur A3',1,'India',2),
(4,'Explosion en cours sur B2',2,'Echo',3),
(5,'Merci',2,'Alpha',2);
