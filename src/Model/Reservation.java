package Model;

import java.util.Date;

public class Reservation {

	Date checkIn;
	Date checkOut;
	Client client;
	Room room;
	Employee emp;
	int totalPrice;
	
	public Reservation(Date checkIn,Date checkOut, Client client,Room room,Employee emp,int totalPrice) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.client = client;
		this.room = room;
		this.emp = emp;
		this.totalPrice = totalPrice;
	}
	
	/*setters*/
	public void setCheckInDate(Date date) {
		this.checkIn = date;
	}
	
   public void setCheckoutDate(Date date) {
		this.checkOut = date;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public void setEmployee(Employee emp) {
		this.emp = emp;
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
	public Client getClient() {
		return this.client;
	}
	public Room getRoom() {
		return this.room;
	}
	public Employee getEmployee() {
		return this.emp;
	}
	public int getTotalPrice() {
		return this.totalPrice;
	}
	
	
	
	
}
