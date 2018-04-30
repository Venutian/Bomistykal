package Controller;

import Model.Room;
import Model.Sqlconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditRoomController {
    ManagerController ac = new ManagerController();

    public void back(ActionEvent event) throws IOException {
        ac.back(event);
    }

    @FXML
    private TextField rFloor;

    @FXML
    private TextField rNumber;

    @FXML
    private TextField rPrice;

    @FXML
    private TextField rSize;

    @FXML
    private TextField rLocation;

    @FXML
    private TextField rDesc;

    public void addRoom(ActionEvent event) throws Exception {
        Room rm = new Room(Integer.parseInt(rFloor.getText()), rNumber.getText().toString(), Integer.parseInt(rPrice.getText()), Integer.parseInt(rSize.getText()), rLocation.getText().toString(), rDesc.getText());
        Sqlconnection sq = new Sqlconnection();
        sq.addRoom(rm);
    }

}
