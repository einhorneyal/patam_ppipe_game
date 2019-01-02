package application;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private int stepsNumber;
    private int secondsElapsed;
    private char[][] level;
    

    public Statistics()
    {
    	setStepsNumber(0);
    	setSecondsElapsed(0);
    }
    
	public char[][] getLevel() {
		return level;
	}

	public void setLevel(char[][] level) {
		this.level = level;
	}
    
	public int getStepsNumber() {
		return stepsNumber;
	}
	public void setStepsNumber(int stepsNumber) {
		this.stepsNumber = stepsNumber;
	}
	public int getSecondsElapsed() {
		return secondsElapsed;
	}
	public void setSecondsElapsed(int secondsElapsed) {
		this.secondsElapsed = secondsElapsed;
	}
    
}
