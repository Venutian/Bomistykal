package View;

import java.io.IOException;
import java.util.Optional;

import Controller.LoginController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Alerts {

	public Alerts() {
		
	}

    public void reportError(String str) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Error Dialog");
    	alert.setContentText(str);
    	alert.showAndWait();
    }
    
    public void reportInformation(String str) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Error Dialog");
    	alert.setContentText(str);
    	alert.showAndWait();
    }
    
    public boolean responseAlert(String str) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setContentText(str);
		ButtonType yes = new ButtonType("Yes");
    	ButtonType no = new ButtonType("No");
    	alert.getButtonTypes().setAll(yes,no);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == yes)
			return true;
		else
			return false;
	
	 }
    
}