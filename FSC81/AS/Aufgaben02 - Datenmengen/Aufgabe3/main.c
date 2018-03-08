#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
01.03.18
Marvin Heimbrodt

Erstellen Sie ein Programm „Serverschrankkuehlung“, welches drei logische Eingabewerte erhält:
- untereTemperaturUeberschritten (0 oder 1)
- obererTemperaturUeberschritten (0 oder 1)
- filterVerschmutzt (0 oder 1)
Aus diesen drei Eingangssignalen werden die folgenden logischen Ausgangssignale erzeugt:
- alarm (0 oder 1)
- luefterLangsam (0 oder 1)
- luefterSchnell (0 oder 1) 

*/


int main(int argc, char *argv[]) {
	
	int eingabe_dezimal = 0;
	
	int untereTemperaturUeberschritten = 0;
	int obererTemperaturUeberschritten = 0;
	int filterVerschmutzt = 0;

	int alarm = 0;
	int luefterLangsam = 0;
	int luefterSchnell = 0;

	/* Eingabe */ 
	printf("Serverschrankkuehlung.");
	printf("###########\n\n");	
	
	printf("untereTemperaturUeberschritten: ");	
	scanf("%d", &untereTemperaturUeberschritten);
	
	printf("obererTemperaturUeberschritten: ");	
	scanf("%d", &obererTemperaturUeberschritten);
	
	printf("filterVerschmutzt: ");	
	scanf("%d", &filterVerschmutzt);
	

	/* Alarm */
	if (obererTemperaturUeberschritten != 0 || filterVerschmutzt == 1 || untereTemperaturUeberschritten != 0){
		alarm = 1;
		//printf("Alarm!");	
	}
	
	if (untereTemperaturUeberschritten == 1){
		luefterLangsam = 1;
		luefterSchnell = 0;
		//printf("Lüfter langsam! \n");	
	}
	
	if (untereTemperaturUeberschritten == 1){
		luefterLangsam = 0;
		luefterSchnell = 1;
		//printf("Lüfter schnell! ");	
	}
		

	printf("Alarm: %d\n", alarm );	

	printf("luefterSchnell: %d\n", luefterSchnell);	

	printf("luefterLangsam: %d\n", luefterLangsam);	

	
	return 0;
}

