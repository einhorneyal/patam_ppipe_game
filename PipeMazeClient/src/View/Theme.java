package View;

import java.io.FileInputStream;

import javafx.scene.image.Image;

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
				end = new Image(new FileInputStream("./src/Resources/Rat.png"));
				verJ = new Image(new FileInputStream("./src/Resources/pipeJ.png"));
				verF = new Image(new FileInputStream("./src/Resources/pipeF.png"));
				ver7 = new Image(new FileInputStream("./src/Resources/pipe7.png"));
				verL = new Image(new FileInputStream("./src/Resources/pipeL.png"));
				background =   new Image(new FileInputStream("./src/Resources/Background.jpg"));
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
