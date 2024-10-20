/**
 * Worttrainer Session
 * @author Pollak-Sebastian
 * @version 20.10.2024
 */
public class WordTrainerSession {

	private WordList wordList;

	private int rightGuesses = 0;
	private int numberGuesses = 0;

	private int random = 0;

	private SessionManager sessionManager;

	public WordTrainerSession(WordList wordList) {
		this.wordList = wordList;
		newRandomNumber();
		this.sessionManager = new SessionManager(new ManagerStrategyJSON());
	}

	public int getRightGuesses() {
		return rightGuesses;
	}

	public int getNumberGuesses() {
		return numberGuesses;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public void setNumberGuesses(int numberGuesses) {
		this.numberGuesses = numberGuesses;
	}

	public void setRightGuesses(int rightGuesses) {
		this.rightGuesses = rightGuesses;
	}

	public WordList getWordList() {
		return wordList;
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public boolean checkAnswer(String answer) {
		if(answer.equals(getWord())){
			this.rightGuesses++;
			this.numberGuesses++;
			newRandomNumber();
			return true;
		}
		else{
			this.numberGuesses++;
			return false;
		}
	}

	public String getWord(){
		return wordList.getWordPair(random).getWord();
	}

	public String getURL(){
		return wordList.getWordPair(random).getUrl();
	}

	public void newRandomNumber(){
		random = (int)(Math.random() * (wordList.getWordlist().size()- 1)+1);
	}

	public void reset(){
		rightGuesses = 0;
		numberGuesses = 0;
	}


}
