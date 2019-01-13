<%-------------------------- 
    Aaron Bennett
    View/change Appointment jsp
    java3 Project
-----------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"
         import="Buisness.Patient"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Appointment</title>
    </head>
    <% Patient p2 ; //= new Patient(); 
        p2 = (Patient)session.getAttribute("p1");
                
        %>
    <body>
        <h1>Change Your Appointment??</h1>
        <form action="http://localhost:8084/DentistOffice/VAppointmentsServlet" method="post">
            <img src="http://www.battlehillhc.co.uk/website/Y02711/files/pen_on_diary.jpg"
             width="450" height="300">
            </br>
        Patient ID &nbsp;&nbsp; &nbsp;   <input type="text" name="pidtf" value=<%= p2.getPatID() %>> <br/>
        New Appointment Date <input type="text" name="adtf" value="Enter Your Desired Date&Time"> <br/> 
        
        
        <input type="submit" value="Update">
        <input type="reset" value="Reset">
        </form>
    </body>
</html>
