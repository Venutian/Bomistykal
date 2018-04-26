package Controller;


import main.Main;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class SearchRoomController {
	
    @FXML
    private AnchorPane anchor;

    @FXML
    private ChoiceBox<String> campusLoc;

    @FXML
    private DatePicker checkIn;

    @FXML
    private DatePicker checkOut;

      @FXML
    private CheckBox smokingBox;

    @FXML
    private CheckBox nonSmokingBox;

    @FXML
    private CheckBox petsBox;

    @FXML
    private CheckBox adjointBox;

    @FXML
    private CheckBox doubleBedBox;

    @FXML
    private CheckBox twinBedBox;

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

    @FXML
    private CheckBox viewBox;

    @FXML
    private CheckBox SingleBedBox;
    
    private Main mainWindow;

    ObservableList<String> campusLocation  	= FXCollections.observableArrayList("Vaxjo" , "Kalmar");
   
    @FXML
    private void handleSmoking() {
    	if (smokingBox.isSelected()) {
    		
    	}
    }
    @FXML
    private void handleNonSmoking() {
    	if (nonSmokingBox.isSelected()) {
    		
    	} 
    }
    	@FXML
        private void handlePets() {
        	if (petsBox.isSelected()) {
        		
        	} 
    }
    	 @FXML
    	    private void handleAdjoint() {
    	    	if (adjointBox.isSelected()) {
    	    		
    	    	}
    	 } @FXML
    	    private void handleView() {
 	    	if (viewBox.isSelected()) {
 	    		
 	    	}
    	 }
    	 
    	 @FXML
    	    private void handleDoubleBed() {
    	    	if (doubleBedBox.isSelected()) {
    	    		
    	    	}
    	 }
    	 @FXML
    	    private void handleTwinBed() {
    	    	if (twinBedBox.isSelected()) {
    	    		
    	    	}
    	 }
    	 @FXML
 	    private void handleSingleBed() {
 	    	if (SingleBedBox.isSelected()) {
 	    		
 	    	}
 	 }


	public void initialize() throws IOException{
		
		// set the choice for campus location choice box button
		 //data = FXCollections.observableArrayList();
		
	      this.campusLoc.setItems(campusLocation);
	      campusLoc.setValue("Vaxjo");
	   
	   
	        
	}  @FXML
    void reservebtn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/Reserve.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void initMain(Main mainWindow) {
	
		this.mainWindow = mainWindow;
		
	}

	
}
