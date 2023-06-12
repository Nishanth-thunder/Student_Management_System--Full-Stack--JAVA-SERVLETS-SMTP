package crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class create3 {
public static void main(String[] args) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
		 String sql_query="CREATE TABLE parent_details (Father_name VARCHAR(300),Mother_name VARCHAR(300),"
		 		+ "Dad_job VARCHAR(100),Mom_job VARCHAR(100),Income VARCHAR(50),code VARCHAR(200))";
		 con.prepareStatement(sql_query).execute();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}

}
