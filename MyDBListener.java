
import javax.servlet.*;
import java.sql.*;

public class MyDBListener implements ServletContextListener {
  private Connection conn;

  public void contextInitialized(ServletContextEvent sec) {
    ServletContext ct = sec.getServletContext();
    String driverName = ct.getInitParameter("driver");
    String conUrl = ct.getInitParameter("conurl");
    String username = ct.getInitParameter("username");
    String password = ct.getInitParameter("password");
    try {
      Class.forName(driverName);
      System.out.println("Driver Loaded Successfully");
      conn = DriverManager.getConnection(conUrl, username, password);
      System.out.println("Connection Opened Successfully");
      ct.setAttribute("myconn", conn);
      System.out.println("Listener Has Set the Connection Object");
      Thread.sleep(5000);
    } catch (Exception ex) {
      System.out.println(" Exception in Listener" + ex);
      try {
        Thread.sleep(5000);
      } catch (Exception e) {
        System.out.println(" in Slep Exception");
      }
    }

  }

  public void contextDestroyed(ServletContextEvent sec) {
    try {
      conn.close();
    } catch (Exception e) {
      System.out.println("  Exception in destroyed");
    }
  }
}