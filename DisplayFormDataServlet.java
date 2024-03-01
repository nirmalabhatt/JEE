import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class DisplayFormDataServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
 {
   resp.setContentType("text/html");
   PrintWriter pw=resp.getWriter();
   pw.println("<html>");
   pw.println("<head>");
   pw.println("<title>displaying form data Servlet</title>");
   pw.println("</head>");
   pw.println("<body>");
String username= req.getParameter("user");
String gender = req.getParameter("gender");
String[]hobbies=req.getParameterValues("hobbies");
pw.println("<strong>Your Name:</strong>"+username+"<br>");
pw.println("<strong>Your gender:</strong>"+gender+"<br>");
pw.println("<strong>Your hobbies:</strong><br>");
String str="";
for(String h:hobbies)
{
str=str+h+",";
}
pw.println(str.substring(0,str.lastIndexOf(",")));
   pw.println("</body>");
   pw.println("</html>");
   pw.close();
 }
}
