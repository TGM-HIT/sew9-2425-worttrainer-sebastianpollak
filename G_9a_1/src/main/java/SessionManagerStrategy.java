import java.io.IOException;

public interface SessionManagerStrategy {
    void saveToFile(Object object);
    WordTrainer loadFromFile() throws IOException;
}
