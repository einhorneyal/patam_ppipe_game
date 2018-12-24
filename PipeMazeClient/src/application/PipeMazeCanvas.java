package application;

import java.io.FileInputStream;

import View.Theme;
import javafx.beans.InvalidationListener;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PipeMazeCanvas extends Canvas {


	char[][] level ;
	private Theme theme;
	
	
	public void setLevel(char[][] lvl, Theme theme) 
	{
		this.level = lvl;
		this.theme = theme;
		redraw();
	}
	
	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public double minHeight(double width) {
		return 64;
	}

	@Override
	public double maxHeight(double width) {
		return 1000;
	}

	@Override
	public double prefHeight(double width) {
		return minHeight(width);
	}

	@Override
	public double minWidth(double height) {
		return 0;
	}

	@Override
	public double maxWidth(double height) {
		return 10000;
	}

	@Override
	public void resize(double width, double height) {
		super.setWidth(width);
		super.setHeight(height);
		this.cleanGame();
		this.redraw();
	}
	
	public void cleanGame() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, getWidth(), getHeight());
	}
	
	public void redraw() {
		if(level != null) 
		{
			double W = getWidth();
			double H = getHeight();
			double w = W / level[0].length; // real width
			double h = H / level.length; // real width
			GraphicsContext gc = getGraphicsContext2D();
		
			gc.drawImage(theme.getBackground(),0,0, W, H);
			
			for(int i = 0; i < level.length;i++)
				for(int j = 0; j < level[0].length;j++) 
				{
					if(level[i][j] == '-') 
					{
						gc.drawImage(theme.getVertLine(), j*w , i*h , w, h);
					    
					}
					else if(level[i][j] == '|') 
					{
						gc.drawImage(theme.getStraightLine(), j*w , i*h , w, h);
						
					}
					else if(level[i][j] == 'L') 
					{
						gc.drawImage(theme.getVerL(), j*w , i*h , w, h);
					}
					else if(level[i][j] == 'F') 
					{
						gc.drawImage(theme.getVerF(), j*w , i*h , w, h);
						

					}
					else if(level[i][j] == '7') 
					{
						gc.drawImage(theme.getVer7(), j*w , i*h , w, h);

					}
					else if(level[i][j] == 'J') 
					{
						gc.drawImage(theme.getVerJ(), j*w , i*h , w, h);


					}
					else if(level[i][j] == 's') 
					{
						gc.drawImage(theme.getStart(), j*w , i*h , w, h);
					}
					else if(level[i][j] == 'g') 
					{
						gc.drawImage(theme.getEnd(), j*w , i*h , w, h);
						
					}
			
			}
		}
	}
}
