package Parkhaus;

public abstract class Schranke {

   protected boolean istSchrankeOffen = false;

    public void schrankeOeffnen(){
        istSchrankeOffen= true;
    }

    public void schrankeSchliessen(){
        istSchrankeOffen = false;
    }

    public boolean istSchrankeOffen(){
        return istSchrankeOffen;
    }

}
