import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
public class DateTimeServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
 {
   resp.setContentType("text/html");
   PrintWriter pw=resp.getWriter();
   pw.println("<html>");
   pw.println("<head>");
   pw.println("<title>My First Date time Servlet</title>");
   pw.println("<style>");
   pw.println("h1{color:red;}");
    pw.println("</style>");
   pw.println("</head>");
   pw.println("<body>");
Date today=new Date();
String str=today.toString();
   pw.println("<h1>Current Date time is"+str+"</h1>");
   pw.println("</body>");
   pw.println("</html>");
   pw.close();
 }
}
