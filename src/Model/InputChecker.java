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
	//name.getText().toString(),idNumber.getText().toString(),Integer.parseInt(creditCardNo.getText().toString()),credit,Integer.parseInt(telNumber.getText().toString()),addres.getText().toString()
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
	
	public boolean checkSize(String str,int size) {
		if(str.length() > size)
			return false;
			else
	     return true;
		
	}
	
	
	
}
