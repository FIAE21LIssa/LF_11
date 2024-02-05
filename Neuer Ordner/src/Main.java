import Parkhaus.Ausgangsschranke;
import Parkhaus.Autofahrer;
import Parkhaus.BezahlAutomaten;
import Parkhaus.Eingangsschranke;




public class Main {
    public static void main(String[] args) {

Autofahrer issa = new Autofahrer("HB-HI-987");
issa.haltVorSchranke(Eingangsschranke.getInstance());  // Vor der Eingangsschranke
issa.nehmeTicketEntgegen();
Eingangsschranke.getInstance().schrankeOeffnen();
issa.fahren();
Eingangsschranke.getInstance().schrankeSchliessen();
//issa.ticketBezahlen(Eingangsschranke.getInstance().getNeuesTicket());
issa.einwerfen(BezahlAutomaten.Muenze.EURO_2);
issa.einwerfen(BezahlAutomaten.Muenze.CENT_50);
issa.einwerfen(BezahlAutomaten.Muenze.CENT_50);
issa.einwerfen(BezahlAutomaten.Muenze.EURO_2);
issa.einwerfen(BezahlAutomaten.Muenze.EURO_2);
issa.haltVorSchranke(Ausgangsschranke.getInstance());

    }
}