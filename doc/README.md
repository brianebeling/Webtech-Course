# README

## Arbeitsaufteilung

Brian-Julian Ebeling
1530505

Ich habe quasi alles gemacht was mit Backend zu tun hatte. REST, Design, Testing und implementierung dieser. Außerdem hab ich noch das Design von der Website übernommen. 

## Testing

Getestet wurde das Projekt durch den Export der API in das Swagger 2.0 spec format und anschließend umgwewandelt in OpenAPI specs. Diese wurden in Postman implementiert und konnten dort einfach und bequen mit den von Postman generierten Tests und CURL befehlen via. Trial and Error getestet werden.

Außerdem hab ich von dort die JSON Beispiele exportiert. 

Die Swagger 2.0 specs können via localhost:8080/steam/resources/swagger.json aufgerufen werden und werden dynamisch generiert.

Als Server hab ich Glassfish ausgewählt, mit der JDK 8.