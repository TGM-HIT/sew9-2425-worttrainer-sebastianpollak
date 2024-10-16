import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

public class TrainerLayout extends JPanel{

    private String URL = "";
    private ImageIcon icon;

    private JLabel trueWordsLabel, numberWordsLabel;

    private JButton resetB, addB, loadB, safeB;

    private JTextField input = new JTextField(7);

    private JPanel lineEnd = new JPanel();
    private JPanel pageStart = new JPanel();
    private JPanel pageEnd = new JPanel();
    private JPanel center = new JPanel();

    public TrainerLayout(WordTrainer control, WordTrainerSession session) throws MalformedURLException {

        this.setURL(session.getURL());

        this.setLayout(new BorderLayout(10,10));
        pageStart.setLayout(new BorderLayout(1,1));
        pageEnd.setLayout(new GridLayout(3,3));

        JLabel l = new JLabel("Welches Wort Wird unten dargestellt(Eingabe zum Überprüfen)?");
        pageStart.add(l, BorderLayout.PAGE_START);

        pageStart.add(input, BorderLayout.PAGE_END);
        input.addKeyListener(control); //Die eingegeben Antwort und der Keylistener um diese bei Enter zu übergeben.


        icon = new ImageIcon(new URL(URL)); //Fügt das Bild hinzu
        Image image = icon.getImage();
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        JLabel lImage = new JLabel(new ImageIcon(image));
        center.setLayout(new FlowLayout());
        center.add(lImage);

        pageEnd.add(new JLabel("Richtige Wörter"));
        trueWordsLabel = new JLabel(String.valueOf(session.getRightGuesses()));
        pageEnd.add(trueWordsLabel);
        resetB = new JButton("Zurücksetzen");
        resetB.setActionCommand("resetB");
        pageEnd.add(resetB);

        pageEnd.add(new JLabel("Anzahl Wörter"));

        numberWordsLabel = new JLabel(String.valueOf(session.getNumberGuesses()));
        pageEnd.add(numberWordsLabel);
        addB = new JButton("Wort hinzufügen");
        addB.setActionCommand("addB");
        pageEnd.add(addB);

        loadB = new JButton("Load");
        loadB.setActionCommand("loadB");
        pageEnd.add(loadB);

        safeB = new JButton("Safe");
        safeB.setActionCommand("safeB");
        pageEnd.add(safeB);

        this.add(pageStart, BorderLayout.PAGE_START);
        this.add(pageEnd, BorderLayout.PAGE_END);
        this.add(lineEnd, BorderLayout.LINE_END);
        this.add(center, BorderLayout.CENTER);

        this.resetB.addActionListener(control);
        this.addB.addActionListener(control);
        this.loadB.addActionListener(control);
        this.safeB.addActionListener(control);

    }

    /**
     * Setter und Getter Methoden für die URL
     * @return URL
     */
    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * Methode um den Input(Die Antwort im Textfeld) zurück zu geben.
     * @return Der Input
     */
    public String returnInput(){
        return input.getText();
    }

    /**
     * Methode für die Richige Antwort
     */
    public void trueAnswer(WordTrainerSession session){
        trueWordsLabel.setText(String.valueOf(session.getRightGuesses()));
        numberWordsLabel.setText(String.valueOf(session.getNumberGuesses()));
    }

    /**
     * Methode für die Falsche Antwor
     */
    public void wrongAnswer(WordTrainerSession session){
        trueWordsLabel.setText(String.valueOf(session.getRightGuesses()));
        numberWordsLabel.setText(String.valueOf(session.getNumberGuesses()));
    }

    /**
     * Methode um das Fenster zurück zu setzen.
     */
    public void reset(WordTrainerSession session){
        trueWordsLabel.setText(String.valueOf(0));
        numberWordsLabel.setText(String.valueOf(0));
    }

    /**
     * Methode um das Bild zu aktualisieren
     * @param url Die Url des bilds
     * @throws MalformedURLException Exception falls ein Fehler mit der URL vor liegt.
     */
    public void updateImage(String url) throws MalformedURLException {
        this.setURL(url);

        this.repaint();
        this.revalidate();

        center.removeAll(); //Entfernt das Bild

        icon = new ImageIcon(new URL(url)); //Ladet das neue bIld
        Image image = icon.getImage();
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        JLabel lImage = new JLabel(new ImageIcon(image));
        center.setLayout(new FlowLayout());
        center.add(lImage);
    }

    public void updateWordTrainer(WordTrainerSession wordTrainerSession) throws MalformedURLException {
        this.setURL(wordTrainerSession.getURL());

        this.repaint();
        this.revalidate();

        center.removeAll(); //Entfernt das Bild

        icon = new ImageIcon(new URL(wordTrainerSession.getURL())); //Ladet das neue bIld
        Image image = icon.getImage();
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        JLabel lImage = new JLabel(new ImageIcon(image));
        center.setLayout(new FlowLayout());
        center.add(lImage);

        trueWordsLabel.setText(String.valueOf(wordTrainerSession.getRightGuesses()));
        numberWordsLabel.setText(String.valueOf(wordTrainerSession.getNumberGuesses()));
    }
}

