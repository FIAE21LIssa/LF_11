package Parkhaus;

public class Eingangsschranke extends Schranke {

    static final Eingangsschranke einzigeEingangsschranke = new Eingangsschranke();

    Ticket neuesTicket;

    public static Eingangsschranke getInstance(){
        return einzigeEingangsschranke;
    }

    public Ticket erstelleTicket(){
            neuesTicket = new Ticket();
            System.out.println("Ticket wurde erstellt mit der ID: " + neuesTicket.getTicketNummer());
            return neuesTicket;
    }

    public Ticket getNeuesTicket(){
        return  neuesTicket;
    }
}
