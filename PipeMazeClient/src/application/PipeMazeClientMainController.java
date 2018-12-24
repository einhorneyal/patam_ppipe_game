package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ResourceBundle;

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

		
		public void solve() {
			Socket s=null;
			PrintWriter out=null;
			BufferedReader in=null;
			try{
				s = new Socket("127.0.0.1",32);
				s.setSoTimeout(3000);
				out=new PrintWriter(s.getOutputStream());
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));			
				out.println("done");
				out.flush();
				
				String line=in.readLine();
			}catch(SocketTimeoutException e){
				System.out.println("Your Server takes over 3 seconds to answer");
			}catch(IOException e){
				System.out.println("Your Server ran into some IOException");
			}finally{
				try {
					in.close();
					out.close();
					s.close();
				} catch (IOException e) {
					System.out.println("Your Server ran into some IOException");
				}
			}
		}
}



