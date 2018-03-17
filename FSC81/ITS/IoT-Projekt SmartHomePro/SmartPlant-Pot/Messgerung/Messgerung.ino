//Setup Pins

#define analogInPin A0
#define analogOutPin D2




//Konstanten
#define messwert_max 1023
#define messspannung_werte 1023
#define messspannung_min 0
#define messspannung_max 3.24

#define messung_durchlaeufe 100

//Variablen

float messspannung_volt;
float gemessen_volt;

int gemessen_werte = 0;
int messung_out = 1023;

void setup() {
  // Serielle Verbindung starten
  Serial.begin(9600);
}

void loop() {
  
  for (messung_out; messung_out > 0; messung_out = messung_out - 10){
    
    //Messspannung ausgeben
    analogWrite(analogOutPin, messung_out);
    delay(100);

    //Mehrere Messungen pro Spannung durchführen
    for (int i = 0; i<messung_durchlaeufe;i++){
      gemessen_werte = gemessen_werte +analogRead(analogInPin);
    }
    //Mittelwert berechnen
    gemessen_werte = gemessen_werte / messung_durchlaeufe;

    //Berechung der Mess-Spannung
    messspannung_volt = messung_out * ( messspannung_max / messspannung_werte );
    //Berechung der gemessenen Spannung

    gemessen_volt = gemessen_werte * (messspannung_max / messwert_max);
       
    
    Serial.print("Out: ");
    Serial.println(messspannung_volt);
  
    Serial.print("Mess: ");
    Serial.println(gemessen_volt);

    
  }


}

