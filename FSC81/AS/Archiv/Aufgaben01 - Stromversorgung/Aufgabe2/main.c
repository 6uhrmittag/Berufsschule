#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
01.03.18
Marvin Heimbrodt

Erstellen Sie ein Programm „Binärzahlen“. Das Programm liest die Ziffern einer ganzen Zahl als
Dezimalzahl ein und gibt die Ziffern der entsprechenden Binärdarstellung aus. 
*/


int main(int argc, char *argv[]) {
	
	int eingabe_dezimal = 0;
	
	/* Eingabe */ 
	printf("Binaerzahlen.");
	printf("Umwandlung von Dezimalzahlen in Binaerzahlen\n");
	printf("###########\n\n");	
	
	printf("Welche Dezimalzahl soll umgewandelt werden: ");	
	scanf("%d", &eingabe_dezimal);
	
	printf("\nEingabe war %d\n", eingabe_dezimal);	
	
	
	
	return 0;
}
