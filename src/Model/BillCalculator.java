package Model;

import java.util.Date;


public class BillCalculator {
	/*this class calculates the final price*/
	private Room room;
	private int finalPrice;
	private int roomPrice;
	//this value indicates how many days before someone can cancel before getting fined. 
	private int daysBeforeCancel = -5;
	private Sqlconnection sq;
	private RoomList rm;
	
	
	public BillCalculator(Reservation res) {
		/*get room and reservation*/
		this.sq = new Sqlconnection();
		this.rm = new RoomList();
		try {
			this.room = rm.getTheRoom(res);
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
		
		
		
		if( 0 == sq.getDateDiff(today, endDate)) {
			calculateFinalPrice(sq.getDateDiff(startDate, endDate),roomPrice) ;
		}
		//if today is bigger than startdate that means they checked in
		//in this case they would pay the entire fee anyway because is to late
		else if(0 < sq.getDateDiff(startDate, today)) {
			calculateFinalPrice(sq.getDateDiff(startDate, endDate),roomPrice);
		}
		//if today is smaller than startdate that means they did not check in yet
		//if they cancel in less than 5 days before
		//they would pay half of the price because is to late.
		else if(daysBeforeCancel <= sq.getDateDiff(startDate, today) ) {
		calculateFinalPrice(sq.getDateDiff(startDate, endDate),roomPrice/2) ;
		}
		//if they cancel before 5 days then there are no charges
		else if(daysBeforeCancel > sq.getDateDiff(startDate, today) ) {
			this.finalPrice = 0;
		}
			
		
		
	}
	
    //calculate price
    private void calculateFinalPrice(int daysDifference,int roomPrice) {
    	this.finalPrice = daysDifference * roomPrice;
    }
    
    

	//get price
	public int getFinalPrice() {
		System.out.println(finalPrice);
    	return this.finalPrice;
     }
    
}
