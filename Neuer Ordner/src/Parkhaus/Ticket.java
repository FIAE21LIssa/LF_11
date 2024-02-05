package Parkhaus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private static int ticketZaehler = 0;

    private LocalDateTime erstellungsZeitpunkt;
    private String ticketNummer;

    private double betrag;
    private boolean bezahlt;



    public Ticket() {
        this.erstellungsZeitpunkt = LocalDateTime.now().withNano(0);
        this.ticketNummer = generiereTicketNummer();
    }

    private String generiereTicketNummer() {
        ticketZaehler++;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String zeitpunktFormatiert = erstellungsZeitpunkt.format(formatter);
        return zeitpunktFormatiert + String.format("%03d", ticketZaehler);
    }

    public LocalDateTime getErstellungsZeitpunkt() {
        return erstellungsZeitpunkt;
    }

    public String getTicketNummer() {
        return ticketNummer;
    }

    public void setBetrag(double betrag){
        this.betrag = betrag;
    }

    public double getBetrag(){
        return betrag;
    }

    public void setBezahlt(boolean bezahlt){
        this.bezahlt = bezahlt;
    }

    public boolean istBezahlt(){
        return bezahlt;
    }

}
