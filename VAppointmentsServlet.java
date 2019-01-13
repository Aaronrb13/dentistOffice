/*************************
 * Aaron Bennett
* Java3 Project
* VAppointments Servlet
 *****************************/

import Buisness.Appointments;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import javax.rmi.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Tim
 */
@WebServlet(urlPatterns = {"/VAppointmentsServlet"})
public class VAppointmentsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String adt;
            String id;
            
         id =   request.getParameter("pidtf");
         adt = request.getParameter("adtf");
         
         Appointments ap1 = new Appointments();
         ap1.selectDB(id);
         
         ap1.setADT(adt);
         ap1.updateDB();
         ap1.display();
         
         
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VAppointmentsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Appointment Time Updated FOR USER  " + id + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
         catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
