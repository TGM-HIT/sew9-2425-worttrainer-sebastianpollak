import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * JSON Strategy to Safe Worttrainer
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public class ManagerStrategyJSON implements SessionManagerStrategy {
    private Gson gson = new Gson();

    /**
     * Speichert übergebenen Worttrainer
     * @param session Worttrainer Session
     */
    @Override
    public void saveToFile(WordTrainerSession session) {

        //Erstellt JSON Objekt
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("rightGuesses", session.getRightGuesses());
        jsonObject.addProperty("numberGuesses", session.getNumberGuesses());
        jsonObject.addProperty("random", session.getRandom());

        //Speichert JSON
        try (FileWriter fileWriter = new FileWriter("wordtrainerSave.json")) {
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lädt die gespeicherten Statistiken in den übergebenen Worttrainer
     * @param session Worttrainer Session
     * @throws IOException
     */
    @Override
    public void loadFromFile(WordTrainerSession session) throws IOException {

        try (FileReader fileReader = new FileReader("wordtrainerSave.json")) {

            //Lädt das JSON Objekt
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();

            // Extrahiere die Integer-Werte
            session.setRightGuesses(jsonObject.get("rightGuesses").getAsInt());
            session.setNumberGuesses(jsonObject.get("numberGuesses").getAsInt());
            session.setRandom(jsonObject.get("random").getAsInt());

        }
    }

}
