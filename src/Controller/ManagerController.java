package Controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ManagerController {

	//private AccountController ac;
	private LoginController lg = new LoginController();
	private MenuController mc;
	   @FXML
	    private AnchorPane anchor_CreateRoom;

	    @FXML
	    private AnchorPane anchor_UpdateRoom;

	    @FXML
	    private AnchorPane anchor_DeleteRoom;

	    @FXML
	    private AnchorPane anchor_CreateAccount;

	    @FXML
	    private AnchorPane anchor_EditAccount;

	    @FXML
	    private AnchorPane anchor_DeleteAccount;

	    @FXML
	    private MenuItem createNewAccItem;

	    @FXML
	    private MenuItem changePassOrUserItem;

	    @FXML
	    private MenuItem deleteAccItem;
	    @FXML
	    private MenuItem createNewRoomItem;

	    @FXML
	    private MenuItem updateRoomItem;

	    @FXML
	    private MenuItem deleteRoomItem;
	    
	    @FXML
	    private MenuItem goToMenuItem;
	    
	    @FXML
	    private MenuItem signOutItem;

	    
	    
	    
	   @FXML
	    public void createNewRoomMenu(ActionEvent event) {
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
	    public void DeleteRoomMenu(ActionEvent event) {
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
	    public void UpdateRoomMenu(ActionEvent event) {
	    	if (event.getTarget()== updateRoomItem) {	
	    		anchor_CreateRoom.setVisible(false);
		    	anchor_DeleteRoom.setVisible(false);
		    	anchor_UpdateRoom.setVisible(true);
		    	anchor_CreateAccount.setVisible(false);
				 anchor_EditAccount.setVisible(false);
				 anchor_DeleteAccount.setVisible(false);
	    	} 
	    	
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
	    public void changeUserOrPassMenu(ActionEvent event) {
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
	    public void deleteAccountMenu(ActionEvent event) {
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
	    public void goToMenuMenu(ActionEvent event) {
	    	
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
