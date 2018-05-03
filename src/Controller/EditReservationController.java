package Controller;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


import Model.Client;
import Model.Reservation;
import Model.ReservationList;
import Model.Room;
import Model.Sqlconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditReservationController implements Initializable{

	private Sqlconnection sq;
	private ObservableList<Reservation> list ;
    @FXML
    private TextField idSearch;

    @FXML
    private TableView<Reservation> reservationsTable;

    @FXML
    private TableColumn<Reservation, String> reservationNo;

    @FXML
    private TableColumn<Reservation, String> roomID;

    @FXML
    private TableColumn<Reservation, String> guestID;

    @FXML
    private TableColumn<Reservation, String> checkOut;

    @FXML
    private TableColumn<Reservation, String> checkIn;

    @FXML
    private TextField ID;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField phoneNum;

    @FXML
    private TextField creditCardNum;

    @FXML
    private DatePicker creditCardExpDate;

    @FXML
    void editReservation(ActionEvent event) throws Exception {
    
    Client client = sq.getClient(reservationsTable.getSelectionModel().getSelectedItem().getClient());
    		
    ID.setText(client.getIDNumber());
    name.setText(client.getName());
    address.setText(client.getAddress());
    phoneNum.setText(Integer.toString(client.getPhoneNumber()));
    creditCardNum.setText(Integer.toString(client.getCreditCardNum()));
    
 
    }
 
    
    @FXML
    void cancelReservation(ActionEvent event) throws Exception {
   sq.deleteReservation(reservationsTable.getSelectionModel().getSelectedItem());
    }
    
 
    @FXML
    void saveChanges(ActionEvent event) throws Exception {
    Date creditCardExp = Date.from(creditCardExpDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    Client client = new Client(name.getText().toString(),ID.getText().toString(),Integer.parseInt(creditCardNum.getText()),creditCardExp,Integer.parseInt(phoneNum.getText()),address.getText().toString());
    sq.editClient(client);
    
    }
    @FXML
    void search(ActionEvent event) {
    	ReservationList rl = new ReservationList(idSearch.getText().toString(),list);
    	this.list = rl.getReservation();
        reservationsTable.setItems(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    this.sq = new Sqlconnection();
		try {
			this.list = sq.getComingReservations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reservationNo.setCellValueFactory(new PropertyValueFactory<Reservation, String>("ReservationID"));
		roomID.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Room"));
		guestID.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Client"));
		checkIn.setCellValueFactory(new PropertyValueFactory<Reservation, String>("CheckInDate"));
		checkOut.setCellValueFactory(new PropertyValueFactory<Reservation, String>("CheckOutDate"));
		reservationsTable.setItems(list);
		
		
	}
	

   

}
