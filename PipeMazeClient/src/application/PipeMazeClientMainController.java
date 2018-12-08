package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

public class PipeMazeClientMainController implements Initializable {
	
	


		char[][] defaultPipeGame = 
			{
					{'s','-','|','L'},
					{'L','-','|','L'},
					{'L','-','|','L'},
					{'g','-','|','L'},
			};
		
		//@FXML
		//PipeGameCanvas pgc;
		

		public void setPipeGameCanvas(char[][] lvl) 
		{
		//	pgc.setLevel(lvl);
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


