package Parkhaus;

public class Autofahrer {

    private boolean fahren= true;
    private boolean anhalten = false;
    private final String kennzeichen;
    private BezahlAutomaten automaten = BezahlAutomaten.getInstance();

    public Autofahrer(String kennzeichen){
        this.kennzeichen = kennzeichen;
    }

    public String getKennzeichen(){
        return kennzeichen;
    }
    public void haltVorSchranke(Schranke schranke){
        this.anhalten = true;
        fahren = false;

        if(schranke instanceof Eingangsschranke){
            Eingangsschranke.einzigeEingangsschranke.erstelleTicket();
            ParkhausManager.getInstance().ticketAufnehmen(this,Eingangsschranke.einzigeEingangsschranke.getNeuesTicket());
        }
        else if(schranke instanceof Ausgangsschranke){
            Ausgangsschranke.einzigeAusgangsschranke.nehmeTicketEntgegen(ParkhausManager.getInstance().getTicketByKennzeichen(this.getKennzeichen()));
            Ticket ticket = ParkhausManager.getInstance().getTicketByKennzeichen(this.getKennzeichen());
            if(ticket.istBezahlt()) {
                ParkhausManager.getInstance().ticketVerwerten(this.getKennzeichen());
            }
        }


    }

    public boolean isHaltVorDerSchranke(){
        return anhalten;
    }

    public Ticket nehmeTicketEntgegen(){
        Eingangsschranke eingangsschranke = Eingangsschranke.getInstance();
        Ticket neuesTicket = eingangsschranke.getNeuesTicket();
        eingangsschranke.schrankeOeffnen();
        System.out.println("Ticket wurde entgegengenommen, Sie können jetzt durch die Schranke fahren " + Eingangsschranke.einzigeEingangsschranke.istSchrankeOffen);
        return neuesTicket;
    }

    public Ticket getTicket(){
        return Eingangsschranke.einzigeEingangsschranke.getNeuesTicket();
    }



    public void ticketBezahlen(){
        Ticket ticket=ParkhausManager.getInstance().getTicketByKennzeichen(this.getKennzeichen());
        automaten.ticketAnnehmen(ticket);
        System.out.println("Zu zahlender Betrag: " + ticket.getBetrag());
    }

    public void ticketEinfuehren(){
        Ausgangsschranke ausgangsschranke = Ausgangsschranke.getInstance();
        ausgangsschranke.nehmeTicketEntgegen(nehmeTicketEntgegen());

    }

    public void einwerfen(BezahlAutomaten.Muenze eingeworfeneMuenze){
        automaten.einwurf(eingeworfeneMuenze);
    }

    public void fahren(){
        if(Eingangsschranke.einzigeEingangsschranke.istSchrankeOffen) {
            this.fahren = true;
            anhalten = false;
            System.out.println("Sie sind durch die Schranke gefahren!");
            System.out.println("Die Schranke schließt sich wieder");
            Eingangsschranke.einzigeEingangsschranke.schrankeSchliessen();
            //System.out.println(Eingangsschranke.einzigeEingangsschranke.istSchrankeOffen());
        }
        else{System.out.println("Schranke ist zu - fahren nicht möglich!");}
    }

    public boolean getFahren(){
        return fahren;
    }

}
