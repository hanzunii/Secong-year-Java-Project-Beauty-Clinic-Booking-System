import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InformationServlet
 */
@WebServlet("/InsertInformationServlet")
public class InsertInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public InsertInformationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        // Retrieving parameters from the request
        String firstname = request.getParameter("Fname");
        String lastname = request.getParameter("Lname");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String date = request.getParameter("date");


        // Database connection and query execution
        try {
            // Load the MySQL JDBC driver (updated)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is ready");

            // Connect to the database (updated connection URL for newer MySQL versions)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BeautyClinic?useSSL=false&serverTimezone=UTC", "root", "");
            System.out.println("Database connected");

            // Insert data into the clinic table
            PreparedStatement ps = con.prepareStatement("INSERT INTO clinic (firstname, lastname, age, gender, phone, email, date) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, age);
            ps.setString(4, gender);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, date);
            ps.executeUpdate();
            con.close();
          }
          catch(Exception e) {System.out.println(e);}
  }
  }



