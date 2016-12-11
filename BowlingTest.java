package lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTest {

	private BowlingGame bowling = new BowlingGame();
	@Test
	public void testStrike() {
		bowling.makeRoll(10);
		bowling.makeRoll(4);
		bowling.makeRoll(3);
		for (int i=0; i < BowlingGame.ROLLS - 6; i++)
			bowling.makeRoll(2);
		bowling.makeRoll(2);
		bowling.makeRoll(1);
		assertEquals(55,bowling.getScore());
}
	@Test
	public void testSpare() {
		bowling.makeRoll(6);
		bowling.makeRoll(4);
		bowling.makeRoll(3);
		for (int i=0; i < BowlingGame.ROLLS - 3; i++)
			bowling.makeRoll(0);
		assertEquals(16,bowling.getScore());
	}
	
	@Test
	public void testTenthFrame() {
		for(int i = 0; i < BowlingGame.ROLLS - 1; i++)
			bowling.makeRoll(0);
		bowling.makeRoll(10);
		bowling.makeRoll(5);
		assertEquals(15, bowling.getResultScore());
	}
}