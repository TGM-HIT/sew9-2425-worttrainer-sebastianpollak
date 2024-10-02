import java.util.ArrayList;
import java.util.List;

public class WordList {

    private List<WordPair> wordlist;

    public WordList() {
        wordlist = new ArrayList<>();
    }

    public void addWordPair(WortEintrag entry) {
        wordlist.add(entry);
    }

    public boolean removeWordPair(String word) {
        return wordlist.removeIf(entry -> entry.getWord().equals(word));
    }

    public WordPair getWordPair(int i) {
        if (wordlist.isEmpty()) {
            System.out.println("Keine WortEinträge in der Liste.");
        } else {
            return wordlist.get(i)
        }
    }

    public List<WordPair> getWordlist() {
        return wordlist;
    }

}
