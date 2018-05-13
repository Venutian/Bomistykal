package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeHandler {
   private Database sq;
    public EmployeeHandler() {
    	this.sq = new Database();
    }
    
	
	
	public ObservableList<Employee> getEmployyesList() throws Exception {
        ObservableList<Employee> data = FXCollections.observableArrayList();
        Connection con = sq.getConnection();
        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
           data.add(new Employee(rs.getString("Name"), rs.getString("IDNumber"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Adrress"), rs.getString("PhoneNumber"), rs.getBoolean("Manager")));
        }
        return data;
    }

   
	public boolean checkIfEmployeeExists(String idNumber,String userName) throws Exception {
		Connection con = sq.getConnection();

        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE IDNumber = '" + idNumber + "' AND userName = '" + userName + "' ");
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
         return false;
        }
        rs.close();
        con.close();

		return true;
	}
	
	
	
}
