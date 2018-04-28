package Controller;



import java.io.IOException;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ReserveController {

    @FXML
    private TextField IDnumber;

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
    private ChoiceBox<String> guestNumBox;
    
    ObservableList<String> guestNumber = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");

    @FXML
    void reserve(ActionEvent event) {
     
    	
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

