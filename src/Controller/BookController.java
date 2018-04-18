package Controller;


import javafx.scene.*;
import javafx.stage.*;
import sun.applet.Main;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class BookController extends Application {
	
	@FXML
    private BorderPane boarderPane;
	@FXML
    private AnchorPane top;

    @FXML
    private Label labSet;

    @FXML
    private ChoiceBox<String> campusLocation;

    @FXML
    private DatePicker CheckInDate;

    @FXML
    private DatePicker CheckOutDate;

    @FXML
    private ChoiceBox<Integer> roomsPicker;

    @FXML
    private ChoiceBox<Integer> guestPicker;

    @FXML
    private CheckBox roomType1; // variable for smoking room

    @FXML
    private CheckBox roomType2; // variable for non-smoking room

    @FXML
    private CheckBox roomType3; // variable for allowed pets room 

    @FXML
    private CheckBox roomType4;// variable for adjoint  room

    @FXML
    private CheckBox bedType1; // variable for double bed room

    @FXML
    private CheckBox bedType2; // variable for twin bed room

    @FXML
    private AnchorPane mid;

    @FXML
    private TableView<?> tabView;

    @FXML
    private TableColumn<?, ?> tabCol_Des;

    @FXML
    private TableColumn<?, ?> tabCol_Id;

    @FXML
    private TableColumn<?, ?> tabCol_Availble;

    @FXML
    private AnchorPane left;
	
    @Override
	public void start(Stage primaryStage) throws IOException {
    	 FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(Main.class.getResource("/View/SearchRoom.fxml"));
        boarderPane = loader.load();
        Scene sc = new Scene(boarderPane);
	    
    	// set the choice for campus location choice box button
      this.campusLocation = new ChoiceBox<String>(FXCollections.observableArrayList("Växjö" , "Kalmar"));
      
        // set the number of rooms for combo box
      this.roomsPicker = new ChoiceBox<Integer>(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
      
        // set the number of guests for combo box
        this.guestPicker = new ChoiceBox<Integer>(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
       
        
        
        
        
        primaryStage.setTitle("Book Search");
        primaryStage.setScene(sc);
        primaryStage.show();
        
	} 
    
    
    // Handles all the choice boxes in search room 
    @FXML
    private void handleSmoking() {
    	if (roomType1.isSelected()) {
    		
    	}
    }
    @FXML
    private void handleNonSmoking() {
    	if (roomType2.isSelected()) {
    		
    	} 
    }
    	@FXML
        private void handlePets() {
        	if (roomType3.isSelected()) {
        		
        	} 
    }
    	 @FXML
    	    private void handleAdjoint() {
    	    	if (roomType4.isSelected()) {
    	    		
    	    	}
    	 }  @FXML
    	    private void handleDoubleBed() {
    	    	if (bedType1.isSelected()) {
    	    		
    	    	}
    	 }
    	 @FXML
    	    private void handleTwinBed() {
    	    	if (roomType1.isSelected()) {
    	    		
    	    	}
    	 }
	public static void main(String[] args) {
		
		launch(args);
	}
}
