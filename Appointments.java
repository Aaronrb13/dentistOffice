
package Buisness;
import java.sql.*;


/*************************
 *Aaron Bennett
*Java 3 
*Final Project 
*Appointments B.O.
 **********************************/
public class Appointments {
    
    //==================== Properties ======================
    private String apptDateTime;
    private String patID;
    private String dentID;
    private String procCode;
    
    
    //============================= Constructors ====================
    
    public Appointments(){
        // Default Constructor
        apptDateTime = "";
        patID = "";
        dentID = "";
        procCode = "";
    }
    
    public Appointments(String adt, String pid, String did, String pc){
        apptDateTime = adt;
        patID = pid;
        dentID = did;
        procCode = pc;
         
    
    }
    //=================== Behaviors ============================
    public void setADT(String adt) {apptDateTime = adt;}
    public String getADT() {return apptDateTime;}
    
    public void setPID(String pid) {patID = pid;}
    public String getPID() {return patID;}
    
    public void setDID(String did) {dentID = did;}
    public String getDID() {return dentID;}
    
    public void setpCode(String pc) {procCode = pc;}
    public String getpCode() {return procCode;}
    
    
    public void display(){
    System.out.println("Your Appointment Date/Time is: "+getADT());
    System.out.println("Your Patient ID is: "+getPID());
    System.out.println("Your Dentist ID is: "+getDID());
    System.out.println("Your Procedure Code is: "+getpCode());
    }// end display
    
    
    //+++++++++++++++++++++++++++ DB BEHAVIORS ++++++++++++++++++++
    
    
    
    
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
        String sql = "select * from Appointments where patId= '"+getPID()+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
       rs.next();
       setADT(rs.getString(4));
       setPID(rs.getString(1));
       setDID(rs.getString(2));
       setpCode(rs.getString(3));
       
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
        String sql = "Update Appointments SET "
                                           +"apptDateTime= '"+getADT()+"',"
                                           
                                           +"dentId= '"+getDID()+"',"
                                                                                                                              
                                           +"procCode= '"+getpCode()+"' "            
                                           + " where patId= '"+getPID()+"'";
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
       /*
          
          String adt, String pid, String did, String pc   
       apptDateTime = adt;
        patID = pid;
        dentID = did;
        procCode = pc;
        */
       
        try{
            // Load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Insert into Appointments values('"+getADT()+"',"+
                                                      "'"+getPID()+"',"+
                                                      "'"+getDID()+"',"+
                                                                                                     
                                                      "'"+getpCode()+"');";
                                                         
        
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
              
             String sql = "Delete from Appointments where patId='"+getPID()+"'";
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
    // testing Appointments Select
    
   // Appointments a1 = new Appointments();
  //  a1.selectDB("A900");
  //  a1.display();
    
    // Testing Appointments insertDB()
    
  //  Appointments a2 = new Appointments();
  //  a2.insertDB("November1", "A999", "D999", "P999");
  //  a2.display();
    
    //testing updateDB()
   // Appointments a3 = new Appointments();
   // a3.updateDB("November1", "A999", "D999", "P999");
   // a3.display();
   
   // testing deleteDB()
 //  Appointments a4 = new Appointments();
 //  a4.selectDB("A999");
 //  a4.deleteDB();
 //  a4.display();
    
    }// end main
}
