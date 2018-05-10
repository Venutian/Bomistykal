package Controller;



import Model.Room;
import Model.RoomList;
import Model.SearchFactory;
import View.Alerts;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import java.util.ResourceBundle;



public class SearchRoomController implements Initializable{
   

    @FXML
    private AnchorPane anchor;

    @FXML
    private ChoiceBox<String> campusLoc;

    @FXML
    private DatePicker checkIn,checkOut;

    @FXML
    private TextField managerSearch;
   
    @FXML
    private CheckBox smokingBox,adjointBox,doubleBedBox,twinBedBox,bigRoomBox,mediumRoomBox,smallRoomBox,viewBox,SingleBedBox;

    @FXML
    private TableView<Room> tabView;

    @FXML
    private TableColumn<Room, String> tabCol_Id;

    @FXML
    private TableColumn<Room, Integer> tabCol_Price,tabCol_Size,tabCol_Beds;

    @FXML
    private TableColumn<Room, String> tabCol_Location,tabCol_Availble;

    @FXML
    private Label roomDetails;

    @FXML
    private AnchorPane managers;
    
    @FXML
    private ListView<String> roomList;
    
    
    private	 ObservableList<Room> data;
    private  Alerts al ;
    private  boolean isManager;
    private  ObservableList<Room> roomsForReserve;
    private  ObservableList<String> campusLocation;
    private  RoomList rm ;
    private  Room room;
    private  SearchFactory sc;
    
	
	@FXML
    public void reservebtn(ActionEvent event) throws IOException {
		if(roomsForReserve.isEmpty())
			al.reportError("Please choose a room before proceeding to make a reservation!");
		else {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Reserve.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
    	ReserveController controller = fxmlLoader.<ReserveController>getController();
    	controller.setRooms(roomsForReserve,convertToDate(checkIn.getValue()),convertToDate(checkOut.getValue()));
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
    @FXML
    public void resetBtn(ActionEvent event) throws IOException {
    	checkIn.setValue(null);
    	checkOut.setValue(null);
    	smokingBox.setSelected(false);
    	adjointBox.setSelected(false);
    	doubleBedBox.setSelected(false);
    	twinBedBox.setSelected(false);
    	viewBox.setSelected(false);
    	SingleBedBox.setSelected(false);
    	campusLoc.setValue(null);
		
	}
    
    @FXML
    void addRoomToList(ActionEvent event) {
    	//checkIn,checkOut
    	if(checkIn.getValue() == null || checkOut.getValue() == null) 
    		al.reportError("Please fill choose check in and check out date!");
    	else{
    	room = tabView.getSelectionModel().getSelectedItem();
    	//method that checks the list finds the other adjoining room and adds it to the lists.
    	roomList.getItems().add(room.getRoomID());
    	roomsForReserve.add(room);
    	tabView.getItems().remove(room);
    	
    	if(adjointBox.isSelected()) {
    		Room adjoined = rm.adjoinedFind(room,data);
    		roomList.getItems().add(adjoined.getRoomID());
        	roomsForReserve.add(adjoined);
        	//remove needs fixing
        	tabView.getItems().remove(adjoined);
    	}
    	}	
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
		
		this.campusLocation = FXCollections.observableArrayList("Vaxjo" , "Kalmar");
		this.al = new Alerts();
		this.roomsForReserve  = FXCollections.observableArrayList();
		this.campusLoc.setItems(campusLocation);
		this.campusLoc.setValue("Vaxjo");
		this.rm = new RoomList();
		
		//make it to appear only for the manager
		if(!isManager)
		managers.setVisible(false);
		try {
		this.data = rm.getRooms();
		} catch (Exception e) {
		e.printStackTrace();
		}

		setTable();
	}
	
	@FXML
    void searchForRoom(ActionEvent event) throws Exception {
		
		int numOfBeds = getNumOfBeds();
		int RoomSize = getRoomSize();
        
		
		
		if(numOfBeds == 0 || RoomSize == 0) {
			al.reportError("Please tick one of the choices bed type and room type!!");
		}
		else {
		sc = new SearchFactory(campusLoc.getValue(), convertToDate(checkIn.getValue()),convertToDate(checkOut.getValue()), viewBox.isSelected(), smokingBox.isSelected(), adjointBox.isSelected(), numOfBeds, RoomSize);

		if(!sc.datesAreCorrect())
			al.reportError("Please fill the dates properly!");
		else {
		 data = sc.getAvailableRooms();	

		 /*if the list that comes back for the campus that we search for is empty
		  * it will check on the other campus if there are available rooms and offer only if they
		  * are available..*/
        if(data.isEmpty()) {
        String otherCampus = sc.offerRoomToOtherCampus(campusLoc.getValue());
        sc = new SearchFactory(otherCampus,convertToDate(checkIn.getValue()),convertToDate(checkOut.getValue()), viewBox.isSelected(), smokingBox.isSelected(), adjointBox.isSelected(), numOfBeds, RoomSize); 
     
        if(!sc.getAvailableRooms().isEmpty())
        	al.reportInformation("There are no available rooms in "+campusLoc.getValue()+" but there are in " +otherCampus);
        data = sc.getAvailableRooms();	
        }
       
       setTable();
		}
	}
    }
	
	
	
	private int getNumOfBeds() {
		if(doubleBedBox.isSelected() && twinBedBox.isSelected()&&SingleBedBox.isSelected())
			return 0;
		if(doubleBedBox.isSelected() || twinBedBox.isSelected())
			return 2;
		else if(SingleBedBox.isSelected())
			return 1;
		return 0;
	}
	private int getRoomSize() {
		if(bigRoomBox.isSelected()&&mediumRoomBox.isSelected()&&smallRoomBox.isSelected())
			return 0;
		     if (bigRoomBox.isSelected())
            return 50;
        else if (mediumRoomBox.isSelected())
        	return 35;
        else if (smallRoomBox.isSelected())
        	return 25;
        
        return 0;
	}
	
	private void setTable() {
		    tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
	        tabCol_Price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Price"));
	        tabCol_Size.setCellValueFactory(new PropertyValueFactory<Room, Integer>("RoomSize"));
	        tabCol_Beds.setCellValueFactory(new PropertyValueFactory<Room, Integer>("NumOfBed"));
	        tabCol_Location.setCellValueFactory(new PropertyValueFactory<Room, String>("Location"));
	        tabView.setItems(data);
	}
	
	private Date convertToDate(LocalDate locaDate) {
    	return Date.from(locaDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public void isAmanager() {
		this.isManager = true;
	}
}
