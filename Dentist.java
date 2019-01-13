
package Buisness;
import java.sql.*;

/******************************
 *Aaron Bennett 
*Java 3 project
*Dentist B.O.
****************************************/
public class Dentist {
    //======================== properties =====================
    private String id;
    private String passwd;
    private String firstName;
    private String lastName;
    private String email;
    private String office;
    
    
    //======================= Constructors =========================
    
    
    public Dentist(){
        //default Constructor
     
        id = "";
        passwd = "";
        firstName = "";
        lastName = "";
        email = "";
        office = "";
        
    }
    
    public Dentist(String i, String pw, String fn, String ln, String em, String off){
        id = i;
        passwd = pw;
        firstName = fn;
        lastName = ln;
        email = em;
        office = off;
        
    }
    
    // ================== Behaviors ==========================
    
    public void setID(String i) {id = i;}
    public String getID() {return id;}
    
    public void setPW(String pw) {passwd = pw;}
    public String getPW() {return passwd;}
    
    public void setFname(String fn) {firstName = fn;}
    public String getFname() {return firstName;}
    
    public void setLname(String ln) {lastName = ln;}
    public String getLname() {return lastName;}
    
    public void setEmail(String em) {email = em;}
    public String getEmail() {return email;}
    
    public void setOffice(String off) {office = off;}
    public String getOffice() {return office;}
    
    public void display(){
    System.out.println("Your ID is: "+getID());
    System.out.println("Your Password is: "+getPW());
    System.out.println("Your Firstname is: "+getFname());
    System.out.println("Your Lastname is: "+getLname());
    System.out.println("Your Email is: "+getEmail());
    System.out.println("Your Office is: "+getOffice());
    
    }
    
    /* +++++++++++++++++++++++++++ DB BEHAVIORS ++++++++++++++++++++++++
    *
    *
    *
    ********************************************************************************/
    public void selectDB(String id1){
        id = id1;
        try{
            
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");   
            
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "select * from Dentists where id= '"+getID()+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
       rs.next();
       setPW(rs.getString(5));
       setFname(rs.getString(1));
       setLname(rs.getString(2));
       setEmail(rs.getString(3));
       setOffice(rs.getString(4));
        //close connection
        con.close();
        
          
}// end try
         catch(Exception e){
         System.out.println("Error!"+e);
        }// end catch
    }//end Select
    
     public void updateDB(){
         
         
        
        
        try{
            
            
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Update Dentists SET "
                                           +"passwd= '"+getPW()+"',"
                                           +"firstName= '"+getFname()+"',"
                                           +"lastName= '"+getLname()+"',"
                                           
                                           +"email= '"+getEmail()+"', "
                                           
                                           +"office= '"+getOffice()+"' "            
                                           + " where id= '"+getID()+"'";
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
     
     public void insertDB(String i, String pw, String fn, String ln, String em, String off){
       id = i;
       passwd = pw;
       firstName = fn;
       lastName = ln;
       email = em;
       office = off;
        
        try{
            // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Insert into Dentists values('"+getID()+"',"+
                                                 "'"+getPW()+"',"+
                                                 "'"+getFname()+"',"+
                                                  "'"+getLname()+"',"+
                                                   "'"+getEmail()+"',"+
                                                   
                                                    "'"+getOffice()+"')";
                                                         
        
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
              
             String sql = "Delete from Dentists where id='"+getID()+"'";
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
     
     
     
   public static void main(String[] args){
        // Testing Select
    //   Dentist c2 = new Dentist();
   //    c2.selectDB("D204");
   //     c2.display();
        
        // testing Update
       //Dentist c3 = new Dentist();
       //c3.selectDB("D201");
       //c3.setLname("XXXXXXX");
       //c3.updateDB();
       //c3.display();
      
      // Testing Insert
  //    Dentist c4 = new Dentist();
  //    c4.insertDB("D777", "pass1", "Gregory", "Davix", "Greg@gmail.com", "999");
   //   c4.display();
      
      //Testing deleteDB
   //   Dentist c5 = new Dentist();
   //   c5.selectDB("D999");
   //   c5.deleteDB();
      
        
        
    }// end main
       
    
    
}// end Dentist
