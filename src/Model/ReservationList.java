package Model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationList {

	private ObservableList<Reservation> reservation ;
	private String clientID;
	private ObservableList<Reservation> list;
	
	public ReservationList(String clientID, ObservableList<Reservation> list) {
		this.clientID = clientID;
		this.list = list;
		this.reservation = FXCollections.observableArrayList();
		
				
		
		findReservation();
	}

	private void findReservation() {
		for(Reservation n : list)
			if(n.getClient().contains(clientID))
				reservation.add(n);
	}
	public ObservableList<Reservation> getReservation() {
		return this.reservation;
	}
	
}
