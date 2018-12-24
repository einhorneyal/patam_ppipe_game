package View;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ViewMediaPlayer {
	private File file = new File("./src/Resources/Rick and Morty Theme Song.wav");;
	private MediaPlayer mp;
	private static ViewMediaPlayer mediaPlayer;

	private ViewMediaPlayer(){
	  	mp =new MediaPlayer(new Media(this.file.toURI().toString()));
	    mp.setCycleCount(MediaPlayer.INDEFINITE);
	  	mp.play();
	}

	public static ViewMediaPlayer getInstance(){
	    if (mediaPlayer == null){ 
	    	mediaPlayer = new ViewMediaPlayer();
	    }

	    return mediaPlayer;
	}
	
	public void setSong(File file) {;
		mp.stop();
		mp = new MediaPlayer(new Media(file.toURI().toString()));
	    mp.setCycleCount(MediaPlayer.INDEFINITE);
		mp.play();
	}
	
	
	 
	
}
