package View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LabelStepsHandler{
	private volatile Label lbl;
	
	public LabelStepsHandler(Label lbl) {
		this.lbl = lbl;
	}
	public Label getLbl() {
		return lbl;
	}
	public void setLbl(Label lbl) {
		this.lbl = lbl;
	}
	
	public void setText(String txt) {
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	lbl.setText(txt);
		    }
		});
		
	}
	
	
}