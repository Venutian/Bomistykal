package Controller;

import Model.Reservation;
import Model.Sqlconnection;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        lo.logout(event);
    }

	public void CheckIn(ActionEvent event) throws IOException {
		System.out.println("CheckIn");
		Parent root = FXMLLoader.load(getClass().getResource("/View/CheckIn.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void CheckOut(ActionEvent event) throws IOException {
		System.out.println("CheckOut");
		Parent root = FXMLLoader.load(getClass().getResource("/View/CheckOut.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
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
        window.setScene(scene);
        window.show();

    }

    public void Edit (ActionEvent event) throws IOException {
		System.out.println("edit");
		Parent root = FXMLLoader.load(getClass().getResource("/View/EditRoom.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
			
			
			
		
		 ObservableList<Reservation> data = null;
		try {
            data = new Sqlconnection().getTodayCheckIn();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		       
		System.out.println(data.size());


        c1.setCellValueFactory(new PropertyValueFactory<>("CheckInDate"));
        c2.setCellValueFactory(new PropertyValueFactory<Reservation, String>("CheckOutDate"));
        CIRoomNumber.setCellValueFactory(new PropertyValueFactory<>("Client"));
        CIGuestName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Room"));
        c3.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Employee"));
        c4.setCellValueFactory(new PropertyValueFactory<Reservation,String>("ReservationID"));
		    CheckInTable.setItems(data);


    }

    	
	
}
