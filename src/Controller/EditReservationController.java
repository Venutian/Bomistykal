package Controller;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import Model.Client;
import Model.Reservation;
import Model.ReservationHandler;
import Model.Database;
import View.Alerts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EditReservationController implements Initializable{
  
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
    
    private  SearchRoomController src;
    private  Database sq;
	private  ObservableList<Reservation> list ;
	private  ReservationHandler rs;
	private  Alerts al;
	

    @FXML
    void editReservation(ActionEvent event) throws Exception {
    
    Client client = rs.getClient(reservationsTable.getSelectionModel().getSelectedItem().getClient());
    		
    ID.setText(client.getIDNumber());
    name.setText(client.getName());
    address.setText(client.getAddress());
    phoneNum.setText(client.getPhoneNumber());
    creditCardNum.setText(client.getCreditCardNum());
    
 
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        src.back(event);
    }
    @FXML
    void cancelReservation(ActionEvent event) throws Exception {
    	
    	
    	if(al.responseAlert("Are you sure you want to cancel this reservation!?")) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
        sq.deleteReservation(reservationsTable.getSelectionModel().getSelectedItem());
    	/*before showing the scene make an object of the controller of the fxml that u are going to 
    	make a set method to set the value that u want in that class*/
    	ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	/*put the value in the setter of that controller class u want */
    	controller.setCancel(reservationsTable.getSelectionModel().getSelectedItem());
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
        Image anotherIcon = new Image("logo.png");
        primaryStage.getIcons().add(anotherIcon);
        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.setScene(scene);
		primaryStage.show();
    	}
    }
    
 
    @FXML
    void saveChanges(ActionEvent event) throws Exception {
    if(name.getText().isEmpty()||ID.getText().isEmpty()||creditCardNum.getText().isEmpty()||phoneNum.getText().isEmpty()||address.getText().isEmpty()||creditCardExpDate.getValue() == null)
    		al.reportError("Please fill everything before saving!");
    else
    	{
    Client client = new Client(name.getText().toString(),ID.getText().toString(),creditCardNum.getText().toString(),Date.from(creditCardExpDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),phoneNum.getText().toString(),address.getText().toString());
    sq.editClient(client);
    al.reportInformation("Changes have been made!");
    	}
    }
    
    @FXML
    void search(ActionEvent event) {
    if(idSearch.getText().isEmpty())
    	al.reportError("Please fill in with clients id before searching!");
    else {
    	this.list = rs.getReservation(idSearch.getText().toString(),list);
        reservationsTable.setItems(list);
    }
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    this.sq = new Database();
	    this.rs = new ReservationHandler();
	    this.src = new SearchRoomController();
	    this.al = new Alerts();
		
			try {
				this.list = rs.getComingReservations();
			} catch (Exception e) {
				
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
