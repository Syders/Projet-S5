/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author steven
 */
//CTRL + SHIFT + O pour générer les imports

public class Connect {


  private void inserer(String chaine) {

    try {

      Class.forName("com.mysql.jdbc.Driver").newInstance();
         

      String url = "jdbc:mysql://localhost:3306/bddProjet?verifyServerCertificate=false&useSSL=true";

      String user = "root";

      String passwd = "";

         

      Connection conn = DriverManager.getConnection(url, user, passwd);

         

        try ( //Création d'un objet Statement
                Statement state = conn.createStatement()) {
            
            state.executeUpdate(chaine);
        }

         

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
    } catch (InstantiationException | IllegalAccessException ex) {
          Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
      }      

  }
  
  public void ajouterUtilisateur(String IdUtilisateur, String Nom, String Prenom, String MotDePasse) {
      inserer("INSERT INTO Utilisateur (IdUtilisateur, prenom, nom, motDePasse) VALUES ('" + IdUtilisateur + "', '" + Prenom + "', '" + Nom + "', '" + MotDePasse + "');");
  }

  public void ajouterGroupeUtilisateur(String NomGroupe) {
      inserer("INSERT INTO GroupeUtilisateur (NomGroupe) VALUES('" + NomGroupe + "');");
  }
  
  public void ajouterFilDiscussion(int IdFilDiscussion, String Titre, String IdUtilisateur, String NomGroupe) {
      inserer("INSERT INTO FilDiscussion (IdFilDiscussion,Titre,IdUtilisateur,NomGroupe) VALUES ('" + IdFilDiscussion + ", '" + Titre + "', '" + IdUtilisateur + "', '" + NomGroupe + "');");
  }

  public void ajouterMessage(int IdMessage, String Texte, String IdUtilisateur, int IdFilDiscussion) {
      inserer("INSERT INTO Message (IdMessage,Texte,Lue,IdUtilisateur,IdFilDiscussion) VALUES ('" + IdMessage + ", '" + Texte + "', '" + IdUtilisateur + "', '" + IdFilDiscussion + "');");
  }
  
  public void ajouterAppartient(String IdUtilisateur, String NomGroupe) {
      inserer("INSERT INTO Appartient (IdUtilisateur, NomGroupe) VALUES ('" + IdUtilisateur + "', '" + NomGroupe + "')"+ ";");
  }

  public void supprimerUtilisateur(String IdUtilisateur) {
      inserer("DELETE FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "'"+ ";");
  }

  public void supprimerGroupeUtilisateur(String NomGroupe) {
      inserer("DELETE FROM GroupeUtilisateur WHERE NomGroupe = '" + NomGroupe + "'"+ ";");
  }

  public void supprimerAppartient(String IdUtilisateur, String NomGroupe) {
      inserer("DELETE FROM Appartient WHERE IdUtilisateur = '" + IdUtilisateur + "' and IdGrUtilisateur = '" + NomGroupe + "'"+ ";");
  }
  
    private int selectInt(String chaine, String champ) {
        int val = -1;
    try {

      Class.forName("com.mysql.jdbc.Driver").newInstance();
         

      String url = "jdbc:mysql://localhost:3306/bddProjet?verifyServerCertificate=false&useSSL=true";

      String user = "root";

      String passwd = "";

         

      Connection conn = DriverManager.getConnection(url, user, passwd);

         

            //L'objet ResultSet contient le résultat de la requête SQL
            try ( //Création d'un objet Statement
                    Statement state = conn.createStatement(); //L'objet ResultSet contient le résultat de la requête SQL
                    ResultSet result = state.executeQuery(chaine)) {
                
                while(result.next()){
                    val = result.getInt(champ);
                }
                
                
            }

         

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
    } catch (InstantiationException | IllegalAccessException ex) {
          Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
      }

    return val;
  }
    
  private String selectString(String chaine, String champ) {
    String val = "";
    try {

     Class.forName("com.mysql.jdbc.Driver").newInstance();
         

      String url = "jdbc:mysql://localhost:3306/bddProjet";

      String user = "root";

      String passwd = "";


      Connection conn = DriverManager.getConnection(url, user, passwd);

         

          //L'objet ResultSet contient le résultat de la requête SQL
          try ( //Création d'un objet Statement
                  Statement state = conn.createStatement(); //L'objet ResultSet contient le résultat de la requête SQL
                  ResultSet result = state.executeQuery(chaine)) {
                  while(result.next()){
                      val=result.getString(champ);
                  }
              
              
          }

         

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
    } catch (InstantiationException | IllegalAccessException ex) {
          Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
      }
    return val;
  }
  
  
  private List selectGroupe(String chaine, String champ) {
    List val = new List();
    try {

     Class.forName("com.mysql.jdbc.Driver").newInstance();
         

      String url = "jdbc:mysql://localhost:3306/bddProjet";

      String user = "root";

      String passwd = "";


      Connection conn = DriverManager.getConnection(url, user, passwd);

         

          //L'objet ResultSet contient le résultat de la requête SQL
          try ( //Création d'un objet Statement
                  Statement state = conn.createStatement(); //L'objet ResultSet contient le résultat de la requête SQL
                  ResultSet result = state.executeQuery(chaine)) {
                  while(result.next()){
                      val.add(result.getString(champ));
                  }
              
              
          }

         

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
    } catch (InstantiationException | IllegalAccessException ex) {
          Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
      }
    return val;
  }
  
  public String utilisateurNom(String IdUtilisateur) {
      return selectString("SELECT Nom FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "';", "Nom");
  }
  
  public String utilisateurPrenom(String IdUtilisateur) {
      return selectString("SELECT Prenom FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "';", "Prenom");
  }
  
  public String utilisateurMotDePasse(String IdUtilisateur) {
      return selectString("SELECT MotDePasse FROM Utilisateur WHERE IdUtilisateur = '" + IdUtilisateur + "';", "MotDePasse");
  }
  
  public String filDiscussionTitre(int IdFilDiscussion) {
      return selectString("SELECT Titre FROM FilDiscussion WHERE IdFilDiscussion = " + IdFilDiscussion + "';", "Titre");
  }
  
  public String filDiscussionIdUtilisateur(int IdFilDiscussion) {
      return selectString("SELECT IdUtilisateur FROM FilDiscussion WHERE IdFilDiscussion = " + IdFilDiscussion+ "';","IdUtilisateur");
  }
  
  public String filDiscussionNomGroupe(int IdFilDiscussion) {
      return selectString("SELECT NomGroupe FROM FilDiscussion WHERE IdFilDiscussion = " + IdFilDiscussion + "';", "NomGroupe");
  }
  
  public String messageTexte(int IdMessage) {
      return selectString("SELECT Texte FROM Message WHERE IdMessage = " + IdMessage + "';", "Texte");
  }
  
  public String messageIdUtilisateur(int IdMessage) {
      return selectString("SELECT IdUtilisateur FROM Message WHERE IdMessage = " + IdMessage + "';", "IdUtilisateur");
  }
  
  public int messageIdFilDiscussion(int IdMessage) {
      return selectInt("SELECT IdFilDiscussion FROM Message WHERE IdMessage = " + IdMessage + "';", "IdFilDiscussion");
  }
  
    /**
     *
     * @return
     */
    public List groupeNomsGroupe() {
      return selectGroupe("SELECT * FROM GroupeUtilisateur ;","NomGroupe");
  }
}
