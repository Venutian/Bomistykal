package Model;

public class Employee {
/*name idnumber username password address telephone number */
	private String name;
	private String userName;
	private String IDNumber;
	private String password;
	private String address;
	private int phoneNumber;
	
	public Employee(String name, String IDNumber,String userName,String password,String address,int phoneNumber) {
		this.name = name;
		this.userName = userName;
		this.IDNumber = IDNumber;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/*setters*/
	public void setName(String name) {
		this.name = name;
	}
	public void setIDNumber(String id) {
		this.IDNumber = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getUserName() {
		return this.userName;
	}
	public String getPassword() {
		return this.password;
	}
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getAddress() {
		return this.address;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

