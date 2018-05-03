package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.BillCalculator;
import Model.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ConfirmationController{

    @FXML
    private Label ConfirmationType;


    @FXML
    private Label billPrice;

    @FXML
    private Label ClientsID;

    @FXML
    private Label RoomNumber;

    @FXML
    private Label CheckIn;

    @FXML
    private Label CheckOut;


    
    public void setBill(Reservation res) {
    	billPrice.setText(res.getClient());
    	BillCalculator bill = new BillCalculator(res);
    	billPrice.setText(Integer.toString(bill.getFinalPrice()));
    	ClientsID.setText(res.getClient());
    	CheckIn.setText(res.getCheckInDate().toString());
    	CheckOut.setText(res.getCheckOutDate().toString());
    }
  
    
    


	
    
    
}