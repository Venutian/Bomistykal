package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckInController {

	/*Take client id and search for reservation*/
    @FXML
    private TextField ClientID;

    /*Reservations appear on this Label*/
    @FXML
    private Label Reservations;

    /*By clicking this button the reservation/s will appear no the label*/
    @FXML
    void CheckInClient(ActionEvent event) {

    }

}