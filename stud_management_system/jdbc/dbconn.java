package jdbc;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbconn {

	public static void main(String[] args) throws SQLException {
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=Nish@123"); 
    	 PreparedStatement pss = connection.prepareStatement("CREATE DATABASE students;");
    	 int result = pss.executeUpdate();
         System.out.println("Connected to MySQL");
         System.out.println(result);            
         connection.close();

	}

}
