package Model;

import java.util.Date;

public class InputChecker {
	public boolean datesCorrection(Date start,Date end) {
		
		Date today = new Date();
		System.out.println(today);
		//gives error if they book for today
		if( today.after(start)  )
			return false;
		else if(today.after(end))
			return false;
		else if(!end.after(start))
			return false;
		
		return true;
	}
}
