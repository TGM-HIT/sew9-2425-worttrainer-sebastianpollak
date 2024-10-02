public class WordTrainerSession {

	private WordList wordList;

	private int rightGuesses = 0;
	private int numberGuesses = 0;

	private int random = 0;

	public WordTrainerSession(WordList wordList) {
		this.wordList = wordList;
		newRandomNumber();
	}

	public int getRightGuesses() {
		return rightGuesses;
	}

	public int getNumberGuesses() {
		return numberGuesses;
	}

	public boolean checkAnswer(String answer) {
		if(answer.equals(getWord(random))){
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

	public String getWord(int index){

		return wordList.getWordPair(index).getWord();

	}

	public void newRandomNumber(){

		random = (int)(Math.random() * (wordList.getWordlist().size()- 1)+1);

	}

}
