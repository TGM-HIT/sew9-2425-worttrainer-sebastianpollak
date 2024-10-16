import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

/**
 * Frame Klasse für Worttrainer
 * @author Pollak-Sebastian
 * @version 25.05.2022
 */
public class TrainerFrame extends JFrame{

	public TrainerFrame(TrainerLayout content) throws MalformedURLException {

		super("Wort-Trainer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 200, 1000, 1000);
		this.add(content);
		this.pack();
		this.setVisible(true);
	}
}