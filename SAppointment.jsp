<%-- -------------------------------
   Aaron Bennett
   Schedule Appointment jsp
   Java3 project
--------------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="Buisness.Appointments"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule Appointment</title>
    </head>
    <body>
        
        <h1>Schedule Your Appointment</h1>
        <form action="http://localhost:8084/DentistOffice/SAppointmentsServlet" method="post">
            <img src="https://www.iowastatefair.org/images/global/navigation/schedule.png"
             width="250" height="250">
            </br>
       Date/Time To Come in:    <input type="text" name="dttf"> <br/>
        PatientID: <input type="text" name="pidtf"> <br/>
        

        <input type="submit" value="Submit Appointment">
        <input type="reset" value="Reset">
        </form>
    </body>
</html>
