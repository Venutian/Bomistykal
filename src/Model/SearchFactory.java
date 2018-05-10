package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SearchFactory {
/*this class will compare all the rooms with the search choices make a room list out of it
 * then it would compare this room list with upcoming reservations to see if there are available rooms
 * it would create and return a list of the available rooms.*/
	private Sqlconnection sq;
	private ArrayList<Room> roomList;
	private ArrayList<Reservation> ColapingRess;
	private ReservationList rs ;
	private ArrayList<Room> NOTavailable;
	private ObservableList<Room> available;
	private boolean datesValid;

	public SearchFactory (String campusLoc, Date startDate, Date endDate, boolean view, boolean smoking, boolean adjoined, int numOfBeds, int RoomSize) throws Exception {
		this.rs = new ReservationList();
		 this.sq = new Sqlconnection();
		 this.available = FXCollections.observableArrayList();
		 checkDates(startDate,endDate);
		 if(datesValid) {
		this.roomList = getRoomChoices(campusLoc, view, smoking, adjoined, numOfBeds, RoomSize);
		//finding reservations that conflict with your dates  
		this.ColapingRess = rs.searchForDates(startDate,endDate);
		 
		this.NOTavailable = new ArrayList<Room>();
		
		setNOTavailable();
		setAvailableRooms();
		 }
		}
	public boolean datesAreCorrect() {
		return datesValid;
	}
	private void checkDates(Date startDate,Date endDate) {
		Date today = new Date();
		
		if(sq.getDateDiff(startDate, today) > 0)
			this.datesValid = false;
		else if(sq.getDateDiff(startDate, endDate) <= 0)
			this.datesValid = false;
		else if(sq.getDateDiff(endDate, today) > 0)
			this.datesValid = false;
		else
			this.datesValid = true;
	}
	
	public String offerRoomToOtherCampus(String campusLocation) {
		if(campusLocation.equals("Kalmar"))
			return "Vaxjo";
		else
			return "Kalmar";
	}
	private void setNOTavailable() {
		for(Room r : roomList) {
			for(Reservation res : ColapingRess) {
				if(res.getRoom().equals(r.getRoomID()))
					NOTavailable.add(r);
			}
				
		}
	}
	private void setAvailableRooms(){
		
		for(Room r : roomList) {
			if(!NOTavailable.contains(r)) {
				available.add(r);
			}
		}
	}
	
	public ObservableList<Room> getAvailableRooms(){
		return this.available;
	}

	private ArrayList <Room> getRoomChoices (String campusLoc, boolean view, boolean smoking, boolean adjoined, int numOfBeds, int RoomSize) throws Exception {

		ArrayList<Room> data = new ArrayList<Room>();
	        Connection con = sq.getConnection();
	        PreparedStatement pre;
	   if(adjoined)
		   pre = con.prepareStatement("SELECT * FROM Room WHERE Location='" + campusLoc + "' AND RoomView='" + sq.getBoolean(view) + "'   AND Smoking='" + sq.getBoolean(smoking) + "' AND Adjoint='" + sq.getBoolean(adjoined) + "' AND NumOfBeds='" + numOfBeds + "' AND RoomSize='" + RoomSize + "'");
	   else
		  pre = con.prepareStatement("SELECT * FROM Room WHERE Location='" + campusLoc + "' AND RoomView='" + sq.getBoolean(view) + "'   AND Smoking='" + sq.getBoolean(smoking) + "' AND NumOfBeds='" + numOfBeds + "'");
	        
	   ResultSet rs = pre.executeQuery();
	        while (rs.next()) {

	            data.add(new Room(rs.getString("RoomID"), rs.getInt("Price"), rs.getInt("RoomSize"), rs.getInt("NumOfBeds"), rs.getString("Location"), rs.getBoolean("RoomView"), rs.getBoolean("Smoking"), rs.getBoolean("Adjoint"), rs.getString("AdjointRoomID")));
	        }
	        return data;
	    }

	
	
}
