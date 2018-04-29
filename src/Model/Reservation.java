package Model;

import java.util.Date;

public class Reservation {

	Date checkIn;
	Date checkOut;
	String clientID;
	String roomID;
	String empUserName;
	int totalPrice;
	String ReservationID;
	
	public Reservation(Date checkIn,Date checkOut, String clientID,String roomID,String empUserName) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.clientID = clientID;
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
		this.clientID = client;
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
		return this.clientID;
	}
	public String getRoom() {
		return this.roomID;
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
