package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerController {
    LoginController lo = new LoginController();
	AccountController ac = new AccountController();
	MenuController mc = new MenuController();
	public void Account(ActionEvent event) throws IOException {
		ac.Account(event);
	}

	public void back(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void backMenu(ActionEvent event) throws IOException {
		mc.back(event);
	}

    public void logout(ActionEvent event) throws IOException {
        lo.logout(event);
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
	    public void dailyRepMenu(ActionEvent event) {

	    }

	    @FXML
	    public void deleteAccountMenu(ActionEvent event) {

	    }

	    @FXML
	    void deleteResMenu(ActionEvent event) {

	    }

	    @FXML
		public void editRoom(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/EditRooms.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		}

	    @FXML
	    public void monRepMenu(ActionEvent event) {

	    }

	    @FXML
	    public void signOutMenu(ActionEvent event) {

	    }

}
