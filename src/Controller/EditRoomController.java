package Controller;

import Model.Room;
import Model.Sqlconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditRoomController {
    ManagerController ac = new ManagerController();

    public void back(ActionEvent event) throws IOException {
        //ac.back(event);
    }

       

    @FXML
    private TextField rNumber;

    @FXML
    private TextField rPrice;

    @FXML
    private TextField rSize;
    @FXML
    private TextField rNumBeds;
    
    @FXML
    private CheckBox rLocation;
    
    @FXML
    private CheckBox rView;
    
    @FXML
    private CheckBox rSmoking;
    
    @FXML
    private CheckBox rAdjoint;
    
    @FXML
    private TextField rAdID;

   

    public void addRoom(ActionEvent event) throws Exception {
    	System.out.println("WE here");
        Room rm = new Room(rNumber.getText().toString(), Integer.parseInt(rPrice.getText()), Integer.parseInt(rSize.getText()), Integer.parseInt(rNumBeds.getText()), rLocation.isSelected(), rView.isSelected(),rSmoking.isSelected(),rAdjoint.isSelected(),rAdID.getText().toString());
        Sqlconnection sq = new Sqlconnection();
        sq.addRoom(rm);
    }

}
