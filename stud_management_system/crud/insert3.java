package crud;

import jakarta.servlet.http.HttpServlet;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.*;

import com.email.durgesh.Email;

import javax.activation.*;
import crud.g;

public class insert3 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
		String father_name="\""+req.getParameter("dadname")+"\"";
		String Mother_name="\""+req.getParameter("momname")+"\"";
		String father_occu="\""+req.getParameter("dadoccu")+"\"";
		String Mother_occu="\""+req.getParameter("momoccu")+"\"";
		String annual_income="\""+req.getParameter("annual")+"\"";
		String t=g.c;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Nish@123");
        String sql_query="INSERT INTO parent_details VALUES ("+father_name+","+Mother_name+","+father_occu+","+Mother_occu+","+
        annual_income+","+t+")";
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
				+ "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-success\" role=\"progressbar\" aria-valuenow=\"100\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 100%;\"></div>\r\n"
				+ "</div>");
		out.println("<br>");
		out.println("<h2 style=\"font-family:Copperplate;text-align:center;\">SUCCESSFULLY SUBMITTED!</h2>");
		out.println("<h3 style=\\\"font-family:Copperplate;text-align:center;\\\">");
		out.print("Your Secret reference number is:");
		out.println(t);
		out.println("<br>");
		out.println("Thank you for choosing us! You will recieve a mail soon ! You may exit.");
		out.println("<br>");
		out.println("<h4 style=\"text-align:center;\"><br><a href=\"index.html\">Exit -></a>");
		out.println("</h3>");
		String to=g.l;
		Email email=new Email("raj.engineering.college.chennai@gmail.com","jipjhrcbyyhsdpkm");
		email.setFrom("raj.engineering.college.chennai@gmail.com", "Raj engineering college");
		email.setSubject("Welcome to Raj engineering college");
		email.setContent("<h3>Thank you for applying to our college!"
				+ "Your datas are saved sucessfully. You will recieve a mail soon"
				+ " regarding RAJ JEE exam details.</h3>"
				+ "<p> Raj Engineering college is one of the finest engineering college"
				+ " in the nation. We have all the amenities. We are NO.1 in NIRF rankings too."
				+ " We are also focused in co curricular activities and sports.</p><h3> Thank you!</h3>","text/html" );
		email.addRecipient(to);
		email.send();
		
		System.out.println("Done");

	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("exception occur");
	}
	}
}
