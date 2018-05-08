package Controller;

import Model.Reservation;
import Model.ReservationList;
import Model.Sqlconnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenuController implements Initializable{
    LoginController lo = new LoginController();
    @FXML
    private TableView<Reservation> CheckInTable;

    @FXML
    private TableColumn<Reservation, String> CIRoomNumber;

    @FXML
    private TableColumn<Reservation, String> CIGuestName;
    
    @FXML
    private TableColumn<Reservation, String> c1;

    @FXML
    private TableColumn<Reservation, String> c2;

    @FXML
    private TableColumn<Reservation, String> c3;

    @FXML
    private TableColumn<Reservation, String> c4;

    @FXML
    private TableView<Reservation> CheckOutTable;

    @FXML
    private TableColumn<Reservation, String> CORoomNum;

    @FXML
    private TableColumn<Reservation, String> COGuestName;

    public void logout(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Dialog");
    	alert.setContentText("Are you sure you want to log out?");
    	ButtonType yes = new ButtonType("Yes");
    	ButtonType no = new ButtonType("No");
    	alert.getButtonTypes().setAll(yes,no);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == yes){
    		lo.logout(event);
    	} else if (result.get() == no){
    	   alert.close();
    	}
    	
    }

	public void CheckIn(ActionEvent event) throws IOException {
		

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
    	ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	controller.setCheckIn(CheckInTable.getSelectionModel().getSelectedItem());
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void CheckOut(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ConfirmationWindow.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
    	ConfirmationController controller = fxmlLoader.<ConfirmationController>getController();
    	controller.setCheckOut(CheckInTable.getSelectionModel().getSelectedItem());
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void Search(ActionEvent event) throws IOException {
		System.out.println("Reserve");
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
		System.out.println("edit");
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
		Sqlconnection sq  = new Sqlconnection();
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			
			Calendar myCalendar = new GregorianCalendar(2021, 02, 11);
			Date myDate = myCalendar.getTime();
			
			 
			 String testDateString = df.format(myDate);
			 Date  ff = null;
			Reservation re = null ;
			 try {
				
				 ff =  df.parse(testDateString);
				
				 
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//if i choose one reservation that has adjoined both rooms should be checked in
		
		 ObservableList<Reservation> data = null;
		try {
            data = new ReservationList().getTodayCheckIn();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		c1.setCellValueFactory(new PropertyValueFactory<>("CheckInDate"));
        c2.setCellValueFactory(new PropertyValueFactory<Reservation, String>("CheckOutDate"));
        CIRoomNumber.setCellValueFactory(new PropertyValueFactory<>("Client"));
        CIGuestName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Room"));
        c3.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Employee"));
        c4.setCellValueFactory(new PropertyValueFactory<Reservation,String>("ReservationID"));
		    CheckInTable.setItems(data);


    }


}
