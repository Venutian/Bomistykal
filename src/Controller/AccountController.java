package Controller;

import Model.Employee;
import Model.Sqlconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;




public class AccountController {
    @FXML
    private TextField eName;

    @FXML
    private TextField eID;

    @FXML
    private TextField eUsername;

    @FXML
    private TextField ePassword;

    @FXML
    private TextField eAdress;

    @FXML
    private TextField ePhone;

    @FXML
    private CheckBox isManager;

    public void CreateAccount(ActionEvent event) throws IOException {
        try {
             Employee emp= new Employee(eName.getText().toString(),eID.getText().toString(),eUsername.getText().toString(),ePassword.getText().toString(),eAdress.getText().toString(),Integer.parseInt(ePhone.getText()),isManager.isSelected());
            Sqlconnection sq = new Sqlconnection();
            sq.addEmployee(emp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void Account(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Account.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void CreateNewAccountMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Account/CreateAccount.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerWindow.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
