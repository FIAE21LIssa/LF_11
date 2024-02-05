package Schachbrett;

public class Schachbrett_Array {

  private int [][] schachbrett = new int[8][8];

  public Schachbrett_Array(){
    getSchachbrett();
  }

  public void setzeFeldfarbe( int row, int column, int farbe){
      schachbrett[row][column] = farbe;
  }

  public int [][] getSchachbrett(){

    return schachbrett;
  }

  public  void drawSchachBrett(){
    for (int [] row : schachbrett) {
      for (int farbe : row) {
        System.out.print(farbe + " ");
      }
      System.out.println();
    }
  }

}
