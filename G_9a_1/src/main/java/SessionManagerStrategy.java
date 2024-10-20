import java.io.IOException;

/**
 * Worttrainer Speichern und Laden Stratergy Interface
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public interface SessionManagerStrategy {
    void saveToFile(WordTrainerSession session);
    void loadFromFile(WordTrainerSession session ) throws IOException;
}
