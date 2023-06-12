package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class show extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
		String tab=req.getParameter("table");
		String sql_query="";
		String pql_query="";
		String kql_query="";
		ResultSet m = null;
		ResultSet l=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
		if(tab.equals("All")) {
			sql_query="SELECT * FROM student_details;";
			pql_query="SELECT * FROM parent_details;";
			kql_query="SELECT * FROM course_details";
			PreparedStatement mst=con.prepareStatement(pql_query);
			PreparedStatement kst=con.prepareStatement(kql_query);
			m=mst.executeQuery();
			l=kst.executeQuery();
			
		}else {
			sql_query="SELECT * FROM "+tab+";";
		}
		 PreparedStatement pst=con.prepareStatement(sql_query);
		 ResultSet r=pst.executeQuery();
		 PrintWriter out=res.getWriter();
		    out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("</head>");
			out.println("<body style=\"background-color:lightcyan;\">");
			out.println("<br>");
			out.println("<h2 style=\"font-family:Lucida Handwriting;\">Raj Engineering college</h2>");
			
			out.println("<br>");
			out.println("<div style=\"text-align:center\">");
			
			if(tab.equals("student_details")) {
				out.println("<table border=\"1\" style=\"margin-left:auto;margin-right:auto\">");
				out.println("<tr>");
				out.println("<th>Student-Id</th>");
				out.println("<th>Name</th>");
				out.println("<th>Age</th>");
				out.println("<th>Mobile Number</th>");
				out.println("<th>Email</th>");
				out.println("<th>12th percentage</th>");
				out.println("</tr>");
			while(r.next()) {
				out.println("<tr>");
				out.print("<td>"+r.getString("code")+"</td>");
				out.print("<td>"+r.getString("Name")+"</td>");
				out.print("<td>"+r.getInt("Age")+"</td>");
				out.print("<td>"+r.getString("mobilenum")+"</td>");
				out.print("<td>"+r.getString("email")+"</td>");
				out.print("<td>"+r.getInt("percentage_12")+"% </td>");
				out.print("</tr>");
				
			}
			out.println("</table>");
			
			}else if(tab.equals("parent_details")) {
				out.println("<table border=\"1\" style=\"margin-left:auto;margin-right:auto\">");
				out.println("<tr>");
				out.println("<th>Father-Name</th>");
				out.println("<th>Mother-Name</th>");
				out.println("<th>Father-Job</th>");
				out.println("<th>Mother-Job</th>");
				out.println("<th>Annual income</th>");
				out.println("<th>Student-Id</th>");
				out.println("</tr>");
				while(r.next()) {
					out.println("<tr>");
					out.println("<td>"+r.getString("Father_name")+"</td>");
					out.println("<td>"+r.getString("Mother_name")+"</td>");
					out.println("<td>"+r.getString("Dad_job")+"</td>");
					out.println("<td>"+r.getString("Mom_job")+"</td>");
					out.println("<td>"+r.getString("Income")+"</td>");
					out.println("<td>"+r.getString("code")+"</td>");
					out.println("</tr>");
					
				}
				out.println("</table>");
			}else if(tab.equals("course_details")) {
				out.println("<table border=\"1\" style=\"margin-left:auto;margin-right:auto\">");
				out.println("<tr>");
				out.println("<th>Course preference 1</th>");
				out.println("<th>Course preference 2</th>");
				out.println("<th>Course preference 3</th>");
				out.println("<th>Student ID</th>");
				out.println("</tr>");
				
				while(r.next()) {
					out.println("<tr>");
					out.println("<td>"+r.getString("coursename_1")+"</td>");
					out.println("<td>"+r.getString("coursename_2")+"</td>");
					out.println("<td>"+r.getString("coursename_3")+"</td>");
					out.println("<td>"+r.getString("code")+"</td>");
					out.println("</tr>");
					
					
				}
				out.println("</table>");
			}else{
				out.println("<table border=\"1\" style=\"margin-left:auto;margin-right:auto\">");
				out.println("<tr>");
				out.println("<th>Student-Id</th>");
				out.println("<th>Name</th>");
				out.println("<th>Age</th>");
				out.println("<th>Mobile Number</th>");
				out.println("<th>Email</th>");
				out.println("<th>12th percentage</th>");
				out.println("<th>Father-Name</th>");
				out.println("<th>Mother-Name</th>");
				out.println("<th>Father-Job</th>");
				out.println("<th>Mother-Job</th>");
				out.println("<th>Annual income</th>");
				out.println("<th>Course preference 1</th>");
				out.println("<th>Course preference 2</th>");
				out.println("<th>Course preference 3</th>");
				while(r.next()&&m.next()&&l.next()) {
					out.println("<tr>");
					out.print("<td>"+r.getString("code")+"</td>");
					out.print("<td>"+r.getString("Name")+"</td>");
					out.print("<td>"+r.getInt("Age")+"</td>");
					out.print("<td>"+r.getString("mobilenum")+"</td>");
					out.print("<td>"+r.getString("email")+"</td>");
					out.print("<td>"+r.getInt("percentage_12")+"% </td>");
					out.println("<td>"+m.getString("Father_name")+"</td>");
					out.println("<td>"+m.getString("Mother_name")+"</td>");
					out.println("<td>"+m.getString("Dad_job")+"</td>");
					out.println("<td>"+m.getString("Mom_job")+"</td>");
					out.println("<td>"+m.getString("Income")+"</td>");
					out.println("<td>"+l.getString("coursename_1")+"</td>");
					out.println("<td>"+l.getString("coursename_2")+"</td>");
					out.println("<td>"+l.getString("coursename_3")+"</td>");
					out.println("</tr>");
					
					
					
				
				}
			out.println("</table>");
				
			}
			out.println("<h4 style=\"text-align:center;\"><br><a href=\"crud.html\">Go back</a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	
	}catch(Exception e) {
		e.printStackTrace();
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head>");
		out.println("<body style=\"background-color:lightcyan;\">");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center\">ERROR!</h4>");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center;\"><br><a href=\"crud.html\">Go back</a>");
		out.println("</body>");
		out.println("</html>");
	
	}
	
	}
}
