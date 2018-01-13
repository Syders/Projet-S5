package Interne;


import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steven
 */
public class Message {
    private String message;
    private Date date;
    private Personne auteur;

    public Message(String message, Date date, Personne auteur) {
        this.message = message;
        this.date = date;
        this.auteur = auteur;
    }
    
    public void afficherMessage(){
        System.out.println(auteur + " " + date + ": " + message + "\n");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.auteur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.auteur, other.auteur)) {
            return false;
        }
        return true;
    }
    
    
    
}
