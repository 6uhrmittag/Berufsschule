#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
15.03.18
Marvin Heimbrodt

Erstellen Sie ein Programm „Dreieck“, welches drei Seitenlängen einliest und prüft, ob es sich
überhaupt um ein Dreieck handelt, und wenn ja, ob es ein rechtwinkliges Dreieck ist.
Beispiele:
Eingabe: Seitenlaenge 1: 3
Seitenlaenge 2: 4
Seitenlaenge 3: 5
Ausgabe: Das ist ein
 rechtwinkliges Dreieck.
Eingabe: Seitenlaenge 1: 2
Seitenlaenge 2: 2
Seitenlaenge 3: 8
Ausgabe: Das ist kein Dreieck.
Hinweise: Für Dreiecke gilt: a + b > c
 Für rechtwinklige Dreiecke gilt: 2 2 2
a + b = c

*/


int main(int argc, char *argv[]) {
	
	float epsilon = 0.00001;
	
	float seite_a = 0;
	float seite_b = 0;	
	float seite_c = 0;



	/* Eingabe */ 
	printf("Dreieck.");
	printf("\n###########\n\n");	
	
	printf("Seite a: ");	
	scanf("%f", &seite_a);
	
	printf("Seite b: ");	
	scanf("%f", &seite_b);
	
	printf("Seite c: ");	
	scanf("%f", &seite_c);
	

	/* Alarm */
	if ((seite_a + seite_b) >= seite_c ){
	
		if (  fabs( (seite_a*seite_a) + (seite_b*seite_b) - (seite_c*seite_c) ) <  epsilon) {
				printf("Dreieck rechtwinkelig.");
			
			}else{
				printf("Dreieck");
	
		}
	
		
	}else{
		printf("Kein Dreieck");

	}
	

		

	
	return 0;
}

	
