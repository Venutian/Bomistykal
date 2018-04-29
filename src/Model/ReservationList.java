package Model;

import java.util.ArrayList;

public class ReservationList {

	private ArrayList<Reservation> res ;
	
	public ReservationList() {
		setRes(new ArrayList<Reservation>());
	}

	public ArrayList<Reservation> getRes() {
		return res;
	}

	public void setRes(ArrayList<Reservation> res) {
		this.res = res;
	}

	
	public void addRervation(Reservation rervation) {
		this.res.add(rervation);
	}
	
	public void removeRervation(Reservation rervation) {
	for(int i = 0; i < res.size(); i ++) {
			if(res.get(i).equals(rervation))
				res.remove(i);
		}
	}
	
}
