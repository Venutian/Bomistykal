package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Sqlconnection{
	public static void main(String[] args) throws Exception {
		//int floor, String roomNumber, String desc, int price, int roomSize, int numOfBed,String Location
		Room room = new Room(1,"dd","ddd",3,5,2,"dsa");
		addRoom(room);
	}




public static void addRoom(Room room) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Room (id,sz,loc,rn)  VALUES ('"+room.getFloor()+"','"+room.getPrice()+"','"+room.getDescription()+"','"+room.getRoomNumber()+"');");
	pre.executeUpdate();
}

public void addEmployee(Employee eployee) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,IDRoom)  VALUES ('2','APOEL');");
	pre.executeUpdate();
}

public void addReservation(Reservation reservation) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,IDRoom)  VALUES ('2','APOEL');");
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