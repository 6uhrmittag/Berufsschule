public class Schachbrett_1000000{
	public static void main (String[] args){
		float weizen = 1; //Variable hält Körner je Feld
		float ergebnis = 0; //Variable hält Gesamtzahl von Körnern
		for (int i = 1;i <=64 ; i++) {			//i hält Feldzahl
			System.out.println("Feld = " + i + " Anzahl Körner " + weizen);
			ergebnis +=  weizen;
			
			//Stoppe wenn auf einem Feld = oder > 1.000.000 Körner liegen
			if (weizen >= 1000000) {
				System.out.println("Es auf Feld " + i + " liegen genau oder über 1.000.000 Körner");
				break;
			}
			
			weizen = weizen * 2;			
		}
		System.out.println("Auf allen Feldern liegen ingesamt " + ergebnis + " Körner.");        
							
	}
	
	
}