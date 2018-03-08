# Quellcode

Der Code ist versioniert unter https://github.com/6uhrmittag/Berufsschule/tree/master/FSC81/ITS/IoT-Projekt%20SmartHomePro/Ambi-Light

# Arduino konfiguration
- NodeMCU .0
- COM 3

# Wichtig
- SSID-Password muss mindestens 8 Zeichen lang sein

# Verbindungstest
- Beispiel geladen "ESP8266LEDServer.ino"
- SSID und Password geändert


# Hinzufügen der Übergabe von Hex Prametern
Nimmt den Hex-Code an, wenn die URL "http:$IP/farbe?hex=FFFFFF" aufgerufen wird
-----------
```
server.on("/farbe", []() {
    //Annahme der Hex-Codes OHNE "#"
    String hex = server.arg("hex");

    //Test ob Farbe übernommen wurde
    server.send(200, "text/plain", "Farbe: " + hex);
    Serial.println(hex);
  });
```
----------
# Hinzufügen der Umrechung
Funktion aus AS umrechnung()
Umrechung unter https://github.com/6uhrmittag/Berufsschule/blob/master/FSC81/AS/Aufgaben01%20-%20Stromversorgung/Aufgabe3/main.c
-----------
```
  //Farbübertragung
  server.on("/farbe", []() {
    //Annahme der Hex-Codes OHNE "#"
    String hex = server.arg("hex");
    //Umwandlung in Char-Array
    hex.toCharArray(sHexFarbcode, 7);
    
    //Ausgabe der eingegebenen Farbe auf der Webseite
    //server.send(200, "text/plain", "Farbe: " + hex);
    Serial.println(hex);

    //Umrechung
    umrechnung(&rot, &gruen, &blau, sHexFarbcode);
    //Ausgabe der umgerechneten Farben auf der Webseite
    server.send(200, "text/plain", "Hex: " + hex + " Rot: " + rot + " Gruen: " + gruen +" Blau: " + blau);

  });
```
-------------
# LED Ansteuerung
## NeoPixel
Datenblatt: https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf
Bibliothek: Adafruit_NeoPixel.h (installiert via Arduino Verwaltung)
Bibliothek Doku: https://learn.adafruit.com/adafruit-neopixel-uberguide/arduino-library-use
Hinweis: auch mit onboard 3.3V nutzbar

Code Erweiterung um:
----------
```
//Definition für LED Pixel
//Anzahl in Konstanten
#define NUMPIXELS 8
//Angeschlossen an digital Pin
#define PIN D2 
Adafruit_NeoPixel pixels= Adafruit_NeoPixel(NUMPIXELS,PIN,NEO_GRB+NEO_KHZ800);
```
---------
void setup() {
//Initierung der NeoPixel
  pixels.begin(); // This initializes the NeoPixel library.
------------
```
    //Für jeden Pixel die Farbe setzen
    for(int i=0;i<NUMPIXELS;i++){
      pixels.setPixelColor(i, rot,gruen,blau); // Moderately bright green color.
    }
    //Farbe anzeigen
    pixels.show(); // This sends the updated pixel color to the hardware.
```
----------

