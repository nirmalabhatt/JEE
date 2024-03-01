import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
public class DisplayClientInfoServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
 {
   resp.setContentType("text/html");
   PrintWriter pw=resp.getWriter();
   pw.println("<html>");
   pw.println("<head>");
   pw.println("<title>client information Display</title>");
pw.println("<style>");
pw.println("table,tr,td,th{color:white; background-color:black; font-weight:bold;}");
pw.println("</style>");
   pw.println("</head>");
   pw.println("<body>");
   String ipaddr=req.getRemoteAddr();
   pw.println("Your Ip Address is :<strong>"+ipaddr+"</strong>");
   Enumeration en= req.getHeaderNames();
pw.println("<table border='2'>");
pw.println("<tr><th>Header Name</th><th>Header value</th></tr");
while(en.hasMoreElements())
{
String hname= en.nextElement().toString();
String hvalue= req.getHeader(hname);
pw.println("<tr><td>"+hname+"</td><td>"+hvalue+"</td></tr>");
}
pw.println("</table>");

   pw.println("</body>");
   pw.println("</html>");
   pw.close();
 }
}
