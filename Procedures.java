
package Buisness;
import java.sql.*;
/***************************
 *AAron Bennett
Java 3 project
Procedures B.O.
 ******************************/
public class Procedures {
    
    //========================= Properties =========================
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;
    
    //======================================== Constructors =====================
    
    public Procedures(){
        // Default Constructor
        procCode = "";
        procName = "";
        procDesc = "";
        cost = 0.0;
    }
    
    public Procedures(String pc, String pn, String pd, double c){
        procCode = pc;
        procName = pn;
        procDesc = pd;
        cost = c;
        
    }
    
    //================ Behaviors ===============
    public void setpCode(String pc) {procCode = pc;}
    public String getpCode() {return procCode;}
    
    public void setpName(String pn) {procName = pn;}
    public String getpName() {return procName;}
    
    public void setpDesc(String pd) {procDesc = pd;}
    public String getpDesc() {return procDesc;}
    
    public void setCost(double c) {cost = c;}
    public double getCost() {return cost;}
    
    
    public void display(){
        System.out.println("Your Procedure Code is: "+getpCode());
        System.out.println("Your Procedure Name is: "+getpName());
        System.out.println("Your Procedure Desc is: "+getpDesc());
        System.out.println("Your Cost is: "+getCost());
    }
    
    //++++++++++++++++ DB BEHAVIORS +++++++++++++++++++++
    
    
    public void selectDB(String id){
        procCode = id;
        try{
            
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");   
            
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/DentistOfficeACCDB.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "select * from Procedures where procCode= '"+getpCode()+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
       rs.next();
       setpName(rs.getString(2));
       setpDesc(rs.getString(3));
       setCost(rs.getDouble(4));
       
        //close connection
        con.close();
        
          
}// end try
         catch(Exception e){
         System.out.println("Error!"+e);
        }// end catch
    }//end Select
    
    
    public static void main(String[] args){
    Procedures p1 = new Procedures();
    p1.selectDB("P114");
    p1.display();
    }
}
