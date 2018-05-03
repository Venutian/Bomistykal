package Controller;



import Model.BillCalculator;
import Model.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ConfirmationController{
/*This class is responsible for printing of the bill and confirming check in and out and cancelation*/
    @FXML
    private Label ConfirmationType;


    @FXML
    private Label billPrice;

    @FXML
    private Label ClientsID;

    @FXML
    private Label RoomNumber;

    @FXML
    private Label CheckIn;

    @FXML
    private Label CheckOut;


    
    public void setCancel(Reservation res) {
    	ConfirmationType.setText("Reservation is Canceled!");
    	BillCalculator bill = new BillCalculator(res);
    	billPrice.setText(Integer.toString(bill.getFinalPrice()));
    	ClientsID.setText(res.getClient());
    	CheckIn.setText(res.getCheckInDate().toString());
    	CheckOut.setText(res.getCheckOutDate().toString());
    }
  
    public void setCheckIn(Reservation res) {
    	ConfirmationType.setText("Check In confirmed!");
    	ClientsID.setText(res.getClient());
    	CheckIn.setText(res.getCheckInDate().toString());
    	CheckOut.setText(res.getCheckOutDate().toString());
    }
    
    public void setCheckOut(Reservation res) {
    	ConfirmationType.setText("Check Out confirmed!");
    	BillCalculator bill = new BillCalculator(res);
    	billPrice.setText(Integer.toString(bill.getFinalPrice()));
    	ClientsID.setText(res.getClient());
    	CheckIn.setText(res.getCheckInDate().toString());
    	CheckOut.setText(res.getCheckOutDate().toString());
    }

	
    
    
}