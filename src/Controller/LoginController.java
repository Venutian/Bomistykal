package Controller;

import Model.Authentication;
import Model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    ManagerController mc = new ManagerController();

    @FXML
	    private TextField UserName;

	    @FXML
	    private TextField Password;

    @FXML
    private Label WrongLogin;


    public void login(ActionEvent event) throws IOException {


        try {
			Authentication aut = new Authentication(UserName.getText().toString(),Password.getText().toString());
			 Employee emp = aut.getEmployee();
			
			 /*to implement. Make a pop up window that says user name or passowrd wrong*/
			 //if(emp == null)
            if (emp == null)
                WrongLog();
            else if (emp.isManager())
                LogManager(event);
            else
                LogEmployee(event);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Node) (event.getSource())).getScene().getWindow().hide();


    }

    public void WrongLog() throws IOException {
        UserName.setText("");
        Password.setText("");
        WrongLogin.setVisible(true);
    }

    public void logout(ActionEvent event) throws IOException {
        System.out.println("CheckIn");
        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void LogEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

	}


    private void LogManager(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

	}


	

