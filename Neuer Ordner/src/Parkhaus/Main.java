package Parkhaus;

public class Main {

    public static void main (String [] args) {
        Autofahrer issa = new Autofahrer("HB-HI-789");
        issa.haltVorSchranke(Eingangsschranke.einzigeEingangsschranke);
        System.out.println(Eingangsschranke.einzigeEingangsschranke.istSchrankeOffen);
        issa.nehmeTicketEntgegen();
        issa.fahren();

        Autofahrer jan = new Autofahrer("H-AB-345");
        jan.haltVorSchranke(Eingangsschranke.einzigeEingangsschranke);
        jan.nehmeTicketEntgegen();
        jan.fahren();

        ParkhausManager.getInstance().zeigeAllegeparktenFahrzeuge();

        jan.ticketBezahlen();
        jan.haltVorSchranke(Ausgangsschranke.einzigeAusgangsschranke);
        ParkhausManager.getInstance().zeigeAllegeparktenFahrzeuge();
        jan.ticketBezahlen();
        jan.haltVorSchranke(Ausgangsschranke.einzigeAusgangsschranke);
        jan.einwerfen(BezahlAutomaten.Muenze.EURO_2);
        jan.einwerfen(BezahlAutomaten.Muenze.EURO_2);
        jan.einwerfen(BezahlAutomaten.Muenze.EURO_1);
        jan.einwerfen(BezahlAutomaten.Muenze.CENT_50);
        jan.einwerfen(BezahlAutomaten.Muenze.EURO_1);
        jan.haltVorSchranke(Ausgangsschranke.einzigeAusgangsschranke);
        jan.einwerfen(BezahlAutomaten.Muenze.EURO_2);
        jan.haltVorSchranke(Ausgangsschranke.einzigeAusgangsschranke);
        ParkhausManager.getInstance().zeigeAllegeparktenFahrzeuge();
    }


}
