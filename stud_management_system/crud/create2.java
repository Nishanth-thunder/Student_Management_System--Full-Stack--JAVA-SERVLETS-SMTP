package crud;
import java.sql.Connection;
import java.sql.DriverManager;

public class create2 {
	public static void main(String[] args) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
		 String sql_query="CREATE TABLE course_details (coursename_1 VARCHAR(300),"
		 		+ "coursename_2 VARCHAR(100),coursename_3 VARCHAR(100),code VARCHAR(200));";
		 con.prepareStatement(sql_query).execute();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}
}