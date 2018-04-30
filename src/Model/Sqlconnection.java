package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Sqlconnection{
	
	
	public static void main(String[] args) throws Exception {
		//int floor, String roomNumber, int price, int roomSize,String Location
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Calendar myCalendar = new GregorianCalendar(2021, 02, 11);
		Date myDate = myCalendar.getTime();
		
		 
		 String testDateString = df.format(myDate);
		String date2 = "2018-09-30";
		 
		 Date ff =  df.parse(testDateString);
		 Date ff2 =  df.parse(date2);
		 
	   System.out.println(testDateString+" "+date2);
		
	 Reservation re = new Reservation(ff,ff,"D","d","fff");
	 Reservation re2 = new Reservation(ff2,ff2,"D","d","fff");
	
	 //Employee eo = getEmployee("waeaff","123456");
	 //System.out.println(eo.isManager());
	 //addReservation(re2);
	// addReservation(re);
	// getComingReservations() ;
	// deleteReservation(re2);
	// addReservation(re);
	 //addReservation(re2);
	}

	

/*booom*/
public static void addRoom(Room room) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Room (Floor,RoomID,Price,Location,Description) "
    		+ " VALUES ('"+room.getFloor()+"','"+room.getRoomNumber()+"','"+room.getPrice()+"','"+room.getLocation()+"','"+room.getDescription()+"');");
	pre.executeUpdate();
	pre.close();
	con.close();
}

public void addEmployee(Employee eployee) throws Exception {
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("INSERT INTO Employee (Name,IDNumber,UserName,Password,Adrress,PhoneNumber,Manager) "
    		+ " VALUES ('"+eployee.getName()+"','"+eployee.getIDNumber()+"','"+eployee.getUserName()+"','"+eployee.getPassword()+"','"+eployee.getAddress()+"','"+eployee.getPhoneNumber()+"','"+eployee.isManager()+"');");
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
	System.out.println(userName+password);
	PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE userName = '"+userName+"' AND Password = '"+password+"'  ");
	 ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			System.out.println("sdasdsadsa");
			em = new Employee(rs.getString("Name"),rs.getString("IDNumber"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Adrress"), rs.getInt("PhoneNumber"), rs.getBoolean("Manager"));
		}
		rs.close();
	con.close();
	if(em == null)
		System.out.println("dksajkdsa");
	return em;
}








public static ObservableList<Reservation> getComingReservations() throws Exception {
	ObservableList<Reservation> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn >= CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getString("ReservationID"));
		data.add((Reservation) rs);
	}
	pre.close();
	con.close();
	return data;   
	
}

public static ObservableList<Reservation> getTodayCheckIn() throws Exception {
	ObservableList<Reservation> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn = CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getString("ReservationID"));
		data.add((Reservation) rs);
	}
	return data;   
}

public static ObservableList<Reservation> getTodayCheckOut() throws Exception {
	ObservableList<Reservation> data =  FXCollections.observableArrayList();
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckOut = CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getString("ReservationID"));
		data.add((Reservation) rs);
	}
	return data;   
}









/*boyya*/
public void deleteRoom(Room room) throws Exception{
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("DELETE FROM Room WHERE RoomID = '"+room.getRoomNumber()+"'");
	pre.executeUpdate();
}
public void deleteEmployee(Employee employee) throws Exception{
	Connection con = getConnection();
	PreparedStatement pre = con.prepareStatement("DELETE FROM Employee WHERE UserName = '"+employee.getUserName()+"';");
	pre.executeUpdate();
}
public static void deleteReservation(Reservation reservation) throws Exception{
	Connection con = getConnection();
	System.out.println(reservation.getReservationID());
	PreparedStatement pre = con.prepareStatement("DELETE FROM Reservation WHERE ReservationID = '"+reservation.getReservationID()+"';");
	pre.executeUpdate();
	con.close();
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