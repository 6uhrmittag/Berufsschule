public class Schachbrett_for{
	public static void main (String[] args){
		float weizen = 1; //Variable hält Körner je Feld
		float ergebnis = 0; //Variable hält Gesamtzahl von Körnern
		for (int i = 1;i <=64 ; i++) {			//i hält Feldzahl
			System.out.println("Feld = " + i + " Anzahl Körner " + weizen);
			ergebnis +=  weizen;
			weizen = weizen * 2;			
		}
		System.out.println("Auf allen Feldern liegen ingesamt " + ergebnis + " Körner.");        
							
	}
	
	
}