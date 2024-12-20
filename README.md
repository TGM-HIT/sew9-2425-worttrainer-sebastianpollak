# Rechtschreibtrainer für Volksschulkinder

## Beschreibung

Dieses Java-Programm implementiert einen Rechtschreibtrainer, der speziell für Volksschulkinder entwickelt wurde. Die Kinder sollen dabei zu einem Bild (repräsentiert durch eine URL) das entsprechende Wort eingeben. Der Trainer vergleicht die eingegebene Antwort mit der richtigen Schreibweise und zeigt eine Erfolgsmeldung bei richtiger Eingabe oder eine Fehlermeldung bei falscher Eingabe.

## Funktionsumfang

- **Wort-Bild-Paare**: Jedes Paar besteht aus einem Wort und einer zugehörigen Bild-URL. Die Bild-URLs werden dynamisch geladen, um das richtige Bild zum Wort anzuzeigen.
- **Worttrainer**: Die Kinder können ein zufälliges Wort-Bild-Paar auswählen oder gezielt über einen Index darauf zugreifen.
- **Statistiken**: Der Trainer speichert, wie oft die Kinder insgesamt geraten haben und wie viele Antworten korrekt oder falsch waren.
- **Persistenz**: Der aktuelle Zustand des Trainers (alle Wortpaare und Statistiken) kann in eine Datei gespeichert und wiederhergestellt werden, sodass der Fortschritt auch nach einem Neustart des Programms erhalten bleibt.

## Technische Details

- **Model-Klassen**: Die Klassen `WordPair`, `WordList`, und `WordTrainer` bilden die Daten und Logik des Rechtschreibtrainers ab. Diese Klassen stellen sicher, dass die Daten zu jedem Zeitpunkt in einem gültigen Zustand sind (z.B. keine null-Werte oder ungültigen URLs).
- **GUI**: Die Interaktion mit dem Programm erfolgt über JOptionPane. Hier wird das aktuelle Bild angezeigt, und der Nutzer gibt das Wort zur Überprüfung ein. Die Statistiken und Rückmeldungen werden ebenfalls über Dialogfenster angezeigt.
- **JSON-Speicherung**: Die Daten des Trainers werden mittels GSON in eine JSON-Datei gespeichert und beim Start wieder geladen. So bleibt der Fortschritt auch nach Beenden des Programms erhalten.

## Installation

1. **Gradle**: Das Projekt verwendet Gradle als Build-Tool. Die GSON-Bibliothek wird automatisch durch Gradle eingebunden.
   
   In der `build.gradle` Datei:
   ```gradle
   dependencies {
       implementation 'com.google.code.gson:gson:2.10.1'
   }
   ```

2. **Starten des Programms**: Das Programm startet bei der Statistik immer beim Ursprungszustand. Durch den Laden Button kann der vorherige Zustand geladen werden.

## Ablauf

1. Ein zufälliges Wort-Bild-Paar wird ausgewählt.
2. Die Statistik und das Bild werden angezeigt.
3. Der Nutzer gibt das entsprechende Wort ein.
4. Das Programm überprüft die Eingabe und gibt Feedback.
5. Der Trainer speichert den aktuellen Zustand und die Statistiken bei Programmende.

**Erstellt von ChatGPT**