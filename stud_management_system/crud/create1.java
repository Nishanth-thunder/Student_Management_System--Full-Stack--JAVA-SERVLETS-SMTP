package crud;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.Statement;

public class create1 {
	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
			Statement st=con.createStatement();
		 st.executeUpdate("CREATE TABLE student_details (code VARCHAR(200),Name VARCHAR(300),"
		 		+ "Age INT,mobilenum VARCHAR(20),email VARCHAR(200),percentage_12 INT)");
		 System.out.println("Sucessfully created!");
		 
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}

}