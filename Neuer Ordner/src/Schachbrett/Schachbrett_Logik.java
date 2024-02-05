package Schachbrett;

public class Schachbrett_Logik {

    private Schachbrett_Array schachbrett = new Schachbrett_Array();

    public Schachbrett_Array erstelleSchachbrett(){
        int [][] field = new int[8][8]; // schachbrett.getSchachbrett();

        for(int i=0; i< field.length; i++){
            for(int j=0; j < field[i].length;j++){
                int farbe = berechneFeldfarbe(i,j);
                schachbrett.setzeFeldfarbe(i,j,farbe);
            }
        }
        schachbrett.drawSchachBrett();
        return schachbrett;
    }

    public int berechneFeldfarbe(int row, int column){
        if((row + column) % 2 == 0){
            return 1;
        }
        else {
            return 0;
        }
    }

}
