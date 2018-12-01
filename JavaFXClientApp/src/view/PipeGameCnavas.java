package view;


import java.io.FileInputStream;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PipeGameCnavas extends Canvas{
	
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
			Image end  = null;;
			Image start  = null;;
			Image vertL  = null;;
			Image space  = null;;

			try{
				straightLine = new Image(new FileInputStream("./resorces/‏‏straight.png"));
				end = new Image(new FileInputStream("./resorces/‏‏‏‏End.png"));
				start = new Image(new FileInputStream("./resorces/‏‏‏‏startEnd.png"));
				vertL = new Image(new FileInputStream("./resorces/‏‏ver.png"));
				space = new Image(new FileInputStream("./resorces/space.png"));


			}catch(Exception e) 
			{
				e.printStackTrace();
			}

			
			
			for(int i = 0; i < level.length;i++)
				for(int j = 0; j < level[0].length;j++) 
				{
					if(level[i][j] == '-') 
					{
						gc.drawImage(straightLine, j*w , i*h , w, h);
						gc.rotate(90);
					}
					else if(level[i][j] == '|') 
					{
						gc.drawImage(straightLine, j*w , i*h , w, h);
						
					}
					else if(level[i][j] == 'L') 
					{
						gc.drawImage(vertL, j*w , i*h , w, h);
					}
					else if(level[i][j] == 'F') 
					{
						gc.drawImage(vertL, j*w , i*h , w, h);
						gc.rotate(90);

					}
					else if(level[i][j] == '7') 
					{
						gc.drawImage(vertL, j*w , i*h , w, h);
						gc.rotate(90);
						gc.rotate(90);


					}
					else if(level[i][j] == 'J') 
					{
						gc.drawImage(vertL, j*w , i*h , w, h);
						gc.rotate(90);
						gc.rotate(90);
						gc.rotate(90);

					}
					else if(level[i][j] == 's') 
					{
						gc.drawImage(start, j*w , i*h , w, h);
					}
					else if(level[i][j] == 'g') 
					{
						gc.drawImage(end, j*w , i*h , w, h);
					}
					else
						gc.drawImage(space, j*w , i*h , w, h);

				}
		}
	}

}
