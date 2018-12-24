package View;

import java.io.File;
import java.io.FileInputStream;

import javax.print.DocFlavor.URL;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Theme {
	
	private Image straightLine = null;
	private Image end  = null;
	private Image start  = null;
	private Image vertLine  = null;
	private Image verJ  = null;
	private Image verL  = null;
	private Image verF  = null;
	private Image ver7  = null;
	private Image background  = null;
	
	public Theme(String themeType) 
	{
		
		if(themeType == "pickleRick") {
			try{
				
				straightLine = new Image(new FileInputStream("./src/Resources/pipe1.png"));
				vertLine = new Image(new FileInputStream("./src/Resources/pipe2.png"));
				start = new Image(new FileInputStream("./src/Resources/StartPickleRick.png"));
				end = new Image(new FileInputStream("./src/Resources/SuperPickleRick.png"));
				verJ = new Image(new FileInputStream("./src/Resources/pipeJ.png"));
				verF = new Image(new FileInputStream("./src/Resources/pipeF.png"));
				ver7 = new Image(new FileInputStream("./src/Resources/pipe7.png"));
				verL = new Image(new FileInputStream("./src/Resources/pipeL.png"));
				background =   new Image(new FileInputStream("./src/Resources/Rickk.png"));
			File file = new File("./src/Resources/Rick and Morty Theme Song.wav");
				 MediaPlayer a =new MediaPlayer(new Media(file.toURI().toString()));
				 a.setOnEndOfMedia(new Runnable() {
				      public void run() {
				        a.seek(Duration.ZERO);
				     }
				  });
				  a.play();
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if ( themeType=="ninjaturtle")
		{
			try{
				SnapshotParameters params = new SnapshotParameters();
				params.setFill(Color.TRANSPARENT);
				straightLine = new Image(new FileInputStream("./src/Resources/pipe1.png"));
				vertLine = new Image(new FileInputStream("./src/Resources/pipe2.png"));
				start = new Image(new FileInputStream("./src/Resources/donatello.png"));
				end = new Image(new FileInputStream("./src/Resources/Pizza.png"));
				verJ = new Image(new FileInputStream("./src/Resources/pipeJ.png"));
				verF = new Image(new FileInputStream("./src/Resources/pipeF.png"));
				ver7 = new Image(new FileInputStream("./src/Resources/pipe7.png"));
				verL = new Image(new FileInputStream("./src/Resources/pipeL.png"));
				background = new Image(new FileInputStream("./src/Resources/Turtle.jpg"));
				File file = new File("./src/Resources/NinjaTurtleThemeSong.wav");
				 MediaPlayer a =new MediaPlayer(new Media(file.toURI().toString()));
				 a.setOnEndOfMedia(new Runnable() {
				       public void run() {
				         a.seek(Duration.ZERO);
				       }
				   });
				  a.play();
				 
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	public Image getStraightLine() {
		return straightLine;
	}

	public void setStraightLine(Image straightLine) {
		this.straightLine = straightLine;
	}

	public Image getEnd() {
		return end;
	}

	public void setEnd(Image end) {
		this.end = end;
	}

	public Image getStart() {
		return start;
	}

	public void setStart(Image start) {
		this.start = start;
	}

	public Image getVertLine() {
		return vertLine;
	}

	public void setVertLine(Image vertLine) {
		this.vertLine = vertLine;
	}

	public Image getVerJ() {
		return verJ;
	}

	public void setVerJ(Image verJ) {
		this.verJ = verJ;
	}

	public Image getVerL() {
		return verL;
	}

	public void setVerL(Image verL) {
		this.verL = verL;
	}

	public Image getVerF() {
		return verF;
	}

	public void setVerF(Image verF) {
		this.verF = verF;
	}

	public Image getVer7() {
		return ver7;
	}

	public void setVer7(Image ver7) {
		this.ver7 = ver7;
	}

	public Image getBackground() {
		return background;
	}

	public void setBackground(Image background) {
		this.background = background;
	}
	
}
