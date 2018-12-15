package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import View.Theme;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import utils.Rotater;

public class PipeMazeClientMainController implements Initializable {
	
		private Theme theme = new Theme("pickleRick");
		private char[][] defaultPipeGame = 
			{
					{'s','-','|','L'},
					{'L','-','|','L'},
					{'L','-','|','L'},
					{'g','-','|','L'},
			};
		
		@FXML
		PipeMazeCanvas pgc;
		

		public void setPipeGameCanvas(char[][] lvl) 
		{
			pgc.cleanGame();
			pgc.setLevel(lvl,theme);	
			pgc.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					MouseEvent me = (MouseEvent) event;
					double w = pgc.getWidth() / lvl[0].length; 
					double h = pgc.getHeight() / lvl.length; 
					defaultPipeGame = Rotater.rotate(lvl,(int)Math.floor(me.getY()/h),(int)Math.floor(me.getX()/w));
					setPipeGameCanvas(defaultPipeGame);
				}
			});
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			setPipeGameCanvas(defaultPipeGame);
		}
		
		public void openFile() 
		{
			FileChooser fc = new FileChooser();
			fc.setTitle("PipeGame Level File");
			File chosen = fc.showOpenDialog(null);
			if(chosen != null) 
			{
				System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
			}
		}

		
	}


