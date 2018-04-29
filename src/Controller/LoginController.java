package Controller;

import java.io.IOException;

import Model.Authentication;
import Model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	
	    @FXML
	    private TextField UserName;

	    @FXML
	    private TextField Password;
	    
	    
	    
	
	public void login(ActionEvent event) throws IOException {
		
		Authentication aut = new Authentication("waeaff","12345");
		Employee emp = aut.getEmployee();
		
		if(emp.isManager())
			LogManager();
		else
			LogEmployee();
			
		
		
	} 
	
	
	private void LogEmployee() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
	
	private void LogManager() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

    }

	}


	

