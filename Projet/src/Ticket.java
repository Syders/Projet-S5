
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steven
 */
public class Ticket {
    private Integer noTicket;
    private GroupePersonne groupeDestine;
    private Message premierMessage;
    private List<Message> message;

    public Ticket(Integer noTicket, GroupePersonne groupeDestine, Message premierMessage, List<Message> message) {
        this.noTicket = noTicket;
        this.groupeDestine = groupeDestine;
        this.premierMessage = premierMessage;
        this.message = message;
    }
    
    
}
