package application;

public class Timer extends Thread {

	private int time;
	private boolean isRunning = true;
	
	
	public void run() {
		while(getIsRunning()) {
			try {
				Thread.sleep(1000);
				setTime(getTime() + 1);
				System.out.println("---My time " + getTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void pused() {
		System.out.println("Timer pused");
		this.isRunning= false;
	}
	
	public void stopTimer() {
		System.out.println("Timer Stopped");
		this.isRunning= false;
		this.setTime(0);
	}

	public void startTimer() {
		System.out.println("Timer Started");
		run();
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

}
