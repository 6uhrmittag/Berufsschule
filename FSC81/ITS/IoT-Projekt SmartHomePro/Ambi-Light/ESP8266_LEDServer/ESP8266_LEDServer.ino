#include <Adafruit_NeoPixel.h>
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>


const char* ssid = "WASZURHÖLLE";
//password mindestens 8  Zeichen
const char* password = "12345678";

ESP8266WebServer server(80);
  
  int eingabe_hex = 0;
  int rot = 0;
  int gruen = 0;
  int blau = 0;
  char sHexFarbcode[7];
  
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



void setup() {
  pinMode(BUILTIN_LED, OUTPUT);
  pinMode(BUILTIN_LED, LOW);

  // Öffne serielle Schnittstelle
  Serial.begin(115200);
  // Starte Access Point
  WiFi.disconnect();

  WiFi.mode(WIFI_AP);
  WiFi.softAP(ssid, password);
  // Ausgabe auf serieller Schnittstelle
  Serial.print("\nAccess Point bereit: ");
  Serial.println(ssid);

  //Starte den WEB-Server
  server.on("/", []() {
    server.send(200, "text/plain", "Herzlich willkommen!");
  });

  server.on("/led", []() {
    String state = server.arg("state");
    if (state == "on")
      digitalWrite(BUILTIN_LED, LOW);
    else if (state == "off")
      digitalWrite(BUILTIN_LED, HIGH);
    server.send(200, "text/plain", "Led is now " + state);
  });

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

  server.begin();
  // Ausgabe auf Schnittstelle
  Serial.print("Fertig! Mit 'http://");
  if (WiFi.getMode() == WIFI_AP)
    Serial.print(WiFi.softAPIP());
  else
    Serial.print(WiFi.localIP());

  Serial.println("/' verbinden!\n\n\n");
  pinMode(BUILTIN_LED, HIGH);
}

void loop(void) {
  server.handleClient();


  
}
