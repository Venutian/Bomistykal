package Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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

import Model.Reservation;
import Model.Sqlconnection;

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
			
			Reservation re = null ;
			 try {
				Date ff =  df.parse(testDateString);
				
				  re = new Reservation(ff,ff,"D","d","fff","dsa");
				 
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			
		
		 ObservableList<Reservation> data  = FXCollections.observableArrayList( );
		        data.add(re); 
	
			//Date checkIn,Date checkOut, String clientID,String roomID,String empUserName, String ReservationID
			for(Reservation a : data) {
			CIRoomNumber.setCellValueFactory(new PropertyValueFactory<Reservation,String>(a.clientID));
			CIGuestName.setCellValueFactory(new PropertyValueFactory<Reservation,String>("roomID"));
			c1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("checkIn"));
			c2.setCellValueFactory(new PropertyValueFactory<Reservation,String>("checkOut"));
			c3.setCellValueFactory(new PropertyValueFactory<Reservation,String>("empUserName"));
			c4.setCellValueFactory(new PropertyValueFactory<Reservation,String>("ReservationID"));
		    CheckInTable.setItems(data);
		  
			}
	}

    	
	
}
