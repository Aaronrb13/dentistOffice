


package Buisness;
import java.sql.*;
/****************************
 * Aaron Bennett 
    Patient B.O.
    Java 3 Project
 ******************************************/
public class Patient {
    //======================== Properties =====================
    
  private  String patID;
  private String passwd;
  private String firstName;
  private String lastName;
  private String addr;
  private String email;
  private String insCo;
  


//=========================== Constructors ==============================

    public Patient(){
    // Default Constructor
    
    String patID = "";
    String passwd = "";
    String firstName = "";
    String lastName = "";
    String addr = "";
    String email = "";
    String insCo = "";


}
    
    public Patient(String pid, String pw, String fn, String ln, String em, String ad, String ico){
        
        patID = pid;
        passwd = pw;
        firstName = fn;
        lastName = ln;
        email = em;
        addr = ad;
        insCo = ico;
              
    }
    
    //=================== Behaviors ==========================
    
    public void setPatID(String pid) {patID = pid;}
    public String getPatID() {return patID;}
    
    public void setPassWD(String pw) {passwd = pw;}
    public String getPassWD() {return passwd;}
    
    public void setFname(String fn) {firstName = fn;}
    public String getFname() {return firstName;}
    
    public void setLname(String ln) {lastName = ln;}
    public String getLname() {return lastName;}
    
    public void setEmail(String em) {email = em;}
    public String getEmail() {return email;}
    
    public void setAddr(String ad) {addr = ad;}
    public String getAddr() {return addr;}
    
    public void setInsCo(String ico) {insCo = ico;}
    public String getInsCo() {return insCo;}
    
    
    public void display(){
    System.out.println("Your Patient ID is: "+getPatID());
    System.out.println("Your Password is: "+getPassWD());
    System.out.println("Your FirstName is: "+getFname());
    System.out.println("Your Lastname is: "+getLname());
    System.out.println("Your Email is: "+getEmail());
    System.out.println("Your Address is: "+getAddr());
    System.out.println("Your Insurance Company is: "+getInsCo());
    }
    
    
    //++++++++++++++++++ DB BEHAVIORS +++++++++++++++++++++++++++
    
    
     public void selectDB(String id){
        patID = id;
        try{
            
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");   
            
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "select * from Patients where patId= '"+getPatID()+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
       rs.next();
       setPassWD(rs.getString(6));
       setFname(rs.getString(1));
       setLname(rs.getString(2));
       setEmail(rs.getString(4));
       setAddr(rs.getString(3));
       setInsCo(rs.getString(5));
        //close connection
        con.close();
        
          
}// end try
         catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
        
    }// end select
     public void updateDB(){
         
         
        
       
        try{
            
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Update Patients SET "
                                           +"passwd= '"+getPassWD()+"',"
                                           +"firstName= '"+getFname()+"',"
                                           +"lastName= '"+getLname()+"',"
                                           
                                           +"email= '"+getEmail()+"', "
                                           +"addr= '"+getAddr()+"', "
                                           +"insCo= '"+getInsCo()+"' "            
                                  + " where patId= '"+getPatID()+"'";
        // execute statement
        System.out.println(sql);
        int n = stmt.executeUpdate(sql);
        
        // Process Data
       if (n==1)
           System.out.println("UPDATE SUCCESSFUL!!!");
       else
           System.out.println("UPDATE UNSUCESSFUL!!!");
        //close connection
        con.close();
        
          
}// end try
        catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
        
    }// end Update
     public void insertDB(){
      /* patID = pid;
       passwd = pw;
       firstName = fn;
       lastName = ln;
       email = em;
       addr = ad;
       insCo = ico;
    public void insertDB(String pid, String pw, String fn, String ln, String em, String ad, String ico)
        */
        try{
            // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Insert into Patients values('"+getPatID()+"',"+
                                                 "'"+getPassWD()+"',"+
                                                 "'"+getFname()+"',"+
                                                  "'"+getLname()+"',"+
                                                   "'"+getEmail()+"',"+
                                                   "'"+getAddr()+"',"+
                                                    "'"+getInsCo()+"')";
                                                         
        
        System.out.println(sql);
        int n = stmt.executeUpdate(sql);
        
        if (n==1)
            System.out.println("INSERT SUCCESSFUL!!!");
        else 
            System.out.println("INSERT FAILED*******");
        con.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }// end catch
    }// end insertDB
     
     
      public void deleteDB(){
        
        try{
            
            String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
            
             Connection con = DriverManager.getConnection(connURL);
             
              Statement stmt = con.createStatement();
              
             String sql = "Delete from Patients where patId='"+getPatID()+"'";
             System.out.println(sql);
               int n = stmt.executeUpdate(sql);
               
               if (n==1)
                   System.out.println("DELETE SUCCESSFUL!!!");
               else
                   System.out.println("DELETE FAILED********");
               con.close();
                     
             
        }// end try
        catch(Exception e1){
            System.out.println(e1);
        }// end catch
    }// end deleteDB
     
    public static void main(String args[]){
        
        //Testing SelectDB()
   //    Patient p2 = new Patient();
    //    p2.selectDB("A900");
     //   p2.display();
        
        //Testing updateDB()
        //Patient p3 = new Patient();
       // p3.updateDB("A911","9999","Soren","Zaros","Soren@gmail.com","Atlanta","NAPA");
        //p3.display();
     
     //Testing insertDB()
 //   Patient p4 = new Patient();
  //  p4.insertDB("A999","9999","Soren","Zaros","Soren@gmail.com","Atlanta","NAPAA");
  //  p4.display();
  
  //Testing deleteDB()
    //  Patient p5 = new Patient();
     // p5.selectDB("A911");
  //    p5.deleteDB();
   //   p5.display();
     
    }
    
    
    
}
