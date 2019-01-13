/************************
 * Aaron Bennett
*   P Login Servlet
*  JAVA 3 PROJECT
 ************************/

import Buisness.Patient;
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
@WebServlet(urlPatterns = {"/Ploginservlet"})
public class Ploginservlet extends HttpServlet {

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
            String id;
            String pw;
          
        
            
            pw = request.getParameter("pwtf");
            id = request.getParameter("idtf");
            // check database
            
            
            Patient p1;
            p1 = new Patient();
            p1.selectDB(id);
            
            System.out.println("ID = "+p1.getPassWD());
            
            HttpSession ses5;
            ses5 = request.getSession();
            ses5.setAttribute("p1",p1);
            System.out.println("Patient Added to Session");
            
            
            
            if (pw.equals(p1.getPassWD()))  {
                
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
             RequestDispatcher rd = request.getRequestDispatcher("/choice.jsp");
            rd.forward(request,response);
            }
            
            else {
                
            RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
            rd.forward(request,response);
            }
           
        //    finally { out.close();}
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
