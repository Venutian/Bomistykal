package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationList {

	private Sqlconnection sq;
	
	
	public ReservationList() {
		this.sq = new Sqlconnection();
	}

	public ObservableList<Reservation> getReservation(String clientID, ObservableList<Reservation> list) {
		ObservableList<Reservation> reservation = FXCollections.observableArrayList();
		for(Reservation n : list)
			if(n.getClient().contains(clientID))
				reservation.add(n);
		return reservation;
	}
	
	  public ObservableList<Reservation> getComingReservations() throws Exception {
	        ObservableList<Reservation> data = FXCollections.observableArrayList();
	        Connection con = sq.getConnection();
	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn >= CURDATE()");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {

	        	Reservation res = new Reservation(rs.getDate("CheckIn"), rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getInt("GuestsNumber"));
	            res.setReservationID(rs.getString("ReservationID"));
	        	data.add(res);       
	        	}
	        pre.close();
	        con.close();
	        return data;

	    }


	    public ObservableList<Reservation> getTodayCheckIn() throws Exception {
	        ObservableList<Reservation> data = FXCollections.observableArrayList();
	        Connection con = sq.getConnection();
	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn = CURDATE() AND checkedIn = 0");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	        	Reservation res = new Reservation(rs.getDate("CheckIn"), rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getInt("GuestsNumber"));
	            res.setReservationID(rs.getString("ReservationID"));
	        	data.add(res);
	        }//, rs.getString("ReservationID")

	        rs.close();
	        con.close();
	        return data;
	    }

	    public  ObservableList<Reservation> getTodayCheckOut() throws Exception {
	        ObservableList<Reservation> data = FXCollections.observableArrayList();
	        Connection con = sq.getConnection();
	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckOut = CURDATE() AND checkedOut = 0");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	        	Reservation res = new Reservation(rs.getDate("CheckIn"), rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getInt("GuestsNumber"));
	            res.setReservationID(rs.getString("ReservationID"));
	        	data.add(res);
	        }//, rs.getString("ReservationID")
	        return data;
	    }

	    protected ArrayList<Reservation> searchForDates(Date chIn, Date chOut) throws Exception {
	        String CheckIn = sq.convertDate(chIn);
	        String CheckOut = sq.convertDate(chOut);
	        System.out.println(CheckIn);
	        ArrayList<Reservation> data = new ArrayList<Reservation>();
	        Connection con = sq.getConnection();
	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Reservation WHERE CheckIn >= '" + CheckIn + "' AND CheckOut <= '" + CheckOut + "'");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	        	Reservation res = new Reservation(rs.getDate("CheckIn"), rs.getDate("CheckOut"), rs.getString("ClientID"), rs.getString("RoomID"), rs.getString("EmployeeUN"), rs.getInt("GuestsNumber"));
	            res.setReservationID(rs.getString("ReservationID"));
	        	data.add(res);
	        }
	        return data;
	    }

	
	    public Client getClient(String clientID) throws Exception {
	        Connection con = sq.getConnection();
	        Client client = null;

	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Client WHERE IDNumber = '" + clientID + "'  ");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	            //Name,IDNumber,CreditCardNumber,CreditCardExp,PhoneNumber,Address
	            client = new Client(rs.getString("Name"), rs.getString("IDNumber"), rs.getInt("CreditCardNumber"), rs.getDate("CreditCardExp"), rs.getInt("PhoneNumber"), rs.getString("Address"));
	        }
	        rs.close();
	        con.close();

	        return client;
	    }
	public boolean checkIfClientExists(String idNumber) throws Exception {
		Connection con = sq.getConnection();

        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE IDNumber = '" + idNumber + "'  ");
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
         return true;
        }
        rs.close();
        con.close();

		return false;
	}
	
}
