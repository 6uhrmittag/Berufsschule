
// Definitin Pins
const int analogInPin = A0;  
const int analogOutPin = D2; 

int probe = 0;       
int messspannung = 255;  

void setup() {
  // Verbindung
  Serial.begin(9600);
}

void loop() {


  analogWrite(analogOutPin, messspannung);
  Serial.print("\t Messpannung = ");
  Serial.println(messspannung);

  //Warten für Messung
  delay(200);
  probe = analogRead(analogInPin);
  //Warten für Messung

  delay(1000);
  Serial.print("Gemessener Wert = ");
  Serial.print(probe);


  //Warten

}
