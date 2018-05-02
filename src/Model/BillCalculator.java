package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class BillCalculator {
	/*this class calculates the final price*/
	private Room room;
	private Sqlconnection sq;
	private int finalPrice;
	private int roomPrice;
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);
		//Date checkIn,Date checkOut, String clientID,String roomID,String EmployeeUN, String ReservationID, int guestNum
		Calendar calendar = new GregorianCalendar(2018, 4, 10);
		 Date ENDDATE = calendar.getTime();
		 
		System.out.println(getDateDiff( ENDDATE , today));
		 
		if(-15 < getDateDiff( ENDDATE , today) && getDateDiff( ENDDATE , today) < 0)
		System.out.println("dsa");
		
	}
	
	
	private void cancelBeforeCheckIn() {
		
	}
	
    private void cancelAfterCheckIn() {
		
	 }
	public BillCalculator(Reservation res) {
		/*get room and reservation*/
		this.sq = new Sqlconnection();
		
		try {
			this.room = sq.getTheRoom(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.roomPrice = room.getPrice();
		Date startDate = res.getCheckInDate();
		Date endDate = res.getCheckOutDate();
		
		Date today = new Date();
		if( 0 > getDateDiff( endDate,today) )
		System.out.println("dd");
		
		/*calculate*/
		int daysDifference =  getDateDiff(startDate, endDate);
		calculateFinalPrice(daysDifference,roomPrice) ;
	}
	
	private void takeToCalculation(Reservation res) {
		Date today = new Date();
		
	}
	
    
    private void calculateFinalPrice(int daysDifference,int roomPrice) {
    	this.finalPrice = daysDifference * roomPrice;
    }
    
	private static int getDateDiff(Date date1, Date date2) {
		TimeUnit timeUnit = TimeUnit.DAYS;
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return (int) timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	//divide by 2 extra dates if cancel early
	public int getFinalPrice() {
    	return this.finalPrice;
    }
    
}
