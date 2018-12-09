package application;

import java.io.FileInputStream;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PipeMazeCanvas extends Canvas {


	char[][] level ;
	
	
	public void setLevel(char[][] lvl) 
	{
		this.level = lvl;
		System.out.println(lvl.length);
		redraw();
	}
	
	public void redraw() 
	{
		if(level != null) 
		{
			double W = getWidth();
			double H = getHeight();
			double w = W / level[0].length; // real width
			double h = H / level.length; // real width
			GraphicsContext gc = getGraphicsContext2D();

			Image straightLine = null;
			Image end  = null;
			Image start  = null;
			Image vertLine  = null;
			Image verJ  = null;
			Image verL  = null;
			Image verF  = null;
			Image ver7  = null;
			Image background  = null;

			try{
				
			//	straightLine = new Image(getClass().getResource( "/resorces/þþstraight.png" ).openStream());
				//start = new Image(getClass().getResource( "/resorces/þþstartEnd.png" ).openStream());
				//space = new Image(getClass().getResource( "/resorces/þþspace2.png" ).openStream());
				//end = new Image(getClass().getResource( "./src/Resources/þþend.png" ).openStream());
				//vertL = new Image(getClass().getResource( "./src/Resources/þþver.png" ).openStream());
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

			
			gc.drawImage(background, W, H);
			
			for(int i = 0; i < level.length;i++)
				for(int j = 0; j < level[0].length;j++) 
				{
					if(level[i][j] == '-') 
					{
						gc.drawImage(vertLine, j*w , i*h , w, h);
					    
					}
					else if(level[i][j] == '|') 
					{
						gc.drawImage(straightLine, j*w , i*h , w, h);
						
					}
					else if(level[i][j] == 'L') 
					{
						gc.drawImage(verL, j*w , i*h , w, h);
					}
					else if(level[i][j] == 'F') 
					{
						gc.drawImage(verF, j*w , i*h , w, h);
						

					}
					else if(level[i][j] == '7') 
					{
						gc.drawImage(ver7, j*w , i*h , w, h);

					}
					else if(level[i][j] == 'J') 
					{
						gc.drawImage(verJ, j*w , i*h , w, h);


					}
					else if(level[i][j] == 's') 
					{
						gc.drawImage(start, j*w , i*h , w, h);
					}
					else if(level[i][j] == 'g') 
					{
						gc.drawImage(end, j*w , i*h , w, h);
					}
			

				}
		}
	}
}
