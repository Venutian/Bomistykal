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
	
	public boolean checkForClient(String name,String IDNumber, String creditCardNumber,Date creditCardExpDate, String phoneNumber,String address) {
		//make it to send the correct error .. to general
		Date today = new Date();
		if(checkIfIsString(name)&&checkIfIsString(IDNumber)&&checkIfIsInt(creditCardNumber)&&creditCardExpDate.after(today)&&checkIfIsInt(phoneNumber)&&checkIfIsString(address))
			
		
		if(checkStrSize(name,30)&&checkStrSize(IDNumber,30)&&checkStrSize(address,30)&&checkIntSize(Integer.parseInt(creditCardNumber),17)&&checkIntSize(Integer.parseInt(phoneNumber),12))
			;
		;
		return false;
	}
	
	
	
	private boolean checkIfIsInt(String number) {
		try {       
			int x = Integer.parseInt(number); // Parse string into number
		    return true;
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		    return false;
		}
		
		
	}
	private boolean checkIfIsString(String str) {
		if(str.matches("^\\d*$"))
		return false;
		else
		return true;
	}
	
	private boolean checkStrSize(String str,int size) {
		if(str.length() > size)
			return false;
			else
	     return true;
	}
	
	private boolean checkIntSize(int chek,int size) {
		if(size > chek && chek > 0)
			return false;
		else 
			return true;
					
	}
	
	
	
}
