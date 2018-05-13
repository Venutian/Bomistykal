package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Authentication {
	private Database sq;
	
	
	public Authentication() {
    	this.sq = new Database();
    }
	
	
public Employee authenticationControll(String userName, String password) throws Exception {
		
		/*search in database exist = true if both match*/
		Employee employee =getEmployee(userName, password);
		return employee;
	}
private Employee getEmployee(String userName, String password) throws Exception {
    Connection con = sq.getConnection();
    Employee em = null;

    PreparedStatement pre = con.prepareStatement("SELECT * FROM Employee WHERE userName = '" + userName + "' AND Password = '" + password + "'  ");
    ResultSet rs = pre.executeQuery();
    while (rs.next()) {

        em = new Employee(rs.getString("Name"), rs.getString("IDNumber"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Adrress"), rs.getString("PhoneNumber"), rs.getBoolean("Manager"));
    }
    rs.close();
    con.close();

    return em;
}
}
