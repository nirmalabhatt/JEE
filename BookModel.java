
package mvcbooksearchApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookModel {
    private static Connection conn;
    private static PreparedStatement ps;
    static
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
                System.out.println("Driver loaded successfully!");
                
                conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-BMH1KMQ:1521/XE","Nirmala","niru");
                System.out.println("Connection opened successfully!");
                ps= conn.prepareStatement("Select bookname,bookprice from allbooks where subject=?");
                ps=conn.prepareStatement("Insert into allbooks values(?,?,?,?)");
                
        }catch(Exception ex){
            System.out.println("Exception is :"+ex);
        }
        
    }
    public static ArrayList<Book>getBooksBySubject(String subject)throws SQLException
    {
         ArrayList<Book>bookList= new ArrayList<>();
         
             ps.setString(1, subject);
             ResultSet rs= ps.executeQuery();
             while(rs.next()){
                 String bookname =rs.getString(1);
                 double bookprice = rs.getDouble(2);
                 Book b= new Book();
                 b.setBookname(bookname);
                 b.setBookprise(bookprice);
                 bookList.add(b);
                 
             }
             
         return bookList;
    }
    public static void insert()throws SQLException
    {
         Book b= new Book();
            ps.setInt( 1,b.getBookid());
             ps.setString(2,b.getBookname());
             ps.setDouble(3,b.getBookprise());
             ps.setString(4,b.getSubject());
            ps.executeUpdate();
    }
    public static void closeConnection(){
        try{
           if(conn!=null){
               conn.close();
           } 
        }catch(SQLException e)
        {
            System.out.println("DB error in closing the connection");
        }
    }
    
}
