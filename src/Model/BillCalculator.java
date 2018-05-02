package Model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BillCalculator {
	/*this class calculates the final price*/
	private Room room;
	private Sqlconnection sq;
	private int finalPrice;
	private int roomPrice;
	//this value indicates how many days before someone can cancel before getting fined. 
	private int daysBeforeCancel = -5;
	
	
	public BillCalculator(Reservation res) {
		/*get room and reservation*/
		this.sq = new Sqlconnection();
		try {
			this.room = sq.getTheRoom(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.roomPrice = room.getPrice();
		FeesCalculation(res);
		
	}
	
	private void FeesCalculation(Reservation res) {
		Date today = new Date();
		Date startDate = res.getCheckInDate();
		Date endDate = res.getCheckOutDate();
		
		
		
		if( 0 == getDateDiff(today, endDate)) {
			calculateFinalPrice(getDateDiff(startDate, endDate),roomPrice) ;
		}
		//if today is bigger than startdate that means they checked in
		//in this case they would pay the entire fee anyway because is to late
		else if(0 < getDateDiff(startDate, today)) {
			calculateFinalPrice(getDateDiff(startDate, endDate),roomPrice);
		}
		//if today is smaller than startdate that means they did not check in yet
		//if they cancel in less than 5 days before
		//they would pay half of the price because is to late.
		else if(daysBeforeCancel <= getDateDiff(startDate, today) ) {
		calculateFinalPrice(getDateDiff(startDate, endDate),roomPrice/2) ;
		}
		//if they cancel before 5 days then there are no charges
		else if(daysBeforeCancel > getDateDiff(startDate, today) ) {
			this.finalPrice = 0;
		}
			
		
		
	}
	
    //calculate price
    private void calculateFinalPrice(int daysDifference,int roomPrice) {
    	this.finalPrice = daysDifference * roomPrice;
    }
    
    //get date difference
	private int getDateDiff(Date date1, Date date2) {
		TimeUnit timeUnit = TimeUnit.DAYS;
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return (int) timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}

	//get price
	public int getFinalPrice() {
		System.out.println(finalPrice);
    	return this.finalPrice;
     }
    
}
