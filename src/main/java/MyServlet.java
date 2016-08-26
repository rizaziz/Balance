package dummy;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html><head><title>Acconting Balance</title>");
		out.println("<style>");
		out.println("table, th, tr, td{border: 1px solid black; border-collapse:collapse}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body><h1>HelloServlet</h1>");		
		out.println("<table>");
		out.println("<tr><th>Account</th>");
		out.println("<th>Description</th>");
		out.println("<th>Beginning Balance</th>");
		out.println("<th>Turnover</th>");
		out.println("<th>Ending Balance</th></tr>");
		for(int i=0; i<100; i++){
			out.println("<tr><td></td><td></td><td></td><td></td><td></td></tr>");		}
		out.println("</table></body></html>");	
	
	}	
}