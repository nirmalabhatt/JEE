import javax.servlet.*;
import java.io.*;
public class MyFirstServlet extends GenericServlet
{
 public void service(ServletRequest req, ServletResponse resp)throws ServletException,IOException
 {
   resp.setContentType("text/html");
   PrintWriter pw=resp.getWriter();
   pw.println("<html>");
   pw.println("<head>");
   pw.println("<title>My First Servlet</title>");
   pw.println("</head>");
   pw.println("<body>");
   pw.println("<strong>Welcome To Servlet!! </strong>");
   pw.println("</body>");
   pw.println("</html>");
   pw.close();
 }
}
