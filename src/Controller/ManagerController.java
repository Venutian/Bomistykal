package Controller;


import Model.*;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ManagerController implements Initializable {
	
    @FXML
    private ChoiceBox<String> campusLoc;

    //Room
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
    private TableColumn <Room, String> tabCol_View;

    @FXML
    private TableColumn <Room, String> tabCol_Smoke;

    @FXML
    private TableColumn <Room, String> tabCol_Adjoint;
    @FXML
    private TableColumn <Room, String> tabCol_AdjointID;
    @FXML
    private MenuItem createNewRoomItem, updateRoomItem;


    //Employee
    @FXML
    private TableView<Employee> tabViewEmp;

    @FXML
    private TableColumn<Employee, String> tabCol_EmpName;

    @FXML
    private TableColumn<Employee, String> tabCol_EmpID;

    @FXML
    private TableColumn<Employee, String> tabCol_EmpUsername;

    @FXML
    private TableColumn<Employee, String> tabCol_EmpPassword;

    @FXML
    private TableColumn<Employee, String> tabCol_EmpAd;

    @FXML
    private TableColumn <Employee, String> tabCol_EmpPhone;


    @FXML
    private AnchorPane anchor_CreateRoom, anchor_UpdateRoom, anchor_DeleteRoom;

    @FXML
    private AnchorPane anchor_CreateAccount, anchor_EditAccount, anchor_DeleteAccount;

    @FXML
    private MenuItem createNewAccItem, changePassOrUserItem, deleteAccItem;

    @FXML
    private MenuItem goToMenuItem;

    @FXML
    private MenuItem signOutItem;
    @FXML
    private TextField addRoomIDTextF, priceAddTextF, addRoomSizeTextF, addNoOfBedTextF, addAdjointRoomIDTextF;

    @FXML
    private CheckBox addViewCB, addAdjointCB, addSmokingCB;

    @FXML
    private AnchorPane anchor_adjoint, anchor_updateAdjoint;

    @FXML
    private ChoiceBox<String> addLocChoiceBox, updateLocChoiceBox;

    @FXML
    private TextField searchUpdateRoomTextF, updateRoomIDTextF, priceUpdateTextF, updateRoomSizeTextF, updateNoOfBedTextF, updateAdjointRoomIDTextF, searchDeleteRoomTextF;

    @FXML
    private CheckBox updateViewCB, updateAdjointCB, updateSmokingCB, isManager;

    @FXML
    private TextField addAccNameTextF, addAccIDTextF, addAccAddTextF, addPhoneNoTextF, addAccEmailTextF, addAccUserTextF, addAccPassWordTextF,
            addAccPassWord2TextF, searchEmplNameTextF;

   private ObservableList<String> campusLocation;
   private Alerts al;
   private LoginController lc;
   private Sqlconnection sq;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {

        this.al = new Alerts();

        this.sq = new Sqlconnection();
   	}
    @FXML
    public void goToMenuMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        Image anotherIcon = new Image("logo.png");
        primaryStage.getIcons().add(anotherIcon);
        primaryStage.setTitle("Linnaeus Hotel");
        primaryStage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void createNewRoomMenu(ActionEvent event) throws Exception {
        this.addLocChoiceBox.setItems(campusLocation);
        this.campusLocation = FXCollections.observableArrayList("Vaxjo", "Kalmar");
        if (event.getTarget() == createNewRoomItem) {
            anchor_CreateRoom.setVisible(true);
            anchor_UpdateRoom.setVisible(false);
            anchor_CreateAccount.setVisible(false);
            anchor_EditAccount.setVisible(false);
        }

    }


    @FXML
    public void UpdateRoomMenu(ActionEvent event) throws Exception {
        if (event.getTarget() == updateRoomItem) {
            anchor_CreateRoom.setVisible(false);
            anchor_UpdateRoom.setVisible(true);
            anchor_CreateAccount.setVisible(false);
            anchor_EditAccount.setVisible(false);

        }
        // set the choice for campus location choice box button
        //data = FXCollections.observableArrayList();
   
        RoomList rm = new RoomList();
        ObservableList<Room> data;
        try {
            data = rm.getRooms();

            tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
            tabCol_Price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Price"));
            tabCol_Size.setCellValueFactory(new PropertyValueFactory<Room, Integer>("RoomSize"));
            tabCol_Beds.setCellValueFactory(new PropertyValueFactory<Room, Integer>("NumOfBed"));
            tabCol_Location.setCellValueFactory(new PropertyValueFactory<Room, String>("Location"));
            tabCol_View.setCellValueFactory(new PropertyValueFactory <Room, String>("Views"));
            tabCol_Smoke.setCellValueFactory(new PropertyValueFactory <Room, String>("Smoke"));
            tabCol_Adjoint.setCellValueFactory(new PropertyValueFactory <Room, String>("Adjoints"));
            tabCol_AdjointID.setCellValueFactory(new PropertyValueFactory <Room, String>("AdjoindsRoomID"));
            tabView.setItems(data);
            tabView.setEditable(true);
            tabCol_Id.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_Price.setCellFactory(TextFieldTableCell.<Room, Integer>forTableColumn(new IntegerStringConverter()));
            tabCol_Size.setCellFactory(TextFieldTableCell.<Room, Integer>forTableColumn(new IntegerStringConverter()));
            tabCol_Beds.setCellFactory(TextFieldTableCell.<Room, Integer>forTableColumn(new IntegerStringConverter()));
            tabCol_Location.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_View.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_Smoke.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_Adjoint.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_AdjointID.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //
        // table contents
    }

    @FXML
    public void CreateRoombtn(ActionEvent event) throws Exception {

    	RoomList rl = new RoomList();

    	if(!rl.checkIfRoomExists(addRoomIDTextF.getText()))
    		al.reportError("A room with the same room id already exists in the database.");
    	else {
    	 Room rm = new Room(addRoomIDTextF.getText().toString(), Integer.parseInt(priceAddTextF.getText()), Integer.parseInt(addRoomSizeTextF.getText()),
    	 Integer.parseInt(addNoOfBedTextF.getText()),addLocChoiceBox.getValue() , addViewCB.isSelected(), addSmokingCB.isSelected(),
    	 addAdjointCB.isSelected(), addAdjointRoomIDTextF.getText().toString());

    	 Sqlconnection sq = new Sqlconnection();
    	sq.addRoom(rm);
			al.reportInformation("New room is successfully created");
    		       }
    }


    public void CreateEmployeeBtn(ActionEvent event) throws Exception {

    	if (addAccNameTextF.getText().isEmpty()|| addAccIDTextF.getText().isEmpty() || addAccUserTextF.getText().isEmpty()
    		|| addAccAddTextF.getText().isEmpty()|| addPhoneNoTextF.getText().isEmpty()| addAccPassWordTextF.getText().isEmpty()) {
    		
    	  al.reportError("Please fill all the text fields!");
	       
    	} else
    	{
        try {
        	EmployeeList s = new EmployeeList();
        	if(s.checkIfEmployeeExists(addAccIDTextF.getText(),addAccNameTextF.getText()))
        		al.reportError("Employee already exists with this idnumber or user name!");
        	else {
        		
        	
        	
            Employee emp = new Employee(addAccNameTextF.getText().toString(), addAccIDTextF.getText().toString(),
            addAccUserTextF.getText().toString(), addAccPassWordTextF.getText().toString(),
            addAccAddTextF.getText().toString(), addPhoneNoTextF.getText().toString(), isManager.isSelected());
            sq.addEmployee(emp);
            
	     	 al.reportInformation("New account is successfully created");
	     	
	     		addAccNameTextF.setText("");
	            addAccIDTextF.setText("");
	            addAccAddTextF.setText("");
	            addPhoneNoTextF.setText("");
	            addAccUserTextF.setText("");
	            addAccPassWordTextF.setText("");
	            addAccPassWord2TextF.setText("");
	            isManager.setSelected(false);
	            
	     	
        	}} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    }

    @FXML
    public void cancelbtn(ActionEvent event) {

		if (al.responseAlert("Are you sure you would like to cancel?")){
			addRoomIDTextF.setText("");
	        priceAddTextF.setText("");
	        addRoomSizeTextF.setText("");
	        addNoOfBedTextF.setText("");
	        addLocChoiceBox.setAccessibleText(null);
	        addViewCB.setSelected(false);
	        addSmokingCB.setSelected(false);
	        addAdjointCB.setSelected(false);
	        addAdjointRoomIDTextF.setText("");
	        anchor_CreateRoom.setVisible(false);
           
		} 
    	} 


    @FXML
    public void cancelUpdateRoom(ActionEvent event) {

        searchUpdateRoomTextF.setText("");
        updateRoomIDTextF.setText("");
        priceUpdateTextF.setText("");
        updateRoomSizeTextF.setText("");
        updateNoOfBedTextF.setText("");
        updateLocChoiceBox.setAccessibleText(null);
        updateViewCB.setSelected(false);
        updateSmokingCB.setSelected(false);
        updateAdjointCB.setSelected(false);
        updateAdjointRoomIDTextF.setText("");
        anchor_UpdateRoom.setVisible(false);

    }



    public void CreateNewAccountMenu(ActionEvent event) throws IOException {
        if (event.getTarget() == createNewAccItem) {
            anchor_CreateAccount.setVisible(true);
            anchor_EditAccount.setVisible(false);
            anchor_CreateRoom.setVisible(false);
            anchor_UpdateRoom.setVisible(false);

        }
    }
    @FXML
    public void changeUserOrPassMenu(ActionEvent event) throws Exception {
        if (event.getTarget() == changePassOrUserItem) {
            anchor_CreateAccount.setVisible(false);
            anchor_EditAccount.setVisible(true);
            anchor_CreateRoom.setVisible(false);
            anchor_UpdateRoom.setVisible(false);

        }
        
        ObservableList<Employee> data;
        EmployeeList em = new EmployeeList();
        try {
            data = em.getEmployyesList();


            tabCol_EmpID.setCellValueFactory(new PropertyValueFactory<Employee, String>("IDNumber"));
            tabCol_EmpName.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
            tabCol_EmpUsername.setCellValueFactory(new PropertyValueFactory<Employee, String>("UserName"));
            tabCol_EmpPassword.setCellValueFactory(new PropertyValueFactory<Employee, String>("Password"));
            tabCol_EmpAd.setCellValueFactory(new PropertyValueFactory<Employee, String>("Address"));
            tabCol_EmpPhone.setCellValueFactory(new PropertyValueFactory <Employee, String>("PhoneNumber"));
            tabViewEmp.setItems(data);
            tabViewEmp.setEditable(true);

            tabCol_EmpID.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_EmpName.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_EmpUsername.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_EmpPassword.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_EmpAd.setCellFactory(TextFieldTableCell.forTableColumn());
            tabCol_EmpPhone.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void canceCreateAccount(ActionEvent event) {
    	
		if (al.responseAlert("Are you sure you would like to cancel?")){
        addAccNameTextF.setText("");
        addAccIDTextF.setText("");
        addAccAddTextF.setText("");
        addPhoneNoTextF.setText("");
        addAccUserTextF.setText("");
        addAccPassWordTextF.setText("");
        addAccPassWord2TextF.setText("");
        anchor_UpdateRoom.setVisible(false);

    } 
    }
    @FXML
    public void cancelEditAcc(ActionEvent event) {


        anchor_EditAccount.setVisible(false);
    }



    @FXML
    public void dailyRepMenu(ActionEvent event) {

    }


    @FXML
    public void monRepMenu(ActionEvent event) {

    }


    @FXML
    //Room Editing
    public void EditRoomPrice(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setPrice(Integer.parseInt(String.valueOf(editedcell.getNewValue())));
        Sqlconnection sql = new Sqlconnection();
        sql.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomSize(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setRoomSize(Integer.parseInt(String.valueOf(editedcell.getNewValue().toString())));
        Sqlconnection sql = new Sqlconnection();
        sql.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomBeds(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setNumOfBed(Integer.parseInt(String.valueOf(editedcell.getNewValue().toString())));
        
        sq.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomLocation(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setLocation(String.valueOf(editedcell.getNewValue().toString()));
      
        sq.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomView (TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setView(String.valueOf(editedcell.getNewValue().toString()));
      
        sq.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomAdjoint (TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setAdjoint(String.valueOf(editedcell.getNewValue().toString()));
     
        sq.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomAdjointID (TableColumn.CellEditEvent editedcell) throws Exception {
    	RoomList rl = new RoomList();
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setAdjoindsRoomID(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    @FXML
    public void EditRoomSmoke (TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setSmoking(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    @FXML
    public void DeleteRoom(ActionEvent event) throws Exception {
        
       if(tabView.getSelectionModel().getSelectedItem() == null) 
        	al.reportError("Please Select a room to delete!");
           else 
        if (al.responseAlert("Are you sure you want to delete this room?")){
            sq.deleteRoom(tabView.getSelectionModel().getSelectedItem());
            UpdateRoomMenu(event);
        } 

    }

    //Employee Editing

    public void EditEmpName(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setName(String.valueOf(editedcell.getNewValue().toString()));
        Sqlconnection sql = new Sqlconnection();
        sql.editEmployee(selectedEmp);
    }


    public void EditEmpUsername(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setUserName(String.valueOf(editedcell.getNewValue().toString()));
        Sqlconnection sql = new Sqlconnection();
        sql.editEmployee(selectedEmp);
    }

    public void EditEmpPassword(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setPassword(String.valueOf(editedcell.getNewValue().toString()));
        Sqlconnection sql = new Sqlconnection();
        sql.editEmployee(selectedEmp);
    }

    public void EditEmpAd(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setAddress(String.valueOf(editedcell.getNewValue().toString()));
        Sqlconnection sql = new Sqlconnection();
        sql.editEmployee(selectedEmp);
    }

    public void EditEmpPhone(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setPhoneNumber(String.valueOf(editedcell.getNewValue().toString()));
        Sqlconnection sql = new Sqlconnection();
        sql.editEmployee(selectedEmp);
    }

    public void DeleteEmp(ActionEvent event) throws Exception {
        Employee emp = tabViewEmp.getSelectionModel().getSelectedItem();
        Sqlconnection sq = new Sqlconnection();
        if (emp == null)
            al.reportError("Please Select a room that you whant to delete!");
        else if (al.responseAlert("Are you sure you want to delete this room?")) {
            sq.deleteEmployee(emp);
            changeUserOrPassMenu(event);
        }
    }

    public void logout(ActionEvent event) throws IOException {
    	lc = new LoginController();
    	if(al.responseAlert("Are you sure you want to log out?"))
    	lc.logout(event);
    	
    }
}
