import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Worttrainer Test
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public class WordTrainerTest {

    private WordTrainerSession wordTrainerSession;
    private SessionManager sessionManager;
    private WordTrainer wordTrainer;

    @BeforeEach
    void setUp() throws MalformedURLException {

        WordList wordList = new WordList();

        WordPair wordPair1 = new WordPair("Baum", "https://images.squarespace-cdn.com/content/v1/60472827fe54df702f7eb4c7/1617090977550-OBXG6PPUEXFZE47TBMQB/was-kostet-ein-baum-sommerlinde-2-baumschule-oekoplant-wels.jpg"); //Erstellt Worteintröge und testet WortEintrag Klasse
        WordPair wordPair2 = new WordPair("Hund", "https://www.br.de/radio/bayern1/bild-gesund-hund-104~_v-img__16__9__xl_-d31c35f8186ebeb80b0cd843a7c267a0e0c81647.jpg?version=fa8e8");
        WordPair wordPair3 = new WordPair("Katze", "https://media.4-paws.org/a/5/c/4/a5c4c9cdfd3a8ecb58e9b1a5bd496c9dfbc3cedc/VIER%20PFOTEN_2020-10-07_00132-2890x2000-1920x1329.jpg");
        WordPair wordPair4 = new WordPair("Fisch", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Carassius_gibelio_2008_G3.jpg/1200px-Carassius_gibelio_2008_G3.jpg");
        WordPair wordPair5 = new WordPair("Pferd", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Horse_December_2014-1.jpg/1200px-Horse_December_2014-1.jpg");
        WordPair wordPair6 = new WordPair("Schwein", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSvSZslxetdlSuj5Fhuh1w5kPtKRLbnOmbCBTc86EjGi_SHTuJp0qbcbXhO-cgXfF0LG4&usqp=CAU");
        WordPair wordPair7 = new WordPair("Huhn", "https://huehnerhaltung.org/wp-content/uploads/vorstellung_new_hampshire_huhn.png");
        WordPair wordPair8 = new WordPair("Kuh", "https://www.br.de/radio/bayern2/sendungen/radiowissen/kuh-104~_v-img__16__9__xl_-d31c35f8186ebeb80b0cd843a7c267a0e0c81647.jpg?version=52356");
        WordPair wordPair9 = new WordPair("Vogel", "https://image.geo.de/30096032/t/Yc/v3/w960/r0/-/einen-vogel-haben-jpg--3115-.jpg");
        WordPair wordPair10 = new WordPair("Frosch", "https://image.geo.de/30023672/t/j2/v3/w1440/r1/-/frosch-gross-jpg--5857-.jpg");

        wordList.addWordPair(wordPair1);
        wordList.addWordPair(wordPair2);
        wordList.addWordPair(wordPair3);
        wordList.addWordPair(wordPair4);
        wordList.addWordPair(wordPair5);
        wordList.addWordPair(wordPair6);
        wordList.addWordPair(wordPair7);
        wordList.addWordPair(wordPair8);
        wordList.addWordPair(wordPair9);
        wordList.addWordPair(wordPair10);

        wordTrainerSession = new WordTrainerSession(wordList);

        sessionManager = new SessionManager(new ManagerStrategyJSON());
        wordTrainer = new WordTrainer(wordList);

    }

    @Test
    void testCheckAnswer_CorrectAnswer() {

        String correctAnswer = "Hund";

        // Setzt derzeitge Auswahl des Wortpaares auf das Richtige
        wordTrainerSession.setRandom(1);
        // Überprüfe, dass die Methode true zurückgibt
        assertTrue(wordTrainerSession.checkAnswer(correctAnswer));

        // Überprüfe, dass rightGuesses inkrementiert wurde
        assertEquals(1, wordTrainerSession.getRightGuesses());

        // Überprüfe, dass numberGuesses ebenfalls inkrementiert wurde
        assertEquals(1, wordTrainerSession.getNumberGuesses());
    }

    @Test
    void testCheckAnswer_WrongAnswer() {

        String wrongAnswer = "Hund";

        // Setzt derzeitge Auswahl des Wortpaares auf das Falsche
        wordTrainerSession.setRandom(2);

        // Überprüfe, dass die Methode false zurückgibt
        assertFalse(wordTrainerSession.checkAnswer(wrongAnswer));

        // Überprüfe, dass rightGuesses nicht inkrementiert wurde
        assertEquals(0, wordTrainerSession.getRightGuesses());

        // Überprüfe, dass numberGuesses inkrementiert wurde
        assertEquals(1, wordTrainerSession.getNumberGuesses());
    }

    @Test
    void testCheckSafeAndLoad() throws IOException {

        //Erstellt Testdaten
        wordTrainerSession.setNumberGuesses(1);
        wordTrainerSession.setRandom(6);
        wordTrainerSession.setRightGuesses(1);

        //Speichert Testdaten
        sessionManager.safeWordTrainer(wordTrainerSession);

        //Veränder Testdaten
        wordTrainerSession.setNumberGuesses(6);
        wordTrainerSession.setRandom(1);
        wordTrainerSession.setRightGuesses(6);

        //Lädt Testdaten
        sessionManager.loadWordTrainer(wordTrainerSession);

        //Überprüft ob Testdaten unverändert geladen wurden.
        assertEquals(1, wordTrainerSession.getNumberGuesses());
        assertEquals(6, wordTrainerSession.getRandom());
        assertEquals(1, wordTrainerSession.getRightGuesses());

    }

}
