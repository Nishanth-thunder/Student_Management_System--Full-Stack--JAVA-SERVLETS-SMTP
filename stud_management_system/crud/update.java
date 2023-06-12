package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class update extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
		String table=req.getParameter("tab");
		String column=req.getParameter("column");
		String value=req.getParameter("val");
		String condition=req.getParameter("con");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
		String sql_query="UPDATE "+table+" SET "+column+" = "+value+" WHERE "+condition+";";
		con.prepareStatement(sql_query).execute();
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/5/journal/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body style=\"background-color:lightcyan;\">");
		out.println("<br>");
		out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">SUCCESSFULLY UPDATED!</h2>");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center;\"><br><a href=\"crud.html\">Proceed -></a>");
		out.println("</body>");
		out.println("</html>");
	}catch (Exception e) {
		e.printStackTrace();
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center\">ERROR!</h4>");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center;\"><br><a href=\"crud.html\">Go back</a>");
		out.println("</body>");
		out.println("</html>");
	
		
	
	}
	}

}
