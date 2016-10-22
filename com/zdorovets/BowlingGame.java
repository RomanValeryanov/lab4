﻿package com.zdorovets;
/*
 * BowlingGame class
 * @author Evgeny Zdorovets
 * created on 21/10/16
 */
public class BowlingGame {
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	/*
	 * @param pins - количество кеглей
	 */
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	/* 
	 * @return количество очков
	 */
	public int score(){
		int score = 0;
		int frameIndex = 0;
		for (int frame = 0; frame < 10; frame++){
			if(rolls[frameIndex] == 10) // strike
			{
				score += 10 + rolls[frameIndex + 1]+ rolls[frameIndex + 2];
				frameIndex++;
			}
			else if (isSpare(frameIndex)){
				score += 10 + rolls[frameIndex + 2];
				frameIndex += 2;
			} else {
				score += rolls[frameIndex] + rolls[frameIndex+1];
				frameIndex += 2;
			}
		}
		return score;
	}
	/* 
	 * @param frameIndex индекс захода
	 * @return ситуация spare или нет
	 */
	private boolean isSpare(int frameIndex){
		return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
	}
}
