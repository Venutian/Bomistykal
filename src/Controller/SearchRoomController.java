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
    private TableColumn<Room, String> tabCol_Id;

    @FXML
    private TableColumn<Room, Integer> tabCol_Price;

    @FXML
    private TableColumn<Room, Integer> tabCol_Size;

    @FXML
    private TableColumn<Room, Integer> tabCol_Beds;

    @FXML
    private TableColumn<Room, String> tabCol_Location;

    @FXML
    private TableColumn<Room, String> tabCol_Availble;

    @FXML
    private Label roomDetails;

    @FXML
    private CheckBox viewBox;

    @FXML
    private CheckBox SingleBedBox;
    
    @FXML
    private ListView<String> roomList = new ListView<String>();
   

    private ObservableList<Room> roomsForReserve;
    
    ObservableList<String> campusLocation  	= FXCollections.observableArrayList("Vaxjo" , "Kalmar");
   
   
	
	@FXML
    public void reservebtn(ActionEvent event) throws IOException {
		Date checkInD = Date.from(checkIn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date checkOutD = Date.from(checkOut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Reserve.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
    	ReserveController controller = fxmlLoader.<ReserveController>getController();
    	controller.setRooms(roomsForReserve,checkInD,checkOutD);
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
    @FXML
    public void resetBtn(ActionEvent event) throws IOException {
    	checkIn.setValue(null);
    	checkOut.setValue(null);
    	smokingBox.setSelected(false);
    	petsBox.setSelected(false);
    	adjointBox.setSelected(false);
    	doubleBedBox.setSelected(false);
    	twinBedBox.setSelected(false);
    	viewBox.setSelected(false);
    	SingleBedBox.setSelected(false);
    	campusLoc.setValue(null);;
		
	}
    
    @FXML
    void addRoomToList(ActionEvent event) {
    	Room room = tabView.getSelectionModel().getSelectedItem();
    	roomList.getItems().add(room.getRoomID());
    	roomsForReserve.add(room);
    	tabView.getItems().remove(room);
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
        roomsForReserve  = FXCollections.observableArrayList();
		Sqlconnection sq = new Sqlconnection();
		this.campusLoc.setItems(campusLocation);
		campusLoc.setValue("Vaxjo");
		ObservableList<Room> data;
		try {
					data = sq.getRooms();

            tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
            tabCol_Price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Price"));
            tabCol_Size.setCellValueFactory(new PropertyValueFactory<Room, Integer>("RoomSize"));
            tabCol_Beds.setCellValueFactory(new PropertyValueFactory<Room, Integer>("NumOfBed"));
            tabCol_Location.setCellValueFactory(new PropertyValueFactory<Room, String>("Location"));
                     tabView.setItems(data);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			 
	}
	
	@FXML
    void searchForRoom(ActionEvent event) throws Exception {
		
		System.out.println(campusLoc.getValue());
		//String campusLoc,Date s, Date sa,boolean view ,boolean smoking,boolean adjoined,boolean doubleBed
		Date checkInD = Date.from(checkIn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date checkOutD = Date.from(checkOut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		int numOfBeds = 0;
		if(doubleBedBox.isSelected() || twinBedBox.isSelected())
			numOfBeds = 2;
		else if(SingleBedBox.isSelected())
			numOfBeds = 1;
		
	    SearchFactory sc = new SearchFactory(campusLoc.getValue(),checkInD,checkOutD,viewBox.isSelected(),smokingBox.isSelected(),adjointBox.isSelected(),numOfBeds);

        ObservableList<Room> data = sc.getAvailableRooms();


        tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
        tabCol_Price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Price"));
        tabCol_Size.setCellValueFactory(new PropertyValueFactory<Room, Integer>("RoomSize"));
        tabCol_Beds.setCellValueFactory(new PropertyValueFactory<Room, Integer>("NumOfBed"));
        tabCol_Location.setCellValueFactory(new PropertyValueFactory<Room, String>("Location"));

    }
	
	
	
}
