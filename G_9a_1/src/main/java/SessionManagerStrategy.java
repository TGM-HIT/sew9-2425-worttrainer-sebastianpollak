import java.io.IOException;

public interface SessionManagerStrategy {
    void saveToFile(WordTrainerSession session);
    void loadFromFile(WordTrainerSession session ) throws IOException;
}
