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
	
	
	
	
	public boolean checkIfIsInt(String number) {
		try {       
			int x = Integer.parseInt(number); // Parse string into number
		    return true;
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		    return false;
		}
		
		
	}
	public boolean checkIfIsString(String str) {
		if(str.matches("^\\d*$"))
		return false;
		else
		return true;
	}
	
	public boolean checkStrSize(String str,int size) {
		if(str.length() > size)
			return false;
			else
	     return true;
	}
	
	public boolean checkIntSize(String chek,int size) {
		int checkFor = Integer.parseInt(chek);
		if(size > checkFor && checkFor > 0)
			return false;
		else 
			return true;
					
	}
	
	
	
}
