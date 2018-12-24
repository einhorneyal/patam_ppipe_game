package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import View.Theme;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import utils.Converter;
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
				this.defaultPipeGame = Converter.convertFileToCharArray(chosen);
				setPipeGameCanvas(defaultPipeGame);
				
			}
		}
		
		public void rickAndMortyTheme(){
			this.theme = new Theme("pickleRick");
			setPipeGameCanvas(defaultPipeGame);
		}
		public void ninjaTurtlesTheme(){
			this.theme = new Theme("ninjaturtle");
			setPipeGameCanvas(defaultPipeGame);
		}


		public void solve() throws InterruptedException {
			String ip ="127.0.0.1";
			int port = 32;
			try
		    {
		      Socket theServer = new Socket(ip, port);
		      PrintWriter out = new PrintWriter(theServer.getOutputStream());
		      char[][] data = defaultPipeGame;
		      for (int i = 0; i < data.length; i++)
		        out.println(new String(data[i]));
		      out.println("done");
		      out.flush();
		      BufferedReader in = new BufferedReader(new java.io.InputStreamReader(theServer.getInputStream()));
		      String line;
		      while (!(line = in.readLine()).equals("done")) { 
		        int i = Integer.parseInt(line.split(",")[0]); //rows
		        int j = Integer.parseInt(line.split(",")[1]); // cols
		        int times = Integer.parseInt(line.split(",")[2]); //rotations
		        //board.switchCell(i, j, times);
		        int rot = 0;
		        while( rot < times) {
		        	defaultPipeGame = Rotater.rotate(defaultPipeGame,i,j);
					setPipeGameCanvas(defaultPipeGame);
					rot++;
					
					//need to sleep
		        }
		        rot = 0;
		      }
		      in.close();
		      out.close();
		      theServer.close();
		    } catch (java.io.IOException e) {
		      //javax.swing.JOptionPane.showMessageDialog(board, e.getMessage());
		    	e.printStackTrace();
		    }			 
		}

}



