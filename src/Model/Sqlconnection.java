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
public class Sqlconnection{
	public static void main(String[] args) throws Exception {
		//int floor, String roomNumber, int price, int roomSize,String Location
		
	
		
		;
		
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
	 getComingReservations() ;
	// addReservation(re);
	 //addReservation(re2);
	}



/*booom*/
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

public static void addReservation(Reservation reservation) throws Exception {
	//Date checkIn,Date checkOut, Client client,Room room,Employee emp
	//CheckIn	CheckOut	ClientID	RoomID	EmployeeUN	ReservationID
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String a = df.format(reservation.getCheckInDate());
	System.out.println(a);
	Connection con = getConnection();
	// PreparedStatement pre = con.prepareStatement("	INSERT INTO `Reservation` (`CheckIn`, `CheckOut`, `ClientID`, `RoomID`, `EmployeeUN`, `ReservationID`) VALUES ('"+a+"','"+a+"','"+reservation.getClient()+"','"+reservation.getRoom()+"', 'ff', 'rer')");
    PreparedStatement pre = con.prepareStatement("INSERT INTO Reservation (CheckIn, CheckOut, ClientID, RoomID, EmployeeUN, ReservationID)"
    		+ "  VALUES ('"+a+"','"+a+"','"+reservation.getClient()+"','"+reservation.getRoom()+"','"+reservation.getEmployee()+"','"+reservation.getReservationID()+"');");
	pre.executeUpdate();
}


/*get*/
/*booom*/
//SELECT * FROM Persons WHERE P_Id = 3
public static void getComingReservations() throws Exception {
	
	Connection con = getConnection();
    PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn >= CURDATE()");
    ResultSet rs = pre.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getString("ReservationID"));
	}
    
    
    
}




/*fixing*/
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
   
	  //sql7.freesqldatabase.com
	  //sql7235306
	  //ed5j4AGc2a
	   Connection conn = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com/sql7235306","sql7235306","ed5j4AGc2a");
	  
	   
	  
   System.out.println("Connected");
   return conn;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }
 
}