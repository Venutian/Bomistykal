package Controller;

import Model.EmployeeList;
import View.Alerts;
import Model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
	private TextField UserName;

	@FXML
	private TextField Password;

    @FXML
    private Label WrongLogin;
    
    private EmployeeList aut;
    private Alerts al;
    public void login(ActionEvent event) throws IOException {


        try {
			 this.aut = new EmployeeList();
			 this.al = new Alerts();
			 Employee emp = aut.authenticationControll(UserName.getText().toString(),Password.getText().toString());
			
			if(UserName.getText().isEmpty()||Password.getText().isEmpty())
				al.reportError("Please fill in user name and password!");
			else {
				
			 if (emp == null)
                WrongLog();
            else if (emp.isManager())
                LogManager(event);
            else
                LogEmployee(event);
             }} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void WrongLog() throws IOException {
        UserName.setText("");
        Password.setText("");
        WrongLogin.setVisible(true);
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage primaryStage = new Stage();
        Image anotherIcon = new Image("logo.png");
        primaryStage.getIcons().add(anotherIcon);
        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.setScene(scene);
        primaryStage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void LogEmployee(ActionEvent event) throws IOException {
        
       	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Menu.fxml"));     
       	Parent root = (Parent)fxmlLoader.load();
       	MenuController controller = fxmlLoader.<MenuController>getController();
       	controller.start(false);
       	Scene scene = new Scene(root); 
           Stage primaryStage = new Stage();
   		primaryStage.setScene(scene);
   		primaryStage.show();
           ((Node) (event.getSource())).getScene().getWindow().hide();

	}


    private void LogManager(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Image anotherIcon = new Image("logo.png");
        window.getIcons().add(anotherIcon);
        window.setTitle("Linnaeus Hotel");
        window.setScene(scene);
        window.show();

    }

	}


	

