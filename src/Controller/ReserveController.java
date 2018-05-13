package Controller;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

import Model.Client;

import Model.Reservation;
import Model.ReservationHandler;
import Model.Room;
import Model.Database;
import View.Alerts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private TextField idNumber,name,creditCardNo,addres,telNumber;

    @FXML
    private DatePicker CreditCardExpDate;
   
    @FXML
    private Label checkinLabel,checkOutLabel,numOfRoomsLabel;

    @FXML
    private ChoiceBox<Integer> noOfGuestsCheckB;

    @FXML
    private TableView<Room> tableList;
    
    @FXML
    private TableColumn<Room, String> roomNo,roomDesc,bedType,roomPrice;

    
    private Database sq ;
    private ReservationHandler rs ;
    private ObservableList<Integer> maxGuests;
    private ObservableList<Room> list;
	private Date checkIn;
	private Date checkOut;
	private Alerts al;
	private Reservation reservation;
   
	@FXML
    void cancelReserve(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/SearchRoom.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    void reserve(ActionEvent event) throws Exception {
   
    if(name.getText().isEmpty()||idNumber.getText().isEmpty()||creditCardNo.getText().isEmpty()||telNumber.getText().isEmpty()||addres.getText().isEmpty()||CreditCardExpDate.getValue() == null)
    	al.reportError("Please fill all the text fields!");
    else {
    //if the client does not already exists in the database.. add him/her.
     if(rs.getClient(name.getText().toString()) == null) {
    	Client client = new Client(name.getText().toString(),idNumber.getText().toString(),creditCardNo.getText().toString(),Date.from(CreditCardExpDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),telNumber.getText().toString(),addres.getText().toString());
        sq.addClient(client);
    }
   
     //every room we book we make a new reservation for it. It makes it easier to manage reservations.
    for(Room room : list) {
    	sq.addReservation(reservation =  new Reservation(checkIn,checkOut,idNumber.getText().toString(),room.getRoomID(),"change",noOfGuestsCheckB.getValue()));
        goToConfirm(reservation);
    }
     }}
    
    public void goToConfirm(Reservation res) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
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
	this.checkinLabel.setText(checkIn.toString());
	this.checkOutLabel.setText(checkOut.toString());
	this.sq = new Database();
	this.rs = new ReservationHandler();
	this.maxGuests  = rs.getNumOfGuests(roomsForReserve);
	this.al = new Alerts();
	this.list = roomsForReserve;
	
	
	this.roomNo.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
	this.roomDesc.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
	this.bedType.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
	this.roomPrice.setCellValueFactory(new PropertyValueFactory<Room, String>("Price"));
	this.tableList.setItems(list);
	this.numOfRoomsLabel.setText(Integer.toString(list.size()));
	
	
		
	this.noOfGuestsCheckB.setItems(maxGuests);
	noOfGuestsCheckB.setValue(1);
    }

}
