import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WordTrainer implements ActionListener, KeyListener {
	private TrainerFrame GF;
	private TrainerLayout GP;
	private WordTrainerSession WT;

	public WordTrainer(WordList WL) throws MalformedURLException {
		WT = new WordTrainerSession(WL);
		GP = new TrainerLayout(this, WT);
		GF = new TrainerFrame(GP);
	}

	/**
	 * Action Performed Klasse um den Buttons Funktionen zu geben,
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String o = e.getActionCommand();

		switch (o) {
			case "resetB":
				WT.reset();
				GP.reset(WT);
				break;

			case "addB":
				String word = JOptionPane.showInputDialog(null, "Wort:");
				String url = JOptionPane.showInputDialog(null, "Link:");
				WordPair add = new WordPair(word, url); //Erstellt Worteintrag um diesen hinzu zu fügen.
				WT.getWordList().addWordPair(add);
				break;

			case "loadB":
				try {
					WT.getSessionManager().loadWordTrainer(WT);
					GP.updateWordTrainer(WT);
				} catch (IOException ex) {
					System.out.println("Fehler beim Laden. Laden des Standardpfad nicht möglich.");
				}

			case "safeB":
                WT.getSessionManager().safeWordTrainer(WT);
        }
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	/**
	 * KeyListener Methode um auf Enter das Wort zu überprüfen.
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e){
		boolean result = false;
		if(e.getKeyCode() == 10){
			result = WT.checkAnswer(GP.returnInput());

			if(result == true){
				GP.trueAnswer(WT);
			}else{
				GP.wrongAnswer(WT);
			}

			try {
				GP.updateImage(WT.getURL()); //Updatet das bild
			} catch (MalformedURLException ex) {
				System.out.println("Fehler beim Laden des Bildes");
			}
		}
	}

	/**
	 * Nicht verwendete KeyListener Methode
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 * Main Methode um die Frame klasse mit der Wortliste auf zu rufen.
	 * @param args args
	 * @throws IOException Exception für das Speichern und Laden
	 */
	public static void main(String[] args) throws IOException {

		WordList wordList = new WordList();

		WordPair wordPair1 = new WordPair("Baum", "https://images.squarespace-cdn.com/content/v1/60472827fe54df702f7eb4c7/1617090977550-OBXG6PPUEXFZE47TBMQB/was-kostet-ein-baum-sommerlinde-2-baumschule-oekoplant-wels.jpg"); //Erstellt Worteintröge und testet WortEintrag Klasse
		WordPair wordPair2 = new WordPair("Hund", "https://www.br.de/radio/bayern1/bild-gesund-hund-104~_v-img__16__9__xl_-d31c35f8186ebeb80b0cd843a7c267a0e0c81647.jpg?version=fa8e8");
		WordPair wordPair3 = new WordPair("Katze", "https://media.4-paws.org/a/5/c/4/a5c4c9cdfd3a8ecb58e9b1a5bd496c9dfbc3cedc/VIER%20PFOTEN_2020-10-07_00132-2890x2000-1920x1329.jpg");
		WordPair wordPair4 = new WordPair("Fisch", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Carassius_gibelio_2008_G3.jpg/1200px-Carassius_gibelio_2008_G3.jpg");
		WordPair wordPair5 = new WordPair("Pferd", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Horse_December_2014-1.jpg/1200px-Horse_December_2014-1.jpg");
		WordPair wordPair6 = new WordPair("Schwein", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSvSZslxetdlSuj5Fhuh1w5kPtKRLbnOmbCBTc86EjGi_SHTuJp0qbcbXhO-cgXfF0LG4&usqp=CAU");
		WordPair wordPair7 = new WordPair("Huhn", "https://huehnerhaltung.org/wp-content/uploads/vorstellung_new_hampshire_huhn.png");
		WordPair wordPair8 = new WordPair("Kuh", "https://www.br.de/radio/bayern2/sendungen/radiowissen/kuh-104~_v-img__16__9__xl_-d31c35f8186ebeb80b0cd843a7c267a0e0c81647.jpg?version=52356");
		WordPair wordPair9 = new WordPair("Vogel", "https://image.geo.de/30096032/t/Yc/v3/w960/r0/-/einen-vogel-haben-jpg--3115-.jpg");
		WordPair wordPair10 = new WordPair("Frosch", "https://image.geo.de/30023672/t/j2/v3/w1440/r1/-/frosch-gross-jpg--5857-.jpg");

		wordList.addWordPair(wordPair1);
		wordList.addWordPair(wordPair2);
		wordList.addWordPair(wordPair3);
		wordList.addWordPair(wordPair4);
		wordList.addWordPair(wordPair5);
		wordList.addWordPair(wordPair6);
		wordList.addWordPair(wordPair7);
		wordList.addWordPair(wordPair8);
		wordList.addWordPair(wordPair9);
		wordList.addWordPair(wordPair10);

		new WordTrainer(wordList);

	}
}