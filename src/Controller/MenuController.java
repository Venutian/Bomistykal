package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    LoginController lo = new LoginController();

    public void logout(ActionEvent event) throws IOException {
        lo.logout(event);
    }

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
	public void Search(ActionEvent event) throws IOException {
		System.out.println("Reserve");
		Parent root = FXMLLoader.load(getClass().getResource("/View/SearchRoom.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void Edit (ActionEvent event) throws IOException {
		System.out.println("edit");
		Parent root = FXMLLoader.load(getClass().getResource("/View/EditRoom.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

    @FXML
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    	
	
}
