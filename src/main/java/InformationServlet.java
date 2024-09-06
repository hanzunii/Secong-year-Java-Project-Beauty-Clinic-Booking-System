import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InformationServlet
 */
@WebServlet("/InformationServlet")
public class InformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public InformationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
 
        
        pw.println("<link rel=\"stylesheet\" href=\"info-table.css\">");


        // Database connection and query execution
        try {
            // Load the MySQL JDBC driver (updated)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is ready");

            // Connect to the database (updated connection URL for newer MySQL versions)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BeautyClinic?useSSL=false&serverTimezone=UTC", "root", "");
            System.out.println("Database connected");

            	pw.println("<br>");
            	pw.println("<p id=\"txt\">Retrieve from Database</p>");
            	pw.println("<br>");
            	pw.println("<table id=\"info\">");
            	pw.println("<tr><th>Hello</th><th>Hello</th><th>Hello</th><th>Hello</th><th>Hello</th><th>Hello</th><th>Hello</th></tr>");
                  PreparedStatement ps1=con.prepareStatement("select * from clinic order by date;" );
                  ResultSet rs= ps1.executeQuery();
                  while(rs.next()) {
                    pw.println("<tr>"); 
                  	pw.println("<td>First Name : "+rs.getString(1)+"</td>");
                  	pw.println("<td>Last Name : "+rs.getString(2)+"</td>");
                  	pw.println("<td>Age : "+rs.getString(3)+"</td>");
                  	pw.println("<td>Gender : "+rs.getString(4)+"</td>");
                  	pw.println("<td>Phone : "+rs.getString(5)+"</td>");
                  	pw.println("<td>Email : "+rs.getString(6)+"</td>");
                  	pw.println("<td>Date : "+rs.getString(7)+"</td>");
                    pw.println("</tr>"); 
                  }

               pw.println("</table>"); 
               con.close();
          }
          catch(Exception e) {System.out.println(e);}
  }
  }

