package Model;


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
	private ArrayList<Room> NOTavailable;
	private ObservableList<Room> available; 
	
	public SearchFactory(String campusLoc,Date s, Date sa,boolean view ,boolean smoking,boolean adjoined,boolean doubleBed) throws Exception {
		
		 this.sq = new Sqlconnection();
		//take the rooms that fit your description
		 this.roomList = sq.getRoomChoices(campusLoc, view ,smoking,  adjoined, doubleBed);
		//finding reservations that conflict with your dates  
		 this.ColapingRess = sq.searchForDates(s,s);
		 
		 this.NOTavailable = new ArrayList<Room>();
		
		setNOTavailable();
	
		}
	
	private void setNOTavailable() {
		for(Room r : roomList) {
			for(Reservation res : ColapingRess) {
				if(res.getRoom().equals(r.getRoomID()))
					NOTavailable.add(r);
			}
				
		}
	}
	//  ObservableList<Room> data ;
	public ObservableList<Room> getAvailableRooms(){
		available = FXCollections.observableArrayList();
		for(Room r : roomList) {
			if(!NOTavailable.contains(r)) {
				available.add(r);
			}
		}
	return available;
	}
	
	
	
	
}
