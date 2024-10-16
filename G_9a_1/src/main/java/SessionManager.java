import java.io.IOException;

public class SessionManager {

    private SessionManagerStrategy strategy;

    public SessionManager(SessionManagerStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SessionManagerStrategy strategy) {
        this.strategy = strategy;
    }

    public void safeWordTrainer(WordTrainer wordTrainer) {
        strategy.saveToFile(wordTrainer);
    }

    public void loadWordTrainer() throws IOException {
        strategy.loadFromFile();
    }
}
