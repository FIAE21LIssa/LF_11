package Parkhaus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ParkhausManager {

    private static ParkhausManager instance;
    private int anzahlBelegteParkplatze = 0;
    private Map<String, Ticket> kennzeichenTicketMap;

    private ParkhausManager(){
        kennzeichenTicketMap = new HashMap<>();
    }

    public static ParkhausManager getInstance(){
        if (instance == null){
            instance = new ParkhausManager();
        }
        return instance;
    }

    public int getAnzahlBelegteParkplaetze(){
        return anzahlBelegteParkplatze;
    }

    public void ticketAufnehmen(Autofahrer autofahrer, Ticket ticket){
        kennzeichenTicketMap.put(autofahrer.getKennzeichen(), ticket);
        anzahlBelegteParkplatze +=1;
    }

    public Ticket getTicketByKennzeichen(String kennezichen){
        return kennzeichenTicketMap.get(kennezichen);
    }

    public void ticketVerwerten(String kennzeichen){
        kennzeichenTicketMap.remove(kennzeichen);
        anzahlBelegteParkplatze -=1;
    }

    public Ticket getTicketByTicketId(String ticketId){
        for(Ticket ticket : kennzeichenTicketMap.values()){
            if(ticket.getTicketNummer().equals(ticketId)){
                return ticket;
            }
        }
        return null;
    }
    public void anzeigenErstellungsZeitpunkt(String ticketId) {
        Ticket ticket = getTicketByTicketId(ticketId);

        if (ticket != null) {
            LocalDateTime erstellungsZeitpunkt = ticket.getErstellungsZeitpunkt();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatiert = erstellungsZeitpunkt.format(formatter);

            System.out.println("Erstellungszeitpunkt für Ticket ID " + ticketId + ": " + formatiert);
        } else {
            System.out.println("Kein Ticket für die angegebene Ticket ID gefunden.");
        }
    }

    public void zeigeAllegeparktenFahrzeuge(){
        for(Map.Entry<String,Ticket> entry : kennzeichenTicketMap.entrySet()){
            String kennzeichen = entry.getKey();
            Ticket ticket = entry.getValue();
            System.out.println("Kennzeichen: " + kennzeichen + ", Ticket ID: " + ticket.getTicketNummer());
        }

    }


}
