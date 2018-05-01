package Controller;


import Model.Room;
import Model.Sqlconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ManagerController {

	

	   @FXML
	    private AnchorPane anchor_CreateRoom, anchor_UpdateRoom, anchor_DeleteRoom;

	    @FXML
	    private AnchorPane anchor_CreateAccount,anchor_EditAccount, anchor_DeleteAccount;

	    @FXML
	    private MenuItem createNewAccItem, changePassOrUserItem, deleteAccItem;
	    @FXML
	    private MenuItem createNewRoomItem, updateRoomItem, deleteRoomItem;
	    
	    @FXML
	    private MenuItem goToMenuItem;
	    
	    @FXML
	    private MenuItem signOutItem;
	    @FXML
	    private TextField addRoomIDTextF, priceAddTextF, addRoomSizeTextF, addNoOfBedTextF,addAdjointRoomIDTextF;

	    @FXML
	    private CheckBox addViewCB, addAdjointCB, addSmokingCB;

	    @FXML
	    private AnchorPane anchor_adjoint,anchor_updateAdjoint;

	    @FXML
	    private ChoiceBox<String> addLocChoiceBox, updateLocChoiceBox;
	    
	    @FXML
	    private TextField searchUpdateRoomTextF,updateRoomIDTextF,priceUpdateTextF,updateRoomSizeTextF,updateNoOfBedTextF,updateAdjointRoomIDTextF,searchDeleteRoomTextF;
	
	    @FXML
	    private CheckBox updateViewCB,updateAdjointCB,updateSmokingCB;


	private MenuController lg;
	private MenuController mc;
	   private Sqlconnection sq;
	   private Room rm;
	    
	   
	   
	   @FXML
	    public void goToMenuMenu(ActionEvent event) throws IOException {
		   Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		   Scene scene = new Scene(root);
		   scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		   Stage primaryStage = new Stage();
		   primaryStage.setScene(scene);
		   primaryStage.show();
	   }
	    
	   @FXML
	    public void createNewRoomMenu(ActionEvent event) throws Exception {
	    	if (event.getTarget() == createNewRoomItem) {
	    	anchor_CreateRoom.setVisible(true);
	    	anchor_UpdateRoom.setVisible(false);
	    	anchor_DeleteRoom.setVisible(false);
	    	anchor_CreateAccount.setVisible(false);
			anchor_EditAccount.setVisible(false);
			anchor_DeleteAccount.setVisible(false);
		       
	    	} 
	   }
	    @FXML
	    public void DeleteRoomMenu(ActionEvent event) throws Exception{
	    	if (event.getTarget()== deleteRoomItem) {	
	    		anchor_CreateRoom.setVisible(false);
	    		anchor_UpdateRoom.setVisible(false);
		    	anchor_DeleteRoom.setVisible(true);
		    	anchor_CreateAccount.setVisible(false);
				anchor_EditAccount.setVisible(false);
				anchor_DeleteAccount.setVisible(false);
	    	}
	    }

	    @FXML
	    public void UpdateRoomMenu(ActionEvent event) throws Exception{
	    	if (event.getTarget()== updateRoomItem) {	
	    		anchor_CreateRoom.setVisible(false);
		    	anchor_DeleteRoom.setVisible(false);
		    	anchor_UpdateRoom.setVisible(true);
		    	anchor_CreateAccount.setVisible(false);
				anchor_EditAccount.setVisible(false);
				anchor_DeleteAccount.setVisible(false);
	    	} 
	    	
	    }

	   @FXML
	    public void createbtn(ActionEvent event) throws Exception {
	    	
		 rm =new Room(addRoomIDTextF.getText().toString(), Integer.parseInt(priceAddTextF.getText()), Integer.parseInt(addRoomSizeTextF.getText()), 
			Integer.parseInt(addNoOfBedTextF.getText()), addLocChoiceBox.getItems().toString(), addViewCB.isSelected(),addSmokingCB.isSelected(),
				  addAdjointCB.isSelected(),addAdjointRoomIDTextF.getText().toString());
		 sq.addRoom(rm);
		 ((Node) (event.getSource())).getScene().getWindow().hide();
	    //if (addAdjointCB.isSelected()) {
	    		//anchor_adjoint.setVisible(true);
	    	//}
	    }
	    
	    @FXML
	    public void cancelbtn(ActionEvent event) {
	    	
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
	    
	    
	    @FXML
	    public void cancelDeleteRoom(ActionEvent event) {
	    	
	    	searchDeleteRoomTextF.setText("");
		     anchor_DeleteRoom.setVisible(false);

	    	}	    
	    public void CreateNewAccountMenu(ActionEvent event) throws IOException {
			 if (event.getTarget()== createNewAccItem) {
				 anchor_CreateAccount.setVisible(true);
				 anchor_EditAccount.setVisible(false);
				 anchor_DeleteAccount.setVisible(false);
				 anchor_CreateRoom.setVisible(false);
			     anchor_DeleteRoom.setVisible(false);
			     anchor_UpdateRoom.setVisible(false);
			 }  }
	    @FXML
	    public void changeUserOrPassMenu(ActionEvent event) throws Exception{
	    	if (event.getTarget()== changePassOrUserItem) {
				 anchor_CreateAccount.setVisible(false);
				 anchor_DeleteAccount.setVisible(false);
				 anchor_EditAccount.setVisible(true);
				 anchor_CreateRoom.setVisible(false);
			     anchor_DeleteRoom.setVisible(false);
			     anchor_UpdateRoom.setVisible(false);
	    	}
	    }

	    @FXML
	    public void deleteAccountMenu(ActionEvent event)throws Exception {
	    	if (event.getTarget()==deleteAccItem) {
				 anchor_CreateAccount.setVisible(false);
				 anchor_EditAccount.setVisible(false);
				 anchor_DeleteAccount.setVisible(true);
				 anchor_CreateRoom.setVisible(false);
			     anchor_DeleteRoom.setVisible(false);
			     anchor_UpdateRoom.setVisible(false);
			 } 
	    }

	    @FXML
	    public void dailyRepMenu(ActionEvent event) {

	    }
	    

	    @FXML
	    void deleteResMenu(ActionEvent event) {

	    }
	   

	    @FXML
	    public void monRepMenu(ActionEvent event) {

	    }

	    @FXML
	    public void signOutMenu(ActionEvent event) throws IOException {
	    	if(event.getTarget() == signOutItem) {
	    		lg.logout(event);
	    		
	    }
	    	
	    }

}
