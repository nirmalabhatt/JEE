import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet2 extends HttpServlet {
    private Connection conn;
    private PreparedStatement ps;

    public void init() throws ServletException {
        ServletContext ct = super.getServletContext();
        ServletConfig cfg = super.getServletConfig();
        String driverName = ct.getInitParameter("driver");
        String connUrl = ct.getInitParameter("conurl");
        String username = ct.getInitParameter("username");
        String password = ct.getInitParameter("password");
        String qry = cfg.getInitParameter("qry");
        try {
            Class.forName(driverName);
            System.out.println("driver loaded Succeessfully!!");
            conn = DriverManager.getConnection(connUrl, username, password);
            System.out.println("Connection opened successfully!");
            ps = conn.prepareStatement(qry);
        } catch (Exception ex) {
            System.out.println("Exception in init" + ex);
            ServletException se = new ServletException(ex.getMessage());
            throw se;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>login Servlet</title>");
        pw.println("</head>");
        pw.println("<body>");
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        try {
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString(1);
                pw.println("<h3>Welcome" + username + "<h3>");
                pw.println("Enjoy Surfing");

            } else {

                pw.println("<h3>Sorry! Invilid Userid/password<h3>");
                pw.println("<a href='login.html'>Try Again</a>");
                pw.println("<h3> New user?</h3>");
                pw.println("<a href='register.html'>register here </a>");
            }
        } catch (SQLException ex) {
            pw.println("<h3>Sorry! try later<h3>");
        } finally {
            pw.println("</body>");
            pw.println("</html>");
            pw.close();
        }
    }

    public void destroy() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception in Distroy:" + ex);
        }
    }
}
