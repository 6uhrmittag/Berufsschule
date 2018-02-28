//Berechnungen mit Zahlen in einem Array unter verwendung von Modulo

public class Aufgabe8 {

  public static void main (String[] args) {

    int zahl = 0;
    int qs = 0;
    int qp = 0;
    boolean ersterdurchgang = true;
    int[] quersummen = new int[28];
    
    //Für jede Zahl bis 1000
    for (int i = 0;i<=1000 ;i++) {
    //System.out.println(zahl);  
         zahl = i;
         qs = 0;
         qp = 0;
         ersterdurchgang = true;
         
      
      while (zahl != 0) { 
            qs = qs + (zahl%10);
        if (ersterdurchgang) {
           qp = zahl%10;
           ersterdurchgang = false;
        } else{
           qp = qp * ( zahl%10);   
          }
          // end of if

            zahl=zahl/10;  
      } // end of while
      quersummen[qs]++;
      if (qs == 15) {
      System.out.println(i + " Quersumme ist 15");   
      } // end of if
      if (qs%7 == 0 & i != 0) {
      System.out.println(i +" Quersumme ist ein vielfaches von 7.");   
      } // end of if
      if (qs*qp == i & i != 0) {
      System.out.println(i +" Quersumme * Querprodukt ergibt die Zahl selbst.");   
      } // end of if
      
    }
    //Quersumme finden die maximal oft vorkommt
    int quersumme_maximal = 0;
    int quersumme_maximal_gesamt = 0; 
    System.out.println();         
      for (int d = 0;d<=quersummen.length-3 ;d++ ) {
      if (quersummen[d]>quersumme_maximal) {
        quersumme_maximal = quersummen[d];
        quersumme_maximal_gesamt = d;
      }
    }
    System.out.println("Die Quersumme " + quersumme_maximal + " kommt " + quersumme_maximal_gesamt + " (und damit am öftesten) mal vor."); 
  
  
  
  System.out.println("\nENDE");  
  }
}
