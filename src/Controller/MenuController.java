package Controller;

import Model.Reservation;
import Model.ReservationList;
import Model.Sqlconnection;
import View.Alerts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{
    
    @FXML
    private TableView<Reservation> CheckInTable;

    @FXML
    private TableColumn<Reservation, String> CIRoomNumber;

    @FXML
    private TableColumn<Reservation, String> CIGuestName;
    
    @FXML
    private TableColumn<Reservation, String> CICheckInDate;

    @FXML
    private TableColumn<Reservation, String> CICheckOutDate;



    @FXML
    private TableView<Reservation> CheckOutTable;

    @FXML
    private TableColumn<Reservation, String> CORoomNum;

    @FXML
    private TableColumn<Reservation, String> COGuestName;
    
    @FXML
    private TableColumn<Reservation, String> COCheckInDate;

    @FXML
    private TableColumn<Reservation, String> COCheckOutDate;
   
    private Alerts al;
    private LoginController lo;
    private ReservationList rl;
	private ObservableList<Reservation> checkInList;
    private ObservableList<Reservation> checkOutList;
    
    public void logout(ActionEvent event) throws IOException {
    	
    	if (al.responseAlert("Are you sure you want to log out?"))
    		lo.logout(event);
    	
    	
    }

	public void CheckIn(ActionEvent event) throws Exception {
		
        Reservation res = CheckInTable.getSelectionModel().getSelectedItem();
        res.setCheckedIn(true);
        Sqlconnection sq = new Sqlconnection();
		sq.editReservation(res);
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
    	ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	controller.setCheckIn(res);
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		CheckInTable.getItems().remove(res);
		
	}
	public void CheckOut(ActionEvent event) throws Exception {
		Reservation res = CheckInTable.getSelectionModel().getSelectedItem();
		res.setCheckedOut(true);
		Sqlconnection sq = new Sqlconnection();
		sq.editReservation(res);
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
    	ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	controller.setCheckOut(CheckInTable.getSelectionModel().getSelectedItem());
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		CheckOutTable.getItems().remove(res);
	}
	public void Search(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/SearchRoom.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Image anotherIcon = new Image("logo.png");
		window.getIcons().add(anotherIcon);
		window.setTitle("Linnaeus Hotel");
		window.setScene(scene);
        window.show();

    }

    public void EditReservations(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/EditReservation.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Image anotherIcon = new Image("logo.png");
		window.getIcons().add(anotherIcon);
		window.setTitle("Linnaeus Hotel");
		window.setScene(scene);
		window.show();
		
	}

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Image anotherIcon = new Image("logo.png");
		window.getIcons().add(anotherIcon);
		window.setTitle("Linnaeus Hotel");
		window.setScene(scene);
        window.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.al = new Alerts();
	    this.lo = new LoginController();
	    this.rl = new ReservationList();
		 

		try {
			this.checkInList = rl.getTodayCheckIn();
			this.checkOutList = rl.getTodayCheckOut();
        } catch (Exception e) {
			e.printStackTrace();
		}


		CICheckInDate.setCellValueFactory(new PropertyValueFactory<>("CheckInDate"));
		CICheckOutDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("CheckOutDate"));
		CIRoomNumber.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Room"));
		CIGuestName.setCellValueFactory(new PropertyValueFactory<>("Client"));
		CheckInTable.setItems(checkInList);
        
		COCheckInDate.setCellValueFactory(new PropertyValueFactory<>("CheckInDate"));
		COCheckOutDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("CheckOutDate"));
		CORoomNum.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Room"));
		COGuestName.setCellValueFactory(new PropertyValueFactory<>("Client"));
		CheckOutTable.setItems(checkOutList);

    }
	


}
