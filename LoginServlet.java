import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    private Connection conn;
    private PreparedStatement ps;

    public void init() throws ServletException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-BMH1KMQ:1521/XE", "nirmala", "niru");
            System.out.println("Connected successfully to the DB");
            ps = conn.prepareStatement("select username from users where userid=? and password=?");
        } catch (Exception ex) {
            ServletException se = new ServletException(ex.getMessage());
            System.out.println("Exception occured in init:" + ex.toString());
            throw se;
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        String userid = req.getParameter("userid");
        String password = req.getParameter("pwd");
        try {
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pw.println("<h3>Login Successfull</h3>");
                pw.println("<h4>Welcome" + rs.getString(1) + " to our site!</h4>");
            } else {
                pw.println("<h3>Login Denied. Invalid Userid/Password</h3>");
                pw.println("<h4>Try again<a href='login.html'>Login again</a></h4>");
            }
        } catch (SQLException sq) {
            pw.println("<h3>Sorry! Server is experiencing some issues. Please try again later</h3>");
            System.out.println("Exception occurred in doPost:" + sq);
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

    public void destroy() {
        try {
            conn.close();
            System.out.println("Disconnected successfully from the DB");
        } catch (Exception ex) {
            System.out.println("Exception occurred in destroy:" + ex);
        }
    }
}