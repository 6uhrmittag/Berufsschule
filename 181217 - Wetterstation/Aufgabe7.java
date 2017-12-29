// Aufgabe7 - Berechnungen mit Daten einer Wetterstation in einem Array.

public class Aufgabe7 {

  public static void main (String[] args) {
    System.out.println("Aufgabe 7 - Wetterstation\n");
    
    //Wetterdaten
    int []tag = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    int []temp = { 12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12};
    
    //Länge des Arrays wird durch arrayname.länge ausgerechnet
    int arraytag_groesse = tag.length;
   
    //Durchschnittstemperatur
    float temp_gesamt = 0;    
    for (int i = 0;i<=arraytag_groesse-1 ;i++ ) {
      //Gesamttemperatur ermitteln indem jeder Wert im Array zu der Variable "temp_gesamt" addiert wird.
      temp_gesamt = temp_gesamt+temp[i];       
    } // end of for     
    //Gesamttemperatur durch Größe des Arrays gerechnet ergibt die Durchschnittstemperatur
    double temp_durchschnitt = temp_gesamt/arraytag_groesse;


    //maximal, minimal Temperatur
    int temp_minimal = temp[0];
    int temp_maximal = temp[0];
    for (int i = 0;i<=arraytag_groesse-1 ;i++ ) {
      //Den ersten Temperaturwert im Array übernehmen und mit dem nächsten Wert vergleichen.
      //Wenn der Wert größer/kleiner ist, dann diesen Wert übernehmen
      
      //finde kleinsten Wert
      if (temp[i]<temp_minimal) {
         temp_minimal = temp[i];
      } // end of if
      //finde größten Wert
      if (temp[i]>temp_maximal) {
        temp_maximal = temp[i];
      } // end of if
    } // end of for

    //Temperatur Tabelle 
    System.out.println("-------------------------");
    System.out.println("| Tag  | Temperatur [°C]|");
    //Damit die Tabelle gleichmäßig dargestellt wird, wird ein extra Leerzeichen hinzugefügt, falls die Temperatur einstellig ist.    
    for (int i = 0;i<=arraytag_groesse-1 ;i++ ) {
      String fueller_tag = "";
      if (tag[i]<10) {
         fueller_tag = " ";  
      } // end of if
      String fueller_temp = "";
      if (temp[i]<10) {
         fueller_temp = " ";  
      } // end of if
      
      System.out.println("|  "+ tag[i] + fueller_tag + "  |    "+ temp[i] +fueller_temp +"          |");
             
    } // end of for     
    System.out.println("-------------------------");
    
    
    //Datenausgabe
    System.out.println("\nDurchschnittstemperatur über " +arraytag_groesse+ " Tage: "+temp_durchschnitt);
    System.out.println("Die minimale Temperatur war: " + temp_minimal);
    System.out.println("Die maximale Temperatur war: " + temp_maximal);
    System.out.println("\nENDE");
  }
}
