/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author steven
 */
//CTRL + SHIFT + O pour générer les imports

public class Connect {


  private void inserer(String chaine) {

    try {


         

      String url = "jdbc:mysql://localhost:3306/bddProjet";

      String user = "root";

      String passwd = "";

         

      Connection conn = DriverManager.getConnection(url, user, passwd);

         

      //Création d'un objet Statement

      Statement state = conn.createStatement();

      //L'objet ResultSet contient le résultat de la requête SQL

      state.executeUpdate(chaine);

      state.close();

         

    } catch (Exception e) {

      e.printStackTrace();

    }      

  }
  
  public void ajouterUtilisateur(String IdUtilisateur, String Nom, String Prenom, String MotDePasse) {
      inserer("INSERT INTO Utilisateur VALUES(" + IdUtilisateur + ", '" + Nom + "', '" + Prenom + ", '" + MotDePasse + "')");
  }

  public void ajouterGroupeUtilisateur(String NomGroupe) {
      inserer("INSERT INTO GroupeUtilisateur VALUES(" + NomGroupe + "')");
  }
  
  public void ajouterFilDiscussion(int IdFilDiscussion, String Titre, String IdUtilisateur, String NomGroupe) {
      inserer("INSERT INTO FilDiscussion VALUES(" + IdFilDiscussion + ", '" + Titre + "', " + IdUtilisateur + ", " + NomGroupe + ")");
  }

  public void ajouterMessage(int IdMessage, String Texte, String IdUtilisateur, int IdFilDiscussion) {
      inserer("INSERT INTO Message VALUES(" + IdMessage + ", '" + Texte + "', " + IdUtilisateur + ", " + IdFilDiscussion + ")");
  }
  
  public void ajouterAppartient(String IdUtilisateur, String NomGroupe) {
      inserer("INSERT INTO Appartient VALUES(" + IdUtilisateur + ", " + NomGroupe + ")");
  }

  public void supprimerUtilisateur(String IdUtilisateur) {
      inserer("DELETE FROM Utilisateur WHERE IdUtilisateur = " + IdUtilisateur);
  }

  public void supprimerGroupeUtilisateur(String NomGroupe) {
      inserer("DELETE FROM GroupeUtilisateur WHERE NomGroupe = " + NomGroupe);
  }

  public void supprimerAppartient(int IdUtilisateur, String NomGroupe) {
      inserer("DELETE FROM Appartient WHERE IdUtilisateur = " + IdUtilisateur + " and NomGroupe= " + NomGroupe);
  }
}
