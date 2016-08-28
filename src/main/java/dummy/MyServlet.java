package dummy;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

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
		
		
		
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("Select * from Accounting_Records");	
		
		while(rs.next()){
			out.println("<tr><td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td></tr>");
		}
		/*for(int i=0; i<100; i++){
			out.println("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
			out.println("<tr>");
			
		}*/
		
		
		}catch(Exception e){
			e.printStackTrace();
			out.println("<h1>"+e+"</h1>");
			
		}finally{
			try{
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){out.println("<h1>"+e+"</h1>");}
		}
		
		//out.println("<>");
		out.println("</table><h1>End of Reportin</h1></body></html>");

		
	}
        
        public static void main(String[] args) throws Exception {
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
        }
	
}