package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomList {
private Sqlconnection sq;

	public RoomList() {
		this.sq = new Sqlconnection();
	}

	  public ObservableList<Room> getRooms() throws Exception {
	        ObservableList<Room> data = FXCollections.observableArrayList();
	        Connection con = sq.getConnection();
	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Room");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	            data.add(new Room(rs.getString("RoomID"), rs.getInt("Price"), rs.getInt("RoomSize"), rs.getInt("NumOfBeds"), rs.getString("Location"), rs.getBoolean("RoomView"), rs.getBoolean("Smoking"), rs.getBoolean("Adjoint"), rs.getString("AdjointRoomID")));
	        }
	        return data;
	    }
	
	  public Room getTheRoom(Reservation res) throws Exception {
	        Connection con = sq.getConnection();
	        Room room = null;

	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Room WHERE RoomID = '" + res.getRoom() + "'");
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {

	            room = new Room(rs.getString("RoomID"), rs.getInt("Price"), rs.getInt("RoomSize"), rs.getInt("NumOfBeds"), rs.getString("Location"), rs.getBoolean("RoomView"), rs.getBoolean("Smoking"), rs.getBoolean("Adjoint"), rs.getString("AdjointRoomID"));
	        }
	        rs.close();
	        con.close();

	        return room;
	    }
	
	  public boolean checkIfRoomExists(String idNumber) throws Exception {
			Connection con = sq.getConnection();

	        PreparedStatement pre = con.prepareStatement("SELECT * FROM Room WHERE RoomID = '" + idNumber + "'  ");
	        ResultSet rs = pre.executeQuery();
	        if (rs.next()) {
	         return false;
	        }
	        rs.close();
	        con.close();

			return true;
		}
	
	  public Room adjoinedFind(Room room,ObservableList<Room> data) {
	    	Room returnRoom = null;
	    	for(Room adRoom : data) {
	    	if(room.getAdjoindsRoomID().equals(adRoom.getRoomID())) {
	    			returnRoom = adRoom ;
	    		}
	    	}	
	    	return returnRoom;
	    }
	
}
