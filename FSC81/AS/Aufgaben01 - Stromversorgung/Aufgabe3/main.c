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

void umrechnung(int* rot, int* gruen, int* blau, char sHexFarbcode[])
{
	int i=0;
	
	for(i; i<6; i++) {
			int wert = 0;
			char x = sHexFarbcode[i];
			
			if(x >='0' && x <='9') {
				x = x-'0';
				wert = x;
			}else{
	         switch(x) {
	        	case 'A': wert=10; break;
	        	case 'B': wert=11; break;
	        	case 'C': wert=12; break;
	        	case 'D': wert=13; break;
	        	case 'E': wert=14; break;
	        	case 'F': wert=15; break;
	        	case 'a': wert=10; break;
	        	case 'b': wert=11; break;
	        	case 'c': wert=12; break;
	        	case 'd': wert=13; break;
	        	case 'e': wert=14; break;
	        	case 'f': wert=15; break;
	            }
	      }
	      
		switch(i+1) {
			case 1: *rot = *rot + (wert * 16); break;
			case 2: *rot = *rot + (wert * 1); break;
			case 3: *gruen = *gruen + (wert * 16); break;
			case 4: *gruen = *gruen + (wert * 1); break;
			case 5: *blau = *blau + (wert * 16); break;
			case 6: *blau = *blau + (wert * 1); break;
		}    
	}
}
  	
  	
int main(int argc, char *argv[]) {
	
	int eingabe_hex = 0;
	
	int rot = 0;
	int gruen = 0;
	int blau = 0;
	
	char sHexFarbcode[7+1];
	
	/* Eingabe */ 
	printf("HexString2RGB.");
	printf("###########\n\n");	
	
	printf("Welche Hex-Farbe soll umgewandelt werden: #");	
  	scanf("%s", sHexFarbcode);
  	

	umrechnung(&rot, &gruen, &blau, sHexFarbcode);
	
	printf("rot: %d\n", rot);
	printf("gruen: %d\n", gruen);
	printf("blau: %d\n", blau);
	
	return 0;
}
