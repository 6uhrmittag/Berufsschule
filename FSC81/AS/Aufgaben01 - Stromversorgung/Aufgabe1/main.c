#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
01.03.18
Marvin Heimbrodt

1. Aufgabe (Stromversorgung, ganze Zahlen und Kommazahlen)
Erstellen Sie ein Programm ÑStromkreiseì. Das Programm liest die Anzahl der PCs und die
Leistungsaufnahme eines PCs (in W, einschlieﬂlich Monitor) ein und soll daraus die
Gesamtleistung, die Gesamtstromst‰rke und die erforderliche Anzahl an Stromkreisen berechnen
und ausgeben. 
*/

int main(int argc, char *argv[]) {
	
	const double vorgabe_strom = 16;
	const double vorgabe_spannung = 230;
	
	double rechnung_leistung = 0;
	double rechnung_stromkreise = 0;
	
	int computer_anzahl = 0;
	int computer_leistung = 0;
	
	/* Eingabe */ 
	printf("Stromkreise\n");
	printf("###########\n\n");	
	
	printf("Strom pro Stromkreis   : %f\n", vorgabe_strom);
	printf("Spannung pro Stromkreis: %f\n", vorgabe_spannung);

	printf("Bitte geben Sie die Anzahl der Computer und die Leistungsaufnahme an\n");
	printf("Anzahl Computer: ");
	scanf("%d",&computer_anzahl);
	printf("Leistungsaufnahme in W(Durchschnitt): ");
	scanf("%d",&computer_leistung);

	printf("\nSie haben %d Computer mit einer Leistungsaufnahme von je %dWatt\n\n", computer_anzahl, computer_leistung);

	/*Berechnung*/
	rechnung_leistung = computer_anzahl * computer_leistung;
	rechnung_stromkreise = (rechnung_leistung / vorgabe_spannung)/vorgabe_strom;
	rechnung_stromkreise = ceil(rechnung_stromkreise);
	
	/*Ergebnisausgabe*/
	printf("Errechnete Gesammtleistung: %.0f\n", rechnung_leistung);
	printf("Errechnete Stromkreisanzahl: %0.f\n", rechnung_stromkreise);

	

	return 0;
}
