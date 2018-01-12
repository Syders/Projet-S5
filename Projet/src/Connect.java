/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

      String passwd = "A120120120a";

         

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
      inserer("INSERT INTO Utilisateur VALUES('" + IdUtilisateur + "', '" + Nom + "', '" + Prenom + ", '" + MotDePasse + "')");
  }

  public void ajouterGroupeUtilisateur(String NomGroupe) {
      inserer("INSERT INTO GroupeUtilisateur VALUES('" + NomGroupe + "')");
  }
  
  public void ajouterFilDiscussion(int IdFilDiscussion, String Titre, String IdUtilisateur, String NomGroupe) {
      inserer("INSERT INTO FilDiscussion VALUES(" + IdFilDiscussion + ", '" + Titre + "', '" + IdUtilisateur + "', '" + NomGroupe + "')");
  }

  public void ajouterMessage(int IdMessage, String Texte, String IdUtilisateur, int IdFilDiscussion) {
      inserer("INSERT INTO Message VALUES(" + IdMessage + ", '" + Texte + "', '" + IdUtilisateur + "', " + IdFilDiscussion + ")");
  }
  
  public void ajouterAppartient(String IdUtilisateur, String NomGroupe) {
      inserer("INSERT INTO Appartient VALUES('" + IdUtilisateur + "', '" + NomGroupe + "')");
  }

  public void supprimerUtilisateur(String IdUtilisateur) {
      inserer("DELETE FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "'");
  }

  public void supprimerGroupeUtilisateur(String NomGroupe) {
      inserer("DELETE FROM GroupeUtilisateur WHERE NomGroupe = '" + NomGroupe + "'");
  }

  public void supprimerAppartient(String IdUtilisateur, String NomGroupe) {
      inserer("DELETE FROM Appartient WHERE IdUtilisateur = '" + IdUtilisateur + "' and IdGrUtilisateur = '" + NomGroupe + "'");
  }
  
    private int selectInt(String chaine, String champ) {
        int val = -1;
    try {


         

      String url = "jdbc:mysql://localhost:3306/bddProjet";

      String user = "root";

      String passwd = "A120120120a";

         

      Connection conn = DriverManager.getConnection(url, user, passwd);

         

      //Création d'un objet Statement

      Statement state = conn.createStatement();

      //L'objet ResultSet contient le résultat de la requête SQL

      ResultSet result = state.executeQuery(chaine);
      
      while(result.next()){         
          val = result.getInt(champ);
      }


      result.close();

      state.close();

         

    } catch (Exception e) {

      e.printStackTrace();

    }    

    return val;
  }
    
  private String selectString(String chaine, String champ) {
      String val = "";
    try {


         

      String url = "jdbc:mysql://localhost:3306/bddProjet";

      String user = "root";

      String passwd = "A120120120a";

         

      Connection conn = DriverManager.getConnection(url, user, passwd);

         

      //Création d'un objet Statement

      Statement state = conn.createStatement();

      //L'objet ResultSet contient le résultat de la requête SQL

      ResultSet result = state.executeQuery(chaine);

      while(result.next()){         
          val = result.getString(champ);
      }


      result.close();

      state.close();

         

    } catch (Exception e) {

      e.printStackTrace();

    }      
    return val;
  }
  
  public String utilisateurNom(String IdUtilisateur) {
      return selectString("SELECT Nom FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "'", "Nom");
  }
  
  public String utilisateurPrenom(String IdUtilisateur) {
      return selectString("SELECT Prenom FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "'", "Prenom");
  }
  
  public String utilisateurMotDePasse(String IdUtilisateur) {
      return selectString("SELECT MotDePasse FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "'", "MotDePasse");
  }
  
  public String filDiscussionTitre(int IdFilDiscussion) {
      return selectString("SELECT Titre FROM FilDiscussion WHERE IdFilDiscussion = " + IdFilDiscussion, "Titre");
  }
  
  public String filDiscussionIdUtilisateur(int IdFilDiscussion) {
      return selectString("SELECT IdUtilisateur FROM FilDiscussion WHERE IdFilDiscussion = " + IdFilDiscussion, "IdUtilisateur");
  }
  
  public String filDiscussionNomGroupe(int IdFilDiscussion) {
      return selectString("SELECT NomGroupe FROM FilDiscussion WHERE IdFilDiscussion = " + IdFilDiscussion, "NomGroupe");
  }
  
  public String messageTexte(int IdMessage) {
      return selectString("SELECT Texte FROM Message WHERE IdMessage = " + IdMessage, "Texte");
  }
  
  public String messageIdUtilisateur(int IdMessage) {
      return selectString("SELECT IdUtilisateur FROM Message WHERE IdMessage = " + IdMessage, "IdUtilisateur");
  }
  
  public int messageIdFilDiscussion(int IdMessage) {
      return selectInt("SELECT IdFilDiscussion FROM Message WHERE IdMessage = " + IdMessage, "IdFilDiscussion");
  }
}
