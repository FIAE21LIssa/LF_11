package Parkhaus;

public class Ausgangsschranke extends Schranke {



    static final Ausgangsschranke einzigeAusgangsschranke = new Ausgangsschranke();
    public static Ausgangsschranke getInstance(){
        return einzigeAusgangsschranke;
    }


    public void nehmeTicketEntgegen(Ticket ticket){
        System.out.println("Ticket wurde eingesteckt mit der ID: " + ticket.getTicketNummer());
        ticketVerarbeiten(ticket);
    }

    public void ticketVerarbeiten(Ticket ticket) {
        if (ticket.istBezahlt()){
            System.out.println("Ticket akzeptiert");
            schrankeOeffnen();
        } else {
            System.out.println("Ticket noch nicht bezahlt");
        }
    }
}
