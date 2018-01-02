
import java.util.Set;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steven
 */
public class GroupePersonne {
    private String nomGroupe;
    private Set <Personne> listePersonne;

    public GroupePersonne(String nomGroupe, Set<Personne> listePersonne) {
        this.nomGroupe = nomGroupe;
        this.listePersonne = listePersonne;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }
    
    
}
