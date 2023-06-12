package crud;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class delete extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
		String code=req.getParameter("con");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/students?user=root&password=Nish@123");
		String sql_query="DELETE FROM student_details "+"WHERE code="+"'"+code+"'"+";";
		conn.prepareStatement(sql_query).execute();
		sql_query="DELETE FROM course_details "+"WHERE code="+"'"+code+"'"+";";
		conn.prepareStatement(sql_query).execute();
		sql_query="DELETE FROM parent_details "+"WHERE code="+"'"+code+"'"+";";
		conn.prepareStatement(sql_query).execute();
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/5/journal/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body style=\"background-color:lightcyan;\">");
		out.println("<br>");
		out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">SUCCESSFULLY DELETED!</h2>");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center;\"><br><a href=\"crud.html\">Proceed -></a>");
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
