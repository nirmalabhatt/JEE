import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet3 extends HttpServlet {
    private Connection conn;
    private PreparedStatement ps;

    public void init() throws ServletException {
        ServletContext ct = super.getServletContext();
        ServletConfig cfg = super.getServletConfig();
        String qry = cfg.getInitParameter("qry");
        try {

            conn = (Connection) ct.getAttribute("myconn");
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

                resp.sendRedirect("login.html");
            }
        } catch (SQLException ex) {
            pw.println("<h3>Sorry! try later<h3>");
        } finally {
            pw.println("</body>");
            pw.println("</html>");
            pw.close();
        }
    }

}
