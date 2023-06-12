package crud;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;

import crud.g;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class insert2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
		String course1="\""+req.getParameter("course1")+"\"";
		String course2="\""+req.getParameter("course2")+"\"";
		String course3="\""+req.getParameter("course3")+"\"";
		String co=g.c;
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
            String sql_query="INSERT INTO course_details VALUES ("+course1+","+course2+","+course3+","+co+")";
            con.prepareStatement(sql_query).execute();
    		PrintWriter out=res.getWriter();
    		out.println("<html>");
    		out.println("<head>");
    		out.println("<meta charset=\"ISO-8859-1\">");
    		out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/5/superhero/bootstrap.min.css\">");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("<br>");
    		out.println("<div class=\"progress\">\r\n"
    				+ "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-success\" role=\"progressbar\" aria-valuenow=\"66.6\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 66.6%;\"></div>\r\n"
    				+ "</div>");
    		out.println("<br>");
    		out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">PREFERENCE SAVED!</h2>");
    		out.println("<h3 style=\\\"font-family:Copperplate;text-align:center;\\\">");
    		out.print("Your Secret reference number is:");
    		out.println(co);
    		out.println("<h4 style=\"text-align:center;\"><br><a href=\"parent.html\">Go to parents details</a>");
    		out.println("</h3>");
		
		
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("exception occur");
	}
	
	}
}
