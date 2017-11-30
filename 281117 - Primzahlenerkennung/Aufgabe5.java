//
// Aufgabe4
// Erkennung von Primzahlen                                         

public class Aufgabe5 {
  
  public static void main (String[] args) {
    System.out.println("Erkennung von Primzahlen\n"); 
    System.out.println("Hinweis: Mathematisch gesehen ist 1 keine Primzahl.\n");
    
    
    //Zählschleife Testet Zahlen von 1 bis 100
    for (int i=1; i<=1000;i++ ) {
      boolean  primzahl = true;
      
      for (int ia = 2; ia<i;ia++ ) {
        
        //Teile jede Zahl durch alle zahlen und setze Variable auf true, sobald Rest = 0 ist
        if (i%ia ==0)
        primzahl = false;
        
      } // end of for
      //Wenn Primzahl, dan Zahl ausgeben
      if (primzahl)
      System.out.println(i);
      
    }System.out.println("\nEnde");
  }  
}
