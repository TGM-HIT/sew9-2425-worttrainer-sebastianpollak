import java.io.IOException;

/**
 * Worttrainer Session Manager um über Strategy zu Speichern oder zu laden.
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public class SessionManager {

    private SessionManagerStrategy strategy;

    public SessionManager(SessionManagerStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SessionManagerStrategy strategy) {
        this.strategy = strategy;
    }

    public void safeWordTrainer(WordTrainerSession wordTrainer) {
        strategy.saveToFile(wordTrainer);
    }

    public void loadWordTrainer(WordTrainerSession wordTrainer) throws IOException {
        strategy.loadFromFile(wordTrainer);
    }
}
