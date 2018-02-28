public class klausuraufgabe {
   public static void main(String[] args) {
    
    System.out.println ("Hier beginnt Aufgabe 6");
    // Code fuer Aufgabe 6
    
    int zahl = 0;
    do {
      zahl++;
      //Wenn Zahl/gerade Zahl und Rest = 0, dann ist Zahl gerade 
      if (zahl%2 == 0) {
         System.out.println(zahl);  
      }

    } while (zahl <= 10);
    
    System.out.println ("Hier beginnt Aufgabe 7");
    // Code fuer Aufgabe 7
    
    zahl = 0;
    while (zahl <= 10) {
      //Wenn Zahl/gerade Zahl und Rest = 1, dann ist Zahl ungerade 
      if (zahl%2 == 1) {
         System.out.println(zahl);  
      }

      zahl++;
    }
    
    System.out.println ("Hier beginnt Aufgabe 8");
    // Code fuer Aufgabe 8
         
    for (zahl = 10; zahl>=0; zahl--) {
      
      switch (zahl) {
        case 2 : 
               System.out.println("Auf die Plätze!");
          break;
        case 1 : 
               System.out.println("Fertig!");
          break;
        case 0 : 
                System.out.println("Los!");
          break;
        default:
                System.out.println(zahl);  
      }

    }            
  }
}
