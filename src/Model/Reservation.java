package Model;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class Reservation {

	private Date checkIn;
	private Date checkOut;
	private String clientID;
	private String roomID;
	private String empUserName;
	 private int totalPrice;
	private String ReservationID;
	//new SimpleStringProperty
	public Reservation(Date checkIn,Date checkOut, String clientID,String roomID,String empUserName, String ReservationID) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.clientID =clientID;
		this.roomID = roomID;
		this.empUserName = empUserName;
		setReservationID();
	}
	
	private void setReservationID() {
		/*calculate reservation id */
		this.ReservationID = "123";
	}
	
	
	
	/*setters*/
	
	public void setCheckInDate(Date date) {
		this.checkIn = date;
	}
	
   public void setCheckoutDate(Date date) {
		this.checkOut = date;
	}
	public void setClient(String client) {
		this.clientID = client ;
	}
	public void setRoom(String room) {
		this.roomID = room;
	}
	public void setEmployee(String emp) {
		this.empUserName = emp;
	}
	public void setTotalPrice(int price) {
		this.totalPrice = price;
	}
	
	/*getters*/
	public Date getCheckInDate() {
		return this.checkIn;
	}
	public Date getCheckOutDate() {
		return this.checkOut;
	}
	public String getClient() {
		return this.clientID.toString();
	}
	public String getRoom() {
		return this.roomID.toString();
	}
	public String getEmployee() {
		return this.empUserName;
	}
	public int getTotalPrice() {
		return this.totalPrice;
	}
	public String getReservationID() {
		return this.ReservationID;
	}
	
	
	
}
