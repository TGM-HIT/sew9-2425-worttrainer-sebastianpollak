import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wortpaar Objekt
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public class WordPair {

    private String word = "";
    private String url = "";

    public WordPair(String word, String urlString) throws IllegalArgumentException {

        if(word.length() >= 1) {
            this.word = word;
        }
        else{
            throw new IllegalArgumentException("Wort zu kurz.");
        }

        try {
            URL url = new URL(urlString);
            BufferedImage image = ImageIO.read(url);
            if (image == null) {
                JOptionPane.showMessageDialog(null, "Das Bild konnte nicht geladen werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
            this.url = urlString;

        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Ungültige URL: " + e.getMessage(), "URL-Fehler", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes: " + e.getMessage(), "Ladefehler", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public String getWord() {
        return word;
    }

    public String getUrl() {
        return url;
    }

}
