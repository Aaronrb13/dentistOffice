<%-- ---------------------------
    Dentist Update jsp
    Aaron Bennett
    Java3 Project
-----------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="Buisness.Dentist"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Update</title>
    </head>
    <body>
        
        <% Dentist d2 ; //= new Patient(); 
        d2 = (Dentist)session.getAttribute("d1");
                
        %>
        <form action="http://localhost:8084/DentistOffice/DUpdateServlet" method="post">
            <img src="https://www.madeiraislandnews.com/wp-content/uploads/2017/02/update-button-blue-clip-art-at-clker-com-vector-clip-art-online-Rjk6Bx-clipart.png"
             width="450" height="300">
            </br>
        Dentist ID: &nbsp;&nbsp; &nbsp;  <input type="text" name="didtf"  value=<%= d2.getID() %>> <br/>
       OLD Password: <input type="text" name="pwtf" value="Enter your old PW" ><br/> 
       NEW Password <input tyep="text" name="npwtf" value="Enter your NEW PW"> </br>
        First Name: <input type="text" name="fntf" value=<%= d2.getFname() %>> <br/> 
        Last Name: <input type="text" name="lntf" value=<%= d2.getLname() %>> <br/> 
        Email <input type="text" name="emtf" value=<%= d2.getEmail() %>> <br/> 
        Office <input type="text" name="otf" value=<%= d2.getOffice() %> ><br/> 
        
        <input type="submit" value="Update">
        <input type="reset" value="Reset">
        </form>
    </body>
</html>
