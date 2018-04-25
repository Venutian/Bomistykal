package Controller;

import java.io.IOException;

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
		
		System.out.println(UserName.getText());
		checkUserName(UserName.getText());
		
		
		
		Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
	
   /*Check if the user name exists If it does not give an alert.*/
   private void checkUserName(String name) {
	   checkPassword(Password.getText());
   }
   
   /*Check if the password is correct. If it is not give an alert.*/
	private void checkPassword(String password) {
	
	}
	
	
}
