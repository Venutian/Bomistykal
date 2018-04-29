package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
public class Sqlconnection{
	public static void main(String[] args) throws Exception {
		//int floor, String roomNumber, int price, int roomSize,String Location
		//Room room = new Room(1,"dd",3,5,"dsa");
		//addRoom(room);
	}




public static void addRoom(Room room) throws Exception {

	//int Floor, String	RoomID, int	Price, int	RoomSize,String	Location,String	Description
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Room (Floor,RoomID,Price,Location,Description) "
    		+ " VALUES ('"+room.getFloor()+"','"+room.getRoomNumber()+"','"+room.getPrice()+"','"+room.getLocation()+"','"+room.getDescription()+"');");
	pre.executeUpdate();
}

public void addEmployee(Employee eployee) throws Exception {
	//String name, String IDNumber,String userName,String password,String address,int phoneNumber,boolean manager
	//Name	IDNumber	UserName	Password	Adrress	PhoneNumber	Manager
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Employee (Name,IDNumber,UserName,Password,Adrress,PhoneNumber,Manager) "
    		+ " VALUES ('"+eployee.getName()+"','"+eployee.getIDNumber()+"','"+eployee.getUserName()+"','"+eployee.getPassword()+"','"+eployee.getAddress()+"','"+eployee.getPhoneNumber()+"','"+eployee.isManager()+"');");
	pre.executeUpdate();
}

public void addReservation(Reservation reservation) throws Exception {
	//Date checkIn,Date checkOut, Client client,Room room,Employee emp
	//CheckIn	CheckOut	ClientID	RoomID	EmployeeUN	ReservationID
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Reservation (CheckIn,CheckOut,ClientID,RoomID,EmployeeUN,ReservationID)"
    		+ "  VALUES ('"+reservation.getCheckInDate()+"','"+reservation.getCheckOutDate()+"','"+reservation.getClient()+"','"+reservation.getRoom()+"','"+reservation.getReservationID()+"');");
	pre.executeUpdate();
}




public void deleteRoom(Room room) throws Exception{
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,RoomNumber,floor,price,roomsize,location,numofbeds,bedtype) "
    		+ " VALUES ('"+1+"','"+room.getRoomNumber()+"','"+room.getFloor()+"','"+room.getPrice()+"','"+room.getRoomSize()+"','"+room.getLocation()+"',"
    				+ "'"+room.getNumOfBed()+"','gfd');");
	pre.executeUpdate();
}
public void deleteEmployee(Employee employee) throws Exception{
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,IDRoom)  VALUES ('2','APOEL');");
	pre.executeUpdate();
}
public void deleteReservation(Room reservation) throws Exception{
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,IDRoom)  VALUES ('2','APOEL');");
	pre.executeUpdate();
}






 public static Connection getConnection() throws Exception{
  try{
 //  String driver = "com.mysql.jdbc.Driver";
	/*  String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/database";
	   String username = "andreas";
	   String password = "apoel1234";
	   Class.forName(driver);*/
	  
	  //sql7.freesqldatabase.com
	  //sql7235306
	 // ed5j4AGc2a
	   Connection conn = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com/sql7235306","sql7235306","ed5j4AGc2a");
	  
	   
	  
   System.out.println("Connected");
   return conn;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }
 
}