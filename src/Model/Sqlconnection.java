package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Sqlconnection{
	


	

/*booom*/
public void addRoom(Room room) throws Exception {
	Connection con = getConnection();
	
	
	//String roomID, int price, int RoomSize,int NumOfBeds ,boolean Location,boolean view ,boolean smoking, getBoolean(room.getLocation())
	PreparedStatement pre = con.prepareStatement("INSERT INTO Room (RoomID,Price,RoomSize,NumOfBeds,Location,View,Smoking,Adjoint,AdjointRoomID) "
			+ " VALUES ('" + room.getRoomID() + "','" + room.getPrice() + "','" + room.getRoomSize() + "','" + room.getNumOfBed() + "','" + room.getLocation() +  "','" +getBoolean(room.getView()) + "','" + getBoolean(room.getSmoking()) + "','" + getBoolean(room.getAdjoint()) + "','" + room.getAdjoindsRoomID() + "');");
	pre.executeUpdate();
	
	pre.close();
	con.close();
}


/*to do.. nth in the database yet about client*/
public void addClient() {
	
}


public  void addEmployee(Employee eployee) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Employee (Name,IDNumber,UserName,Password,Adrress,PhoneNumber,Manager) "
    		+ " VALUES ('"+eployee.getName()+"','"+eployee.getIDNumber()+"','"+eployee.getUserName()+"','"+eployee.getPassword()+"','"+eployee.getAddress()+"','"+eployee.getPhoneNumber()+"','"+getBoolean(eployee.isManager())+"');");
	pre.executeUpdate();
	pre.close();
	con.close();
}

public static void addReservation(Reservation reservation) throws Exception {

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String checkIn = df.format(reservation.getCheckInDate());
	String checkOut = df.format(reservation.getCheckOutDate());
	
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Reservation (CheckIn, CheckOut, ClientID, RoomID, EmployeeUN, ReservationID)"
    		+ "  VALUES ('"+checkIn+"','"+checkOut+"','"+reservation.getClient()+"','"+reservation.getRoom()+"','"+reservation.getEmployee()+"','"+reservation.getReservationID()+"');");
	pre.executeUpdate();
	pre.close();
	con.close();
}


/*get*/
/*booom*/
public Employee  getEmployee(String userName, String password) throws Exception{
	Connection con = getConnection();
	Employee em = null;
	
	PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE userName = '"+userName+"' AND Password = '"+password+"'  ");
	 ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			
			em = new Employee(rs.getString("Name"),rs.getString("IDNumber"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Adrress"), rs.getInt("PhoneNumber"), rs.getBoolean("Manager"));
		}
		rs.close();
	con.close();
	
	return em;
}








public static ObservableList<Reservation> getComingReservations() throws Exception {
	ObservableList<Reservation> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn >= CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		
		data.add(new Reservation(rs.getDate("CheckIn"),rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getString("ReservationID"), rs.getInt("GuestsNumber")));
	}
	pre.close();
	con.close();
	return data;   
	
}


public  ObservableList<Reservation> getTodayCheckIn() throws Exception {
	ObservableList<Reservation> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn = CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {

		
		//CheckIn, Che
		data.add(new Reservation(rs.getDate("CheckIn"),rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getString("ReservationID"),rs.getInt("GuestsNumber")));
	}
	
	rs.close();
	con.close();
	return data;   
}

public static ObservableList<Reservation> getTodayCheckOut() throws Exception {
	ObservableList<Reservation> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckOut = CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		
		data.add(new Reservation(rs.getDate("CheckIn"),rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getString("ReservationID"),rs.getInt("GuestsNumber")));
	}
	return data;   
}

public  ArrayList<Reservation> searchForDates(Date chIn,Date chOut) throws Exception {
	String CheckIn = convertDate(chIn);
	String CheckOut = convertDate(chOut);
	System.out.println(CheckIn);
	ArrayList<Reservation> data =  new ArrayList<Reservation>();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn >= '"+CheckIn+"' AND CheckOut <= '"+CheckOut+"'");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		data.add(new Reservation(rs.getDate("CheckIn"),rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getString("ReservationID"),rs.getInt("GuestsNumber")));
	}
	return data;   
}



public Room getTheRoom(Reservation res) throws Exception {
	Connection con = getConnection();
	Room room = null;
	
	PreparedStatement pre = con.prepareStatement("SELECT * FROM Room WHERE RoomID = '"+res.getRoom()+"'");
	 ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			
			room = new Room(rs.getString("RoomID"),rs.getInt("Price"),rs.getInt("RoomSize"),rs.getInt("NumOfBeds"),rs.getString("Location"),rs.getBoolean("View"),rs.getBoolean("Smoking"),rs.getBoolean("Adjoint"),rs.getString("AdjointRoomID"));
		}
	rs.close();
	con.close();
	
	return room;
}




public  ObservableList<Room> getRooms() throws Exception {
	ObservableList<Room> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Room");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		
		//String roomID, int price, int roomSize,int numOfBeds ,String Location,boolean view ,boolean smoking,boolean adjoint,String adjoinedRoomID
		//RoomID,Price,RoomSize,NumOfBeds,Location,View,Smoking,Adjoint,AdjointRoomID
		data.add(new Room(rs.getString("RoomID"),rs.getInt("Price"),rs.getInt("RoomSize"),rs.getInt("NumOfBeds"),rs.getString("Location"),rs.getBoolean("View"),rs.getBoolean("Smoking"),rs.getBoolean("Adjoint"),rs.getString("AdjointRoomID")));
	}
	return data;   
}


//String campusLoc boolean smoking, boolean petsAllowd,boolean adjoined,boolean doubleBed
public ArrayList<Room> getRoomChoices(String campusLoc, boolean view,boolean smoking,boolean adjoined,boolean doubleBed) throws Exception{
	ArrayList<Room> data = new ArrayList<Room>();
	Connection con = getConnection();
	//	RoomID	Price	RoomSize	NumOfBeds	Location	View	Smoking	Adjoint	AdjointRoomID
	PreparedStatement pre = con.prepareStatement("SELECT * FROM Room WHERE Location='"+campusLoc+"' AND View='"+getBoolean(view)+"'   AND Smoking='"+getBoolean(smoking)+"' AND Adjoint='"+getBoolean(adjoined)+"' " );
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		
		data.add(new Room(rs.getString("RoomID"),rs.getInt("Price"),rs.getInt("RoomSize"),rs.getInt("NumOfBeds"),rs.getString("Location"),rs.getBoolean("View"),rs.getBoolean("Smoking"),rs.getBoolean("Adjoint"),rs.getString("AdjointRoomID")));
	}
	return data;   	
}




/*boyya*/
public void deleteRoom(Room room) throws Exception{
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("DELETE FROM Room WHERE RoomID = '"+room.getRoomID()+"'");
	pre.executeUpdate();
}
public void deleteEmployee(Employee employee) throws Exception{
	Connection con = getConnection();
	PreparedStatement pre = con.prepareStatement("DELETE FROM Employee WHERE UserName = '"+employee.getUserName()+"';");
	pre.executeUpdate();
}
public static void deleteReservation(Reservation reservation) throws Exception{
	Connection con = getConnection();

	PreparedStatement pre = con.prepareStatement("DELETE FROM Reservation WHERE ReservationID = '"+reservation.getReservationID()+"';");
	pre.executeUpdate();
	con.close();
}


/*'UPDATE tutorials_tbl
      SET tutorial_title="Learning JAVA"
      ';*/
public  void editRoom(Room room) throws Exception{
	Connection con = getConnection();
	PreparedStatement pre = con.prepareStatement("UPDATE Room SET Price='" + room.getPrice() + "', RoomSize='" + room.getRoomSize() + "',NumOfBeds='" + room.getNumOfBed() + "', Location='" + room.getLocation() + "'"
			+ ",View='" + getBoolean(room.getView()) + "', Smoking='" + getBoolean(room.getSmoking()) + "',Adjoint'" + getBoolean(room.getAdjoint()) + "',AdjointRoomID='" + room.getAdjoindsRoomID() + "' "
			+ "WHERE RoomID='"+room.getRoomID()+ "';");
	pre.executeUpdate();
	pre.close();
	con.close();
}


public  void editReservation(Reservation reservation) throws Exception{
	Connection con = getConnection();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String checkIn = df.format(reservation.getCheckInDate());
	String checkOut = df.format(reservation.getCheckOutDate());
	PreparedStatement pre = con.prepareStatement("UPDATE Reservation SET CheckIn='" +checkIn + "', CheckOut='" + checkOut + "',ClientID='" + reservation.getClient() + "', RoomID='" + reservation.getRoom() + "'"
			+ ",EmployeeUN='" + reservation.getEmployee() + "'  WHERE ReservationID='" + reservation.getReservationID() + "';");
			
	pre.executeUpdate();
	pre.close();
	con.close();
}




public  void editEmployee(Employee employee) throws Exception{
	Connection con = getConnection();
	PreparedStatement pre = con.prepareStatement("UPDATE Employee SET Name='" + employee.getName() + "', IDNumber='" + employee.getIDNumber() + "',UserName='" + employee.getUserName() + "', Password='" + employee.getPassword() + "'"
			+ ",Adrress='" + employee.getAddress() + "', PhoneNumber='" + employee.getPhoneNumber() + "',Manager'" + getBoolean(employee.isManager()) + "' "
			+ "WHERE IDNumber='" +employee.getIDNumber() + "';");
	pre.executeUpdate();
	pre.close();
	con.close();
}



private String convertDate(Date date) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	return df.format(date);
}

private int getBoolean(boolean bol) {
	   int i = bol ? 1 : 0;
	   return i;
	}

 public static Connection getConnection() throws Exception{
  try{
      //sql7.freesqldatabase.com
	  //sql7235306
	  //ed5j4AGc2a
	  Connection  con = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com/sql7235306","sql7235306","ed5j4AGc2a");
	System.out.println("Connected");
   return con;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }
 
}