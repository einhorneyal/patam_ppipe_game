package application;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    int stepsNumber;
    int secondsElapsed;
    List<String> Moves = new ArrayList<String>();
    
    public void AddMove(String move)
    {
    	this.Moves.add(move);
    }
    
    public List<String> getMoves() {
		return Moves;
	}
  
	public void setMoves(List<String> moves) {
		Moves = moves;
	}

	public Statistics()
    {
    	setStepsNumber(0);
    	setSecondsElapsed(0);
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
