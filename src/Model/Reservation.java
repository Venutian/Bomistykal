package Model;

import java.util.Date;

public class Reservation {

	private Date checkIn;
	private Date checkOut;
	private String clientID;
	private String roomID;
	private String EmployeeUN;
	private int totalPrice;
	private String ReservationID;
	private int guestNum;
	//new SimpleStringProperty
	public Reservation(Date checkIn,Date checkOut, String clientID,String roomID,String EmployeeUN, String ReservationID, int guestNum) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.clientID =clientID;
		this.roomID = roomID;
		this.EmployeeUN = EmployeeUN;
		this.ReservationID = ReservationID;
		this.guestNum = guestNum;
	}
		
	
	/*setters*/
    public void setReservationID(String ReservationID) {
	this.ReservationID = ReservationID;
	}
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
		this.EmployeeUN = emp;
	}
	public void setTotalPrice(int price) {
		this.totalPrice = price;
	}
	public void setGuestNumber(int guestNum) {
		this.guestNum = guestNum;
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
		return this.EmployeeUN;
	}
	public int getTotalPrice() {
		return this.totalPrice;
	}
	public String getReservationID() {
		return this.ReservationID;
	}
	public int getGuestNum() {
		return this.guestNum; 
	}
	
	
}
