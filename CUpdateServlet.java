/************************
* Aaron Bennett
* Java3 Project
* CUpdate Servlet
 **************************/

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
@WebServlet(urlPatterns = {"/CUpdateServlet"})
public class CUpdateServlet extends HttpServlet {

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
            String npw;
            String fn;
            String ln;
            String addr;
            String em;
            String ic;
            
            id = request.getParameter("pidtf");
            pw = request.getParameter("pwtf");
            npw = request.getParameter("npwtf");
            fn = request.getParameter("fntf");
            ln = request.getParameter("lntf");
            addr = request.getParameter("adtf");
            em = request.getParameter("emtf");
            ic = request.getParameter("ictf");
                    
                    
            Patient p1;
            p1 = new Patient();
            p1.selectDB(id);
            System.out.println("ID = "+p1.getPatID());
            
             if (pw.equals(p1.getPassWD()))  {
                 
                 
                Patient p3 = new Patient();
                p3.selectDB(id);
                
                p3.setPassWD(npw);
                p3.setFname(fn);
                p3.setLname(ln);
                
                p3.setEmail(em);
                p3.setAddr(addr);
                p3.setInsCo(ic);
            
                p3.updateDB();
                p3.display();
                
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>UPDATE SUCCESSFUL  FOR USER "+ id + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            
            /* TODO output your page here. You may use following sample code. */
           
             }
            
            else {
                
            RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
            rd.forward(request,response);
            }
        }
           catch(Exception e) {
            System.out.println("Error!"+e);
                   }
            // end catch
         
        /* TODO output your page here. You may use following sample code. */
          
        
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
