package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerController {

	 @FXML
	   public void CreateNewAccountMenu(ActionEvent event) throws IOException {
		 
	 }
	    @FXML
	    public void DeleteRoomMenu(ActionEvent event) {

	    }

	    @FXML
	    public void UpdateRoomMenu(ActionEvent event) {

	    }

	    @FXML
	   public void addResMenu(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/View/SearchRoom.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
	    }
	    

	    @FXML
	    public void changeUserOrPassMenu(ActionEvent event) {

	    }

	    @FXML
	    public void createNewRoomMenu(ActionEvent event) {

	    }

	    @FXML
	    public void dailyRepMenu(ActionEvent event) {

	    }

	    @FXML
	    public void deleteAccountMenu(ActionEvent event) {

	    }

	    @FXML
	    void deleteResMenu(ActionEvent event) {

	    }

	    @FXML
	    public void editResMenu(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/View/EditRoom.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
	    
	    }

	    @FXML
	    public void monRepMenu(ActionEvent event) {

	    }

	    @FXML
	    public void signOutMenu(ActionEvent event) {

	    }

}
