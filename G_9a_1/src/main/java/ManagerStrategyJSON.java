import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class ManagerStrategyJSON implements SessionManagerStrategy {
    private Gson gson = new Gson();

    @Override
    public void saveToFile(Object object) {

        try (FileWriter fileWriter = new FileWriter("wordtrainerSave.json")) {
            String json = gson.toJson(object);
            fileWriter.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WordTrainer loadFromFile() throws IOException {
        try (FileReader fileReader = new FileReader("wordtrainerSave.json")) {
            return gson.fromJson(fileReader, WordTrainer.class);
        }
    }

}
