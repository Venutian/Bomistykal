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
    //Room
    @FXML
    private TableView<Room> tabView;

    @FXML
    private TextField addRoomIDTextF, priceAddTextF, addRoomSizeTextF, addNoOfBedTextF, addAdjointRoomIDTextF;

    @FXML
    private TableColumn<Room, Integer> tabCol_Beds, tabCol_Size, tabCol_Price;

    @FXML
    private TableColumn<Room, String> tabCol_Id, tabCol_Adjoint, tabCol_AdjointID, tabCol_Smoke, tabCol_View, tabCol_Location;

    @FXML
    private CheckBox addViewCB, addAdjointCB, addSmokingCB;
    @FXML
    private ChoiceBox<String> addLocChoiceBox;


    //Employee
    @FXML
    private TextField addAccNameTextF, addAccIDTextF, addAccAddTextF, addPhoneNoTextF, addAccUserTextF, addAccPassWordTextF;

    @FXML
    private TableView<Employee> tabViewEmp;

    @FXML
    private TableColumn<Employee, String> tabCol_EmpName, tabCol_EmpID, tabCol_EmpUsername, tabCol_EmpPassword, tabCol_EmpAd, tabCol_EmpPhone;

    @FXML
    private CheckBox isManager;


    //Pages
    @FXML
    private AnchorPane anchor_CreateRoom, anchor_UpdateRoom, anchor_CreateAccount, anchor_EditAccount;

    @FXML
    private MenuItem createNewRoomItem, updateRoomItem, createNewAccItem, changePassOrUserItem;


    private ObservableList<String> campusLocation;
    private Alerts al;
    private LoginController lc;
    private Sqlconnection sq;
    private  RoomList rl;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.al = new Alerts();
        this.rl = new RoomList();
        this.sq = new Sqlconnection();
        this.campusLocation = FXCollections.observableArrayList("Vaxjo", "Kalmar");
        this.addLocChoiceBox.setItems(campusLocation);
    }

    @FXML
    public void goToMenuMenu(ActionEvent event) throws IOException {
        
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/SearchRoom.fxml"));     
    	Parent root = (Parent)fxmlLoader.load();
    	SearchRoomController controller = fxmlLoader.<SearchRoomController>getController();
    	controller.start(true);
    	Scene scene = new Scene(root); 
        Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void createNewRoomMenu(ActionEvent event) throws Exception {
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

        
        ObservableList<Room> data;
        try {
            data = rl.getRooms();

            tabCol_Id.setCellValueFactory(new PropertyValueFactory<Room, String>("RoomID"));
            tabCol_Price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("Price"));
            tabCol_Size.setCellValueFactory(new PropertyValueFactory<Room, Integer>("RoomSize"));
            tabCol_Beds.setCellValueFactory(new PropertyValueFactory<Room, Integer>("NumOfBed"));
            tabCol_Location.setCellValueFactory(new PropertyValueFactory<Room, String>("Location"));
            tabCol_View.setCellValueFactory(new PropertyValueFactory<Room, String>("Views"));
            tabCol_Smoke.setCellValueFactory(new PropertyValueFactory<Room, String>("Smoke"));
            tabCol_Adjoint.setCellValueFactory(new PropertyValueFactory<Room, String>("Adjoints"));
            tabCol_AdjointID.setCellValueFactory(new PropertyValueFactory<Room, String>("AdjoindsRoomID"));
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


        if (rl.checkIfRoomExists(addRoomIDTextF.getText()) != null)
            al.reportError("A room with the same room id already exists in the database.");
        else {
            Room rm = new Room(addRoomIDTextF.getText().toString(), Integer.parseInt(priceAddTextF.getText()), Integer.parseInt(addRoomSizeTextF.getText()),
                    Integer.parseInt(addNoOfBedTextF.getText()), addLocChoiceBox.getValue(), addViewCB.isSelected(), addSmokingCB.isSelected(),
                    addAdjointCB.isSelected(), addAdjointRoomIDTextF.getText().toString());
            
            sq.addRoom(rm);
            al.reportInformation("New room is successfully created");
        }
    }


    public void CreateEmployeeBtn(ActionEvent event) throws Exception {

        if (addAccNameTextF.getText().isEmpty() || addAccIDTextF.getText().isEmpty() || addAccUserTextF.getText().isEmpty()
                || addAccAddTextF.getText().isEmpty() || addPhoneNoTextF.getText().isEmpty() | addAccPassWordTextF.getText().isEmpty()) {

            al.reportError("Please fill all the text fields!");

        } else {
            try {
                EmployeeList s = new EmployeeList();
                if (s.checkIfEmployeeExists(addAccIDTextF.getText(), addAccNameTextF.getText()))
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
                    isManager.setSelected(false);


                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    @FXML
    public void cancelbtn(ActionEvent event) {

        if (al.responseAlert("Are you sure you would like to cancel?")) {
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
            tabCol_EmpPhone.setCellValueFactory(new PropertyValueFactory<Employee, String>("PhoneNumber"));
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

        if (al.responseAlert("Are you sure you would like to cancel?")) {
            addAccNameTextF.setText("");
            addAccIDTextF.setText("");
            addAccAddTextF.setText("");
            addPhoneNoTextF.setText("");
            addAccUserTextF.setText("");
            addAccPassWordTextF.setText("");
            anchor_UpdateRoom.setVisible(false);

        }
    }

    //Room Editing
    public void EditRoomPrice(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setPrice(Integer.parseInt(String.valueOf(editedcell.getNewValue())));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomSize(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setRoomSize(Integer.parseInt(String.valueOf(editedcell.getNewValue().toString())));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomBeds(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setNumOfBed(Integer.parseInt(String.valueOf(editedcell.getNewValue().toString())));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomLocation(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setLocation(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomView(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setView(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomAdjoint(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setAdjoint(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomAdjointID(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setAdjoindsRoomID(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    public void EditRoomSmoke(TableColumn.CellEditEvent editedcell) throws Exception {
        Room selectedRoom = tabView.getSelectionModel().getSelectedItem();
        selectedRoom.setSmoking(String.valueOf(editedcell.getNewValue().toString()));
        sq.editRoom(selectedRoom);
    }

    public void DeleteRoom(ActionEvent event) throws Exception {
        if (tabView.getSelectionModel().getSelectedItem() == null)
            al.reportError("Please Select a room to delete!");
        else if (al.responseAlert("Are you sure you want to delete this room?")) {
            sq.deleteRoom(tabView.getSelectionModel().getSelectedItem());
            UpdateRoomMenu(event);
        }
    }


    //Employee Editing
    public void EditEmpName(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setName(String.valueOf(editedcell.getNewValue().toString()));
        sq.editEmployee(selectedEmp);
    }


    public void EditEmpUsername(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setUserName(String.valueOf(editedcell.getNewValue().toString()));
        sq.editEmployee(selectedEmp);
    }

    public void EditEmpPassword(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setPassword(String.valueOf(editedcell.getNewValue().toString()));
        sq.editEmployee(selectedEmp);
    }

    public void EditEmpAd(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setAddress(String.valueOf(editedcell.getNewValue().toString()));
        sq.editEmployee(selectedEmp);
    }

    public void EditEmpPhone(TableColumn.CellEditEvent editedcell) throws Exception {
        Employee selectedEmp = tabViewEmp.getSelectionModel().getSelectedItem();
        selectedEmp.setPhoneNumber(String.valueOf(editedcell.getNewValue().toString()));
        sq.editEmployee(selectedEmp);
    }

    public void DeleteEmp(ActionEvent event) throws Exception {
        Employee emp = tabViewEmp.getSelectionModel().getSelectedItem();
        if (emp == null)
            al.reportError("Please Select a room that you whant to delete!");
        else if (al.responseAlert("Are you sure you want to delete this room?")) {
            sq.deleteEmployee(emp);
            changeUserOrPassMenu(event);
        }
    }

    @FXML
    public void cancelEditAcc(ActionEvent event) {
        anchor_EditAccount.setVisible(false);
    }

    public void logout(ActionEvent event) throws IOException {
        lc = new LoginController();
        if (al.responseAlert("Are you sure you want to log out?"))
            lc.logout(event);
    }
}
