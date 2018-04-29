package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Sqlconnection{
	public static void main(String[] args) throws Exception {
		getConnection();
	}




public void addRoom(Room room) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,IDRoom)  VALUES ('2','APOEL');");
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






 private static Connection getConnection() throws Exception{
  try{
 //  String driver = "com.mysql.jdbc.Driver";
	  String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/database";
	   String username = "andreas";
	   String password = "apoel1234";
	   Class.forName(driver);
	   
	   Connection conn = DriverManager.getConnection(url,username,password);
	  
	   
	  
   System.out.println("Connected");
   return conn;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }
 
}