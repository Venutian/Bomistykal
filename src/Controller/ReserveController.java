package Controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void reserve(ActionEvent event) {
     
    	
    }
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

