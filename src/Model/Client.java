package Model;

import java.util.Date;

public class Client {
	/*name,address, telephone number, credit card, passport number,*/
	private String name;
	private int creditCardNumber;
	private Date creditCardExpDate;
	private int phoneNumber;
	private String IDNumber;
	private String address;
	
	
	public Client (String name,String IDNumber, int creditCardNumber,Date creditCardExpDate, int phoneNumber,String address) {
		this.name = name;
		this.IDNumber = IDNumber;
		this.creditCardNumber = creditCardNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditCardExpDate =creditCardExpDate;
	
	}

	
	/*setters*/
	public void setName(String name) {
		this.name = name;
	}
	public void setIDNumber(String id) {
		this.IDNumber = id;
	}
	public void setCreditCardNum(int crn) {
		this.creditCardNumber = crn;
	}
	public void setCreditCardExpDate(Date creditCardExpDate) {
		this.creditCardExpDate =creditCardExpDate;
	}
	public void setPhoneNumber(int pnum) {
		this.phoneNumber = pnum;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/*getters*/
	public String getName() {
		return this.name;
	}
	public String getIDNumber() {
		return this.IDNumber;
	}
	public int getCreditCardNum() {
		return this.creditCardNumber;
	} 
	public Date getCreditCardExpDate() {
		return this.creditCardExpDate;
	}
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getAddress() {
		return this.address;
	} 
	
	
	
	
	
	
	
	
	
}
