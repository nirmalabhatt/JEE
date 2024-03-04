import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class MyInitParamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Init param demo Servlet</title>");
        pw.println("<style>");
        pw.println("h1{color:red;}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        ServletConfig cfg = super.getServletConfig();
        String email = cfg.getInitParameter("email");
        String phoneno = cfg.getInitParameter("phoneno");
        pw.println("<h3> Values Read From Xml </h3>");
        pw.println("<strong>email:</strong>" + email + "<br>");
        pw.println("<strong>phoneno:</strong>" + phoneno + "<br>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();

    }
}
