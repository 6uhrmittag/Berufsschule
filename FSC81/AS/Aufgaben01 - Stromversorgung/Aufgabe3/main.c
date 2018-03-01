#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
01.03.18
Marvin Heimbrodt

Erstellen Sie ein Programm „HexString2RGB“, das eine Hexadezimale Farbcode-Zeichenkette als 
Eingabe annimmt und daraus die ganzzahligen Werte für die rote, grüne und blaue Komponente 
berechnet.  
*/


int main(int argc, char *argv[]) {
	
	int eingabe_hex = 0;
	
	char sHexFarbcode[7+1];
	
	/* Eingabe */ 
	printf("HexString2RGB.");
	printf("###########\n\n");	
	
	printf("Welche Hex-Farbe soll umgewandelt werden: #");	
  	scanf("%s", sHexFarbcode);
  	

	int i=0;
	for(i; i<6; i++) {
		char x = sHexFarbcode[i];
		
		if(zahl==5) {
			printf("fuenf\n");
		}
		
		//printf("Farbe eingegeben: %c\n", x);
	}


	
	
	
	return 0;
}
