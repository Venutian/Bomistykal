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
    private TableColumn<Reservation, SimpleStringProperty> CInRoomNumber;

    @FXML
    private TableColumn<Reservation, SimpleStringProperty> CIGuestName;

    @FXML
    private TableView<Reservation> CheckOutTable;

    @FXML
    private TableColumn<Reservation, String> COutRoomNum;

    @FXML
    private TableColumn<Reservation, String> COutGN;

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
			String date2 = "2018-04-30";
			 
			 Date ff =  df.parse(testDateString);
			 Date ff2 =  df.parse(date2);
			 
		   System.out.println(testDateString+" "+date2);
			
		 Reservation re = new Reservation(ff,ff,"D","d","fff");
		 ObservableList<Reservation> data  = FXCollections.observableArrayList(
				  
				 );
		         
		try {
		
			
			/*String clientID;
	      String roomID;new SimpleStringProperty (clientID)*/
			CInRoomNumber.setCellValueFactory(new PropertyValueFactory<Reservation,SimpleStringProperty>("roomID"));
			CIGuestName.setCellValueFactory(new PropertyValueFactory<Reservation,SimpleStringProperty>("clientID"));
		      
		      CheckInTable.setItems(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

    	
	
}
