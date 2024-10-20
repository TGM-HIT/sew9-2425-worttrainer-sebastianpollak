/**
 * Wortpaar Objekt
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public class WordPair {

    private String word = "";
    private String url = "";

    public WordPair(String word, String url) throws IllegalArgumentException {

        if(word.length() >= 1) {
            this.word = word;
        }
        else{
            throw new IllegalArgumentException("Wort zu kurz.");
        }

        this.url = url;
    }

    public String getWord() {
        return word;
    }

    public String getUrl() {
        return url;
    }

}
