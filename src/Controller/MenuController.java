package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
	

	public void CheckIn(ActionEvent event) throws IOException {
		System.out.println("CheckIn");
		Parent root = FXMLLoader.load(getClass().getResource("/View/CheckIn.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void CheckOut(ActionEvent event) throws IOException {
		System.out.println("CheckOut");
		Parent root = FXMLLoader.load(getClass().getResource("/View/CheckOut.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void Reserve(ActionEvent event) throws IOException {
		System.out.println("Reserve");
		Parent root = FXMLLoader.load(getClass().getResource("/View/SearchRoom.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void Cancel(ActionEvent event) throws IOException {
		System.out.println("Cancel");
		Parent root = FXMLLoader.load(getClass().getResource("/View/Cancel.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
	
	
	
}
