package Controller;


import javafx.scene.*;
import javafx.stage.*;
import sun.applet.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class SearchRoomController implements Initializable{
	
	 @FXML
	    private AnchorPane anchor;

	    @FXML
	    private ChoiceBox<String> campusLoc;

	    @FXML
	    private DatePicker checkIn;

	    @FXML
	    private DatePicker checkOut;

	    @FXML
	    private ChoiceBox<Integer> roomsPicker;

	    @FXML
	    private ChoiceBox<Integer> guestPicker;

	    @FXML
	    private CheckBox roomType1;

	    @FXML
	    private CheckBox roomType2;

	    @FXML
	    private CheckBox roomType3;

	    @FXML
	    private CheckBox roomType4;

	    @FXML
	    private CheckBox bedType1;

	    @FXML
	    private CheckBox bedType2;

	    @FXML
	    private TableView<?> tabView;

	    @FXML
	    private TableColumn<?, ?> tabCol_Des;

	    @FXML
	    private TableColumn<?, ?> tabCol_Id;

	    @FXML
	    private TableColumn<?, ?> tabCol_Availble;

	    @FXML
	    private Label roomDetails;

    
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// set the choice for campus location choice box button
	      this.campusLoc = new ChoiceBox<String>(FXCollections.observableArrayList("Växjö" , "Kalmar"));
	      
	        // set the number of rooms for combo box
	      this.roomsPicker = new ChoiceBox<Integer>(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
	      
	        // set the number of guests for combo box
	        this.guestPicker = new ChoiceBox<Integer>(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
	   
		
	}

	
}
