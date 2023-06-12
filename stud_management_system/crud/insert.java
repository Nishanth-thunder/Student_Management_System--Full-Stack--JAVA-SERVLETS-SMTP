package crud;

import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.DriverManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class g{
	static String c;
	static String l;
}
public class insert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
		String Name="\"";	
		String mobilenum="\"";
		String mail="\"";
		Name=Name+req.getParameter("name")+"\"";
		int Age=Integer.parseInt(req.getParameter("age"));
		mobilenum=mobilenum+req.getParameter("mobile")+"\"";
		mail=mail+req.getParameter("mail")+"\"";
		int percent=Integer.parseInt(req.getParameter("percent"));
		String code="\""+Name.charAt(1)+Age+mobilenum.charAt(6)+mobilenum.charAt(7)+mobilenum.charAt(8)+"\"";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
		if(percent>40) {
		String sql_query="INSERT INTO student_details VALUES ("+code+","+Name+","+Age+","+mobilenum+","+mail+","+percent+")";
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
				+ "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-success\" role=\"progressbar\" aria-valuenow=\"33.3\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 33.3%;\"></div>\r\n"
				+ "</div>");
		out.println("<br>");
		out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">SUCCESSFULLY INSERTED!</h2>");
		out.println("<h3 style=\\\"font-family:Copperplate;text-align:center;\\\">");
		out.print("Your Secret reference number is:");
		out.println(code);
		out.println("</h3>");
		out.println("<h4 style=\"text-align:center;\"><br><a href=\"course.html\">Go to courses</a>");
		
		out.println("</body>");
		out.println("</html>");
		
		}else {
			PrintWriter out=res.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/5/superhero/bootstrap.min.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">YOUR APPLICATION IS REJECTED BY RAJ ENGINEERING COLLEGE</h2>");
			out.println("<h4 style=\\\"font-family:Copperplate;text-align:center;\\\">");
			out.println("Reason: Percentage below 40");
			out.println("<br>");
			out.println("Thank you!");
			out.println("<h4 style=\"text-align:center;\"><br><a href=\"index.html\">Go to home page</a>");
			out.println("</h4>");
			out.println("</body>");
			out.println("</html>");
			
		}
		
		
		g m=new g();
		m.c=code;
		m.l=mail;
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}
	

}
