package Controller;


import Model.Room;
import Model.SearchFactory;
import Model.Sqlconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;



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
    private TableView<Room> tabView;

    @FXML
    private TableColumn<Room, String> tabCol_Des;

    @FXML
    private TableColumn<Room, String> tabCol_Id;

    @FXML
    private TableColumn<Room, String> tabCol_Availble;

    @FXML
    private Label roomDetails;

    @FXML
    private CheckBox viewBox;

    @FXML
    private CheckBox SingleBedBox;
    
   

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


	
	@FXML
    public void reservebtn(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/Reserve.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
    @FXML
    public void resetBtn(ActionEvent event) throws IOException {
    	checkIn.setValue(null);
    	checkOut.setValue(null);
    	smokingBox.setSelected(false);
    	nonSmokingBox.setSelected(false);
    	petsBox.setSelected(false);
    	adjointBox.setSelected(false);
    	doubleBedBox.setSelected(false);
    	twinBedBox.setSelected(false);
    	viewBox.setSelected(false);
    	SingleBedBox.setSelected(false);
    	campusLoc.setValue(null);;
		
	}
	@FXML
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
		// set the choice for campus location choice box button
				 //data = FXCollections.observableArrayList();
				Sqlconnection sq = new Sqlconnection();
			      this.campusLoc.setItems(campusLocation);
			      campusLoc.setValue("Vaxjo");
			      ObservableList<Room> data ;
			     try {
					data = sq.getRooms();

                     tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
                     tabCol_Des.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
                     tabCol_Availble.setCellValueFactory(new PropertyValueFactory<Room, String>("AdjoindsRoomID"));
                     tabView.setItems(data);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      //
			   // table contents 
	}
	
	@FXML
    void searchForRoom(ActionEvent event) throws Exception {
		
		System.out.println(campusLoc.getValue());
		//String campusLoc,Date s, Date sa,boolean view ,boolean smoking,boolean adjoined,boolean doubleBed
		Date checkInD = Date.from(checkIn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date checkOutD = Date.from(checkOut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
	    SearchFactory sc = new SearchFactory(campusLoc.getValue(),checkInD,checkOutD,viewBox.isSelected(),smokingBox.isSelected(),adjointBox.isSelected(),doubleBedBox.isSelected());

	    ObservableList<Room> data = sc.getAvailableRooms(); 
	    

        tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
        tabCol_Des.setCellValueFactory(new PropertyValueFactory<Room, String>("Description"));
        tabCol_Availble.setCellValueFactory(new PropertyValueFactory<Room, String>("AdjoindsRoomID"));
        tabView.setItems(data);
	    
    }
	
	
	
}
