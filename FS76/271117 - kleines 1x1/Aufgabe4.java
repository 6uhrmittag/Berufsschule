// Ausgabe des kleinen 1x1 mit verschiedenen Schleifenarten
public class Aufgabe4 {

  public static void main (String[] args) {
    System.out.println("Ausgabe des kleinen 1x1 mit verschiedenen Schleifenarten\n"); 
  
    //FOR Schleife
    System.out.println("Ausgabe mit for-Schleife:"); 
    //Äußere Schleife
    for (int i = 1;i <=10 ;i++ ) {
    System.out.println(i+"(n)er Reihe:");
      //Innere Schleife
      for (int b =1;b <=10 ;b++ ) {
      //Ausgabe
      System.out.println(b + " x " + i + " = " +  b*i);        
      } // end of for     
    } // end of for
    
    //WHILE Schleife
    System.out.println("\nAusgabe mit While-Schleife:"); 
    //Äußere Schleife
    int ia = 1;
    while(ia <= 10){
    System.out.println(ia+"(n)er Reihe:");
      //Innere Schleife    
      int ba = 1;
      while(ba <=10){
      //Ausgabe
      System.out.println(ba + " x " + ia + " = " +  ba*ia); 
      ba++;       
      }
    ia++;    
    }
    
   
   
   //DO-WHILE Schleife
    System.out.println("\nAusgabe mit Do-While-Schleife:"); 
    //Äußere Schleife
    int ib = 1;
    do{
    System.out.println(ib+"(n)er Reihe:");
      //Innere Schleife    
      int bb = 1;
      do{
      //Ausgabe
      System.out.println(bb + " x " + ib + " = " +  bb*ib); 
      bb++;       
      }while(bb <=10);
    ib++;    
    }while(ib <= 10);
  
  
  System.out.println("\nEnde"); 
  }
}