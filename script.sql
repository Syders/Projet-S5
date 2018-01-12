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
   DatePublication DATETIME,
   IdUtilisateur VARCHAR(30),
   IdFilDiscussion INT(3),
   CONSTRAINT pk_message PRIMARY KEY(IdMessage),
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
