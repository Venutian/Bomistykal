package Controller;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

import Model.Client;
import Model.Reservation;
import Model.Room;
import Model.Sqlconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ReserveController {
	

    @FXML
    private TextField idNumber;

    @FXML
    private TextField name;

    @FXML
    private TextField creditCardNo;

    @FXML
    private TextField addres;

    @FXML
    private DatePicker CreditCardExpDate;

    @FXML
    private TextField telNumber;
    
    @FXML
    private Label checkinLabel;

    @FXML
    private Label checkOutLabel;

    @FXML
    private Label numOfRoomsLabel;

    @FXML
    private ChoiceBox<Integer> noOfGuestsCheckB;

    @FXML
    private TableView<Room> tableList;
    
    @FXML
    private TableColumn<Room, String> roomNo;

    @FXML
    private TableColumn<Room, String> roomDesc;
    

    @FXML
    private TableColumn<Room, String> bedType;
    

    @FXML
    private TableColumn<Room, String> roomPrice;
    
    ObservableList<Integer> maxGuests  	= FXCollections.observableArrayList();

	private ObservableList<Room> list;
	private Date checkIn;
	private Date checkOut;

    @FXML
    void cancelReserve(ActionEvent event) {
      //yoel make it go back
    }

    @FXML
    void reserve(ActionEvent event) throws Exception {
    Sqlconnection sq = new Sqlconnection();
    Date credit = Date.from(CreditCardExpDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    Client client = new Client(name.getText().toString(),idNumber.getText().toString(),Integer.parseInt(creditCardNo.getText().toString()),credit,Integer.parseInt(telNumber.getText().toString()),addres.getText().toString());
    sq.addClient(client);
    Reservation reservation = null;
    for(Room room : list)
    	sq.addReservation(reservation =  new Reservation(checkIn,checkOut,client.getIDNumber(),room.getRoomID(),"change",noOfGuestsCheckB.getValue()));
    
    goToConfirm(reservation);
    }
    
    public void goToConfirm(Reservation res) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
        //need to implement 
    	ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	controller.reservationConfirm(res);
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
        Image anotherIcon = new Image("logo.png");
        primaryStage.getIcons().add(anotherIcon);
        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.setScene(scene);
		primaryStage.show();
		
	}
    
    public void setRooms(ObservableList<Room> roomsForReserve, Date startDate, Date endDate) {
	this.checkIn= startDate;
	this.checkOut = endDate;
	checkinLabel.setText(checkIn.toString());
	checkOutLabel.setText(checkOut.toString());
	
	this.list = roomsForReserve;
	roomNo.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
	roomDesc.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
	bedType.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
	roomPrice.setCellValueFactory(new PropertyValueFactory<Room, String>("Price"));
	tableList.setItems(list);
	int maxNumOfGuests = 0;
	for(Room r : list) {
		maxNumOfGuests += r.getNumOfBed();
	}
	
	numOfRoomsLabel.setText(Integer.toString(list.size()));
	for(int i = 1;i <= maxNumOfGuests; i ++)
		maxGuests.add(i);
		
	this.noOfGuestsCheckB.setItems(maxGuests);
	noOfGuestsCheckB.setValue(1);
    }

}
