public class Schachbrett_while{
	public static void main (String[] args){
		float weizen = 1; //Variable hält Körner je Feld
		float ergebnis = 0; //Variable hält Gesamtzahl von Körnern
		int feldzaehler = 1; //Variable hält Feldzahl. Datentyp "Int" reicht für 64 Werte	
		
		while (feldzaehler <= 64) {
			System.out.println("Feld = " + feldzaehler + " Anzahl Körner " + weizen);
			ergebnis +=  weizen;			
			weizen = weizen * 2;
			feldzaehler++; //feldzaehler = feldzaehler + 1
		}
		System.out.println("Auf allen Feldern liegen ingesamt " + ergebnis + " Körner.");        
							
	}
	
	
}