package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SearchFactory {
/*this class will compare all the rooms with the search choices make a room list out of it
 * then it would compare this room list with upcoming reservations to see if there are available rooms
 * it would create and return a list of the available rooms.*/

	public static void main(String[] args) throws Exception {
		Calendar myCalendar = new GregorianCalendar(2018, 03, 28);
		Date s = myCalendar.getTime();
		SearchFactory sf = new SearchFactory("Vaxjo",s,s,false,true,false,false);
	}
	
	
	public SearchFactory(String campusLoc,Date s, Date sa,boolean view ,boolean smoking,boolean adjoined,boolean doubleBed) throws Exception {
		//,Date checkIn, Date checkOut
		Sqlconnection sq = new Sqlconnection();
		
		
		//take the rooms that fit your description
		ArrayList<Room> roomList = sq.getRoomChoices(campusLoc, view ,smoking,  adjoined, doubleBed);
		
		
		
		
		
		//finding rooms that are checked out before u check in 
		ArrayList<Reservation> res = sq.searchForDates(s);
		System.out.println(res.size());
		
		for(Reservation r : res)
		System.out.println(r.getReservationID());
		
		
		//take only the ones that fit and checked out bfr u 
		ArrayList<Room> NOTavailable = new ArrayList<Room>();
		
		for(Room r : roomList) {
			for(Reservation a : res) {
				if(a.getRoom().equals(r.getRoomID()))
					NOTavailable.add(r);
			}
			
		}
		
		ArrayList<Room> available = new ArrayList<Room>();
		
		for(Room rm : NOTavailable) {
			if(!roomList.contains(rm))
				available.add(rm);
		}
		
		
		//boyya
		
	}

}
