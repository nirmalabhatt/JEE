
package mvcbooksearchApp;


public class Book {

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public double getBookprise() {
        return bookprise;
    }

    public void setBookprise(double bookprise) {
        this.bookprise = bookprise;
    }
  private String bookname;
  private double bookprise; 
  private int bookid;
  private String subject;

}
