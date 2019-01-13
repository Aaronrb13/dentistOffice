<%------------------------ 
    Aaron Bennett
    Java3 Project
    Dentist login jsp

----------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Login</title>
    </head>
    <body>
        <h1>Dentist Login Page</h1>
        <form action="http://localhost:8084/DentistOffice/Dloginservlet" method="post">
            <img src="https://bestdoctors.com/wp-content/uploads/2016/11/Doctor-with-Tablet.jpg"
             width="450" height="300">
            </br>
        ID: &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   <input type="text" name="idtf"> <br/>
        Password: <input type="text" name="pwtf"> <br/> 

        <input type="submit" value="Login">
        <input type="reset" value="Reset">
        </form>
    </body>
</html>
