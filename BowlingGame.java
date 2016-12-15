package lab4;

public class BowlingGame {
	public static int ROLLS = 20;
	public static int MAXPINS = 10;
	public static int MAXROLLS = 23;
	private final int LASTFRAME = 18;
	private int score;
	private int indexOfRoll;
	private int []rolls;
	
	BowlingGame() {
		indexOfRoll = 0;
		rolls = new int[MAXROLLS];
		score = 0;
	}
	
	public void makeRoll(int pins) {
		
		rolls[indexOfRoll++] = pins;
		if ((pins == MAXPINS)&&(indexOfRoll - 1)%2 == 0) {
			rolls[indexOfRoll++] = 0;
		}
	}
	
	public void getResult() {
		for (int i = 0;i<ROLLS;i +=2){
			score += frameSum(i);
			
			if (i + 2 == ROLLS && isStrike(i)) {
				for(int j = ROLLS; j < indexOfRoll; j++)
					score += rolls[j];
			}
			else if(isStrike(i)) {
				score += strike(i+2);
			}
			else if(isSpare(i)) {
				score += rolls[i+2];
			}
		}
	}
	
	public int frameSum(int i) {
		return rolls[i]+rolls[i+1];
	}
	
	private boolean isSpare(int i) {
		if (rolls[i]+rolls[i+1] == MAXPINS)
			return true;
		else 
			return false;
	}
	
	private boolean isStrike(int i) {
		if (rolls[i] == MAXPINS || rolls[i + 1] == MAXPINS)
			return true;
		else 
			return false;
	}
	
	private int strike(int i) {
		int middleScore = 0;
		if (i == LASTFRAME && isStrike(i))
			middleScore += frameSum(i) + rolls[i + 2];
		else {
			if (isStrike(i)) {
				if (isStrike(i + 2)) {
					for (int j = i; j< i+4; j++) 
						middleScore += rolls[j];
				}
				else
					middleScore += frameSum(i) + rolls[i+2];
			}
			else
				middleScore += frameSum(i); 
		}
		return middleScore;
	}
	
	public int getScore() {
		getResult();
		return score;
	}
	
}
