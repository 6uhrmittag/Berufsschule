public class Schachbrett_dezimalzahlen{
	public static void main (String[] args){
		
		//Datentypen: https://de.wikibooks.org/wiki/Java_Standard:_Primitive_Datentypen
		//Integer, 32 Bit, ganze Zahlen (-2.147.483.648 ... 2.147.483.647)
		int weizen_int = 1; //Variable hält Körner je Feld
		int ergebnis_int = 0; //Variable hält Gesamtzahl von Körnern
		
		//Float, 32 Bit, Kommazahlen (+/-1,4E-45 ... +/-3,4E+38)
		float weizen_float = 1; //Variable hält Körner je Feld
		float ergebnis_float = 0; //Variable hält Gesamtzahl von Körnern
		
		//Double, 64 Bit, Kommazahlen (+/-4,9E-324 ... +/-1,7E+308)
		double weizen_double = 1; //Variable hält Körner je Feld
		double ergebnis_double = 0; //Variable hält Gesamtzahl von Körnern
		
		//Strings für spätere Umwandlung von Zahlen zu Strings
		String zahl_zu_string = "";
		String zahl_zu_string_eine_kommastelle = "";
		String zahl_zu_string_zwei_kommastellen = "";

		
		for (int i = 1;i <=64 ; i++) {			//i hält Feldzahl
		
			System.out.println("INT:    Feld = " + i + " Anzahl Körner: " + weizen_int);
			ergebnis_int +=  weizen_int;
			weizen_int = weizen_int * 2;
		
			System.out.println("FLOAT:  Feld = " + i + " Anzahl Körner: " + weizen_float);
			ergebnis_float +=  weizen_float;
			weizen_float = weizen_float * 2;
			
			System.out.println("DOUBLE: Feld = " + i + " Anzahl Körner: " + weizen_double);
			ergebnis_double +=  weizen_double;
			weizen_double = weizen_double * 2;
			
			System.out.println("--------------------------------------------------------");
						
		}
		
		




		System.out.println("ENDE");
		System.out.println(""); 
		System.out.println("INT:    Auf allen Feldern liegen ingesamt " + ergebnis_int + " Körner."); 
		System.out.println("FLOAT:  Auf allen Feldern liegen ingesamt " + ergebnis_float + " Körner.");        
		System.out.println("DOUBLE: Auf allen Feldern liegen ingesamt " + ergebnis_double + " Körner.");
		
		
		//Umwandung, Formatierung und Ausgabe als String
		System.out.println(""); 
		System.out.println("--------------------------------------------------------");
		System.out.println("Gesamtanzahl zu String Umgewandelt und Formatiert:");

		//%.0f -> 
		zahl_zu_string = String.format ("%.0f", ergebnis_float);
		zahl_zu_string_eine_kommastelle = String.format("%.1f",ergebnis_float);
		zahl_zu_string_zwei_kommastellen = String.format("%.2f",ergebnis_float);

		System.out.println("0 Kommastelle(n):   " + zahl_zu_string);
		System.out.println("1 Kommastelle(n):   " + zahl_zu_string_eine_kommastelle);
		System.out.println("2 Kommastelle(n):   " + zahl_zu_string_zwei_kommastellen);		
		
	
	
		//Addition von vorher zu Strings umgewandelten Zahlen funktioniert nicht, da String + String einen neuen String ergibt.
		System.out.println(""); 
		System.out.println("--------------------------------------------------------");
		zahl_zu_string = zahl_zu_string_eine_kommastelle + zahl_zu_string_zwei_kommastellen;
   		System.out.println("String + String = " + zahl_zu_string);

	}
	
	
	
}