package Parkhaus;

import java.time.Duration;
import java.time.LocalDateTime;

public class BezahlAutomaten {
    private static final BezahlAutomaten instance = new BezahlAutomaten();
    private Ticket aktuellVerarbeitetesTicket = new Ticket();
    LocalDateTime zahlungsZeitpunkt;
    //private double betrag;
    private boolean bezahlt = false;
    private double eingeworfenesGeld = 0.0;
    static boolean ticketVorhanden = false;

    Duration zeitspanne;
    Duration zeitspanneSimulieren;



    private BezahlAutomaten(){
        //Privater Konstruktor, um Instanziierung von außen zu verhindern
    }

    public static BezahlAutomaten getInstance(){
        return instance;
    }

    public Ticket getAktuellVerarbeitetesTicket(){
        return aktuellVerarbeitetesTicket;
    }
    public void ticketAnnehmen(Ticket ticket){
        zahlungsZeitpunkt = LocalDateTime.now().withNano(0);
        ticketVorhanden= true;
        //Das aktuell verarbeitete Ticket setzen
        aktuellVerarbeitetesTicket= ticket;
        zeitspanne = berechneZeitspanne(aktuellVerarbeitetesTicket.getErstellungsZeitpunkt(),zahlungsZeitpunkt);
        zeitspanneSimulieren = zeitspanne.plusHours(1).plusMinutes(10).withNanos(0);
        double betrag = berechneBetrag();
        aktuellVerarbeitetesTicket.setBetrag(betrag);
        aktuellVerarbeitetesTicket.setBezahlt(false); // Initialer Status: Nicht bezahlt

    }

    public Duration berechneZeitspanne(LocalDateTime erstellungsZeitpunkt, LocalDateTime bezahlungsZeitpunkt) {
        if (bezahlungsZeitpunkt != null && erstellungsZeitpunkt != null) {
            return Duration.between(erstellungsZeitpunkt, bezahlungsZeitpunkt);
        } else {
            throw new IllegalArgumentException("Ungültige Zeitstempel für die Berechnung der Zeitspanne");
        }
    }
    public double berechneBetrag(){
        long parkDauer = zeitspanneSimulieren.toHours(); //zeitspanne
        int parkDauerInt = (int) parkDauer;
        double betrag = 5.00;
        return betrag+(2*parkDauerInt);
    }



    public enum Muenze {
        CENT_50(0.5),
        EURO_1(1.0),
        EURO_2(2.0);

        private final double wert;
        Muenze(double wert) {
            this.wert=wert;
        }

        public double getWert(){
            return wert;
        }

    }
    public void einwurf(Muenze eingeworfeneMuenze){
        if (!bezahlt && eingeworfenesGeld < berechneBetrag()) {
            if (istGueltigeMuenze(eingeworfeneMuenze)) {
                eingeworfenesGeld += eingeworfeneMuenze.getWert();
                System.out.println("Eingeworfenes Geld: " + eingeworfenesGeld + " €");

                if(eingeworfenesGeld >=berechneBetrag()){
                    bezahlt=true;
                    if(aktuellVerarbeitetesTicket != null){
                        aktuellVerarbeitetesTicket.setBezahlt(true);
                        ticketVorhanden=false;

                        System.out.println("Ticket wurde vollständig bezahlt " +aktuellVerarbeitetesTicket.istBezahlt() + " und herausgegeben");
                        double rueckgeld = eingeworfenesGeld -berechneBetrag();
                        if(rueckgeld>0){
                            System.out.println("Entnehmemn Sie ihr Rückgeld: "+ rueckgeld + "€");
                        }
                        aktuellVerarbeitetesTicket = null;
                    }else {
                        System.out.println("Kein Ticket in Bearbeitung.");
                    }

                }
            }
        }
        else {
            System.out.println("Ungültige Münze wird ausgeworfen:" + eingeworfeneMuenze);
        }
    }
    public boolean istGueltigeMuenze(Muenze muenze){
        for(Muenze gueltigemuenze : Muenze.values()){
            if(gueltigemuenze == muenze){
                return true;
            }
        }
        return false;
    }

}
