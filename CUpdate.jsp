<%---------------------- 
    Aaron Bennett
    CUpdate jsp
    This should be named P update but i made a mistake
    and havent changed it yet
    Java3 project
--------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        
        import="Buisness.Patient"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Update</title>
    </head>
    <body>
        <% Patient p2 ; //= new Patient(); 
        p2 = (Patient)session.getAttribute("p1");
        
        %>
        
        
        <h1>Patient Update Page</h1>
        <form action="http://localhost:8084/DentistOffice/CUpdateServlet" method="post">
            </br>
            <img src="https://conversation.which.co.uk/wp-content/uploads/2014/10/update.jpg"
             width="450" height="300">
            </br>
            
        Patient ID: &nbsp;&nbsp; &nbsp; <input type="text" name="pidtf" value= <%= p2.getPatID() %>> <br/>
        Current Password: <input type="text" name="pwtf" value="Enter Old PW"> <br/>
        NEW Password: <input type="text" name="npwtf" value="Enter New PW"> <br/>
        First Name: <input type="text" name="fntf" value= <%= p2.getFname() %>> <br/> 
        Last Name: <input type="text" name="lntf" value=<%= p2.getLname() %>><br/> 
        Address: <input type="text" name="adtf" value=<%= p2.getAddr() %>> <br/> 
        Email: <input type="text" name="emtf" value=<%= p2.getEmail() %>> <br/> 
        Insurance Company: <input type="text" name="ictf"<%= p2.getInsCo() %>> <br/> 

        <input type="submit" value="Update">
        <input type="reset" value="Reset">
        </form>
       
    </body>
</html>
