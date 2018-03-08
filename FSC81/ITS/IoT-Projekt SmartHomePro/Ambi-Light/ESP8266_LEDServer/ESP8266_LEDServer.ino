#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>

const char* ssid = "WASZURHÖLLE";
const char* password = "12345678";

ESP8266WebServer server(80);

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
