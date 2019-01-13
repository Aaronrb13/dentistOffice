<%--------------------------------- 
    Aaron Bennett
    Patient Login JSP
    java 3 Project
-----------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Login</title>
    </head>
    <body>
        <h1>Patient Login Page</h1>
        <form action="http://localhost:8084/DentistOffice/Ploginservlet" method="post">
            </br>
            <img src="http://www.gastro.org/patient-care/PatientCareImage_820x410.jpg"
             width="450" height="300">
            </br>
            
        ID: &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   <input type="text" name="idtf"> <br/>
        Password: <input type="text" name="pwtf"> <br/> 

        <input type="submit" value="Login">
        <input type="reset" value="Reset">
        </form>
    </body>
</html>
