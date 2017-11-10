public class Schachbrett_datentypen{
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
   					
	}
	
	
	
}