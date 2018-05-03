package Controller;


import Model.Reservation;
import java.io.IOException;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ReserveController {
	public String s;
	/*public void serS(String g) {
		this.s = g;
	}*/

	   @FXML
	    private TextField name;

	    @FXML
	    private TextField adrress;

	    @FXML
	    private TextField telNumber;

	    @FXML
	    private TextField CreditCardNumber;

	    @FXML
	    private DatePicker CreditCardExpDate;

	    @FXML
	    private TextField IDnumber;

	    @FXML
	    private DatePicker checkInReserve;

	    @FXML
	    private DatePicker checkOutReserve;

	    @FXML
	    private ChoiceBox<String> noOfRoomsCheckB;

	    @FXML
	    private ChoiceBox<String> noOfGuestsCheckB;

	    
    ObservableList<String> guestNumber = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");

    @FXML
    void reserve(ActionEvent event) {
    	System.out.println(s);
    	
    }
    @FXML
    void cancelReserve(ActionEvent event) {
    	name.setText("");
    	adrress.setText("");
    	telNumber.setText("");
    	CreditCardNumber.setText("");
    	CreditCardExpDate.setValue(null);
    	IDnumber.setText("");
    	checkInReserve.setValue(null);
    	checkOutReserve.setValue(null);
    	noOfRoomsCheckB.setValue(null);
    	noOfGuestsCheckB.setValue(null);
    	((Node) (event.getSource())).getScene().getWindow().hide();
    	
    }

    
    /*public void initialize() throws IOException{
    
    
    this.guestNumBox.setItems(guestNumber);
    guestNumBox.setValue("1");
    	
    }*/
    /*filter methods are checking the inputs if they are correct.
     * if they are not an alert window will pop-up saying what is wrong and why.*/
    private void filterTelNumber() {
    	
    }
     private void filterAdrress() {
    	
    } private void filterName() {
    	
    } private void filterCreditCardNumber() {
    	
    }
    private void filterIDNumber() {
    	
    }
    
    
}

