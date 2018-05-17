#include <iostream>
#include <malloc.h>
#include <string.h>
#include <conio.h>

// Forward-Declaration des Datentyp-Bezeichners Person
// typedef ist für die spätere Deklaration von Variablen ohne struct notwendig
typedef struct person Person;
typedef struct person
{
 char nachname[20+1];
 char vorname[20+1];
 char plz[5+1];
 char ort[20+1];
 char strasseHausNr[20+1];
 char telefon[20+1];
 Person* next;
} Person;


int main(int argc, char* argv[])
{
	
char eingabe_operation;
 //Definition und teilweise Initialisierung der Variable hans
 Person hans = {
"Meyer",
"Hans",
"12345",
"Berlin",
"Wilhelmstrasse 5",
"(030) 123 45 67"
 };

 // Zeiger auf erstes und "aktuelles" Listenelement
 Person *erste, *aktuelle;
 // Erstes Listenelement erzeugen
 erste = (Person*)malloc(sizeof(Person));
 aktuelle = erste;
 aktuelle -> next = NULL;
 // hans kopieren
 *aktuelle = hans;
 // Zweites Listenelement anhängen und teilweise Daten eintragen
 aktuelle = aktuelle -> next = (Person*)malloc(sizeof(Person));
 aktuelle -> next = NULL;
 strcpy(aktuelle -> nachname, "Klingbeil");
 strcpy(aktuelle -> vorname, "Susanne");
 strcpy(aktuelle -> telefon, "(030) 789 10 11");
 // Komplette Liste ausgeben
 aktuelle = erste;
 while(aktuelle != NULL)
 {
	 printf("%-20s %-20s %-20s\n", aktuelle -> nachname, aktuelle -> vorname,
	 aktuelle -> telefon);
	 aktuelle = aktuelle -> next;
 }
 
printf("\n+-----------------------------+-----------------------------+\n| Datei | Bearbeiten |\n+-----------------------------+-----------------------------+\n| Oe(f)fnen | Neuer (E)intrag |\n| (S)peichern | Komplette Liste (a)nzeigen |\n| (B)eenden | Einen Namen s(u)chen |\n| | Einen Eintrag (l)oeschen |\n+-----------------------------+-----------------------------+\n");

printf("\n\n");
printf("Waehle eine Operation[Buchstabe]:");
# vor %c ein Leerzeichen! -> https://gsamaras.wordpress.com/code/caution-when-reading-char-with-scanf-c/
scanf(" %c", &eingabe_operation);
printf("eingabe_operation = %c\n", eingabe_operation);


 fflush(stdin);
 _getch();
}

