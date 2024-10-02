public class WordPair {

    private String word = "";
    private String url = "";

    public WortEintrag(String word, String url) throws IllegalArgumentException {

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
