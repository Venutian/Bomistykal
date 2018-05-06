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
    private DatePicker checkInReserve;

    @FXML
    private DatePicker checkOutReserve;

    @FXML
    private ChoiceBox<?> noOfRoomsCheckB;

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
    for(Room room : list)
    	sq.addReservation(new Reservation(checkIn,checkOut,client.getIDNumber(),room.getRoomID(),"change",noOfGuestsCheckB.getValue()));
    
    
    }
    
    public void goToConfirm() throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
        //need to implement 
    	//ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	//controller.reservationConfirm(list.get(0), 3);
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
	
	
	for(int i = 1;i <= maxNumOfGuests; i ++)
		maxGuests.add(i);
		
	this.noOfGuestsCheckB.setItems(maxGuests);
	noOfGuestsCheckB.setValue(1);
    }

}
