package application;

import java.util.concurrent.atomic.AtomicInteger;

import View.LabelHandler;
import javafx.scene.control.Label;

public class Timer extends Thread {

	private int time;
	private boolean isRunning = true;
	private volatile LabelHandler lbl;
	private int steps = 0;
	
	public Timer(LabelHandler label) {
		this.lbl = label;
	}
	
	public void run() {
		while(getIsRunning()) {
			try {
				Thread.sleep(1000);
				setTime(getTime() + 1);
				Integer toStringInt = new  Integer(getTime());
				String lblText = toStringInt.toString() + " 	 Steps: " + steps; 
				lbl.setText(lblText);
				System.out.println("---My time " + getTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread stop");
	}
	public void pused() {
		System.out.println("Timer pused");
		this.isRunning= false;
	}
	
	public void stopTimer() {
		System.out.println("Timer Stopped");
		this.isRunning= false;
		try {
			Thread.sleep(1000);
			this.setTime(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void startTimer() {
		System.out.println("Timer Started\n");
		start();
	}

	public void start(int time) {
		System.out.println("Timer Started with " + getTime() + "Seconds" );
		this.setTime(time);
		run();
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public boolean getIsRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public void stepsControl(int stepsNumber) {
		this.steps  = stepsNumber;
		
	}

}
