package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Sqlconnection{

public static void main(String[] args) throws Exception {
	createTable();
}



public static void createTable() throws Exception {
	Connection con = getConnection();

	//String name, String IDNumber,String userName,String password,String address,int phoneNumber,boolean manager
/*	PreparedStatement pre = con.prepareStatement("CREATE TABLE IF NOT EXISTS employee(firstName varchar(255), lastName varchar(255), "
			+ "IDNumber varchar(255), password varchar(255),  address varchar(255), phoneNumber int, manager BOOLEAN)");*/
	PreparedStatement pre = con.prepareStatement("INSERT INTO room (roomRow,IDRoom)  VALUES ('2','APOEL');");
	pre.executeUpdate();
}






 public static Connection getConnection() throws Exception{
  try{
 //  String driver = "com.mysql.jdbc.Driver";
	  String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/database";
	   String username = "andreas";
	   String password = "apoel1234";
	   Class.forName(driver);
	   
	   Connection conn = DriverManager.getConnection(url,username,password);
	  
   System.out.println("Connected");
   return conn;
  } catch(Exception e){System.out.println(e);}
  
  
  return null;
 }
 
}