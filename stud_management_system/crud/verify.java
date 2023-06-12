package crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class verify extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		PrintWriter out=res.getWriter();
		
		if(user.equals("admin") && pass.equals("admin123")) {
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/5/journal/bootstrap.min.css\">");
			out.println("</head>");
			out.println("<body style=\"background-color:lightcyan;\">");
			out.println("<br>");
			out.println("<h2 style=\"font-family:Lucida Handwriting;\">Raj Engineering college</h2>");
			out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">");
			out.println("<div class=\"container-fluid\">");
			out.println("<a class=\"navbar-brand\">Raj</a>");
			out.println(" <div class=\"collapse navbar-collapse\" id=\"navbarColor03\">");
			out.println("<ul class=\"navbar-nav me-auto\">");
			out.println("<li class=\"nav-item\">");
			out.println("<a class=\"nav-link active\" href=\"index.html\">Home\r\n"
					+ "            </a>");
			out.println("</li>");
			out.println("</ul>");
			out.println("</div>\r\n"
					+ "  </div>\r\n"
					+ "</nav>");
			out.println("<br>");
			out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">ACCESS APPROVED!</h2>");
			out.println("<br>");
			out.println("<h4 style=\"text-align:center;\"><br><a href=\"crud.html\">Proceed -></a>");
			out.println("</body>");
			out.println("</html>");
		}else {
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://bootswatch.com/5/journal/bootstrap.min.css\">");
			out.println("</head>");
			out.println("<body style=\"background-color:lightcyan;\">");
			out.println("<br>");
			out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">ACCESS DENIED!</h2>");
			out.println("<br>");
			out.println("<h4 style=\"text-align:center;\">Reason: Username or password is incorrect</h4>");
			out.println("<br>");
			out.println("<h4 style=\"text-align:center;\"><br><a href=\"admin.html\">Go Back</a>");
			out.println("</body>");
			out.println("</html>");
			
			
		}
	}

}
