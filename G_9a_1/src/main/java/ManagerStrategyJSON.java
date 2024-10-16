import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ManagerStrategyJSON implements SessionManagerStrategy {
    private Gson gson = new Gson();

    @Override
    public void saveToFile(WordTrainerSession session) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("rightGuesses", session.getRightGuesses());
        jsonObject.addProperty("numberGuesses", session.getNumberGuesses());
        jsonObject.addProperty("random", session.getRandom());


        try (FileWriter fileWriter = new FileWriter("wordtrainerSave.json")) {
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadFromFile(WordTrainerSession session) throws IOException {
        try (FileReader fileReader = new FileReader("wordtrainerSave.json")) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();

            // Extrahiere die Integer-Werte
            session.setRightGuesses(jsonObject.get("rightGuesses").getAsInt());
            session.setNumberGuesses(jsonObject.get("numberGuesses").getAsInt());
            session.setRandom(jsonObject.get("random").getAsInt());


        }
    }

}
