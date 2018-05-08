package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeList {
   private Sqlconnection sq;
    public EmployeeList() {
    	this.sq = new Sqlconnection();
    }
    
	public Employee authenticationControll(String userName, String password) throws Exception {
		
		/*search in database exist = true if both match*/
		Employee employee =getEmployee(userName, password);
		return employee;
	}
	
	public ObservableList<Employee> getEmployyesList() throws Exception {
        ObservableList<Employee> data = FXCollections.observableArrayList();
        Connection con = sq.getConnection();
        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
           data.add(new Employee(rs.getString("Name"), rs.getString("IDNumber"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Adrress"), rs.getInt("PhoneNumber"), rs.getBoolean("Manager")));
        }
        return data;
    }

    private Employee getEmployee(String userName, String password) throws Exception {
        Connection con = sq.getConnection();
        Employee em = null;

        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE userName = '" + userName + "' AND Password = '" + password + "'  ");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {

            em = new Employee(rs.getString("Name"), rs.getString("IDNumber"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Adrress"), rs.getInt("PhoneNumber"), rs.getBoolean("Manager"));
        }
        rs.close();
        con.close();

        return em;
    }
	public boolean checkIfEmployeeExists(String idNumber) throws Exception {
		Connection con = sq.getConnection();

        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE IDNumber = '" + idNumber + "'  ");
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
         return false;
        }
        rs.close();
        con.close();

		return true;
	}
	public boolean checkIfUserNameExists(String userName) throws Exception {
		Connection con = sq.getConnection();

        PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE userName = '" + userName + "'  ");
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
         return false;
        }
        rs.close();
        con.close();

		return true;
	}
	
	
}
