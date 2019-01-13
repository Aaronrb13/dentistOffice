/******************************
 * Aaron Bennett
 * DEntist UpdateServlet
 * Java3 Project
 ***************************************/

import Buisness.Dentist;
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
@WebServlet(urlPatterns = {"/DUpdateServlet"})
public class DUpdateServlet extends HttpServlet {

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
            String em;
            String off;
          
        
             id = request.getParameter("didtf");
            pw = request.getParameter("pwtf");
            npw = request.getParameter("npwtf");
             fn = request.getParameter("fntf");
              ln = request.getParameter("lntf");
               em = request.getParameter("emtf");
                off = request.getParameter("otf");
            // check database
            
            
            Dentist d1;
            d1 = new Dentist();
            d1.selectDB(id);
            System.out.println("ID = "+d1.getID());
            
            
             if (pw.equals(d1.getPW()))  {
                
            Dentist d3 = new Dentist();
            d3.selectDB(id);
            d3.setPW(npw);
            
            d3.setFname(fn);
            d3.setLname(ln);
            
            d3.setEmail(em);
            d3.setOffice(off);
            
            
            d3.updateDB();
            d3.display();
            
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>UPDATE SUCCESSFUL  FOR USER" + id + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            /* TODO output your page here. You may use following sample code. */
          //   RequestDispatcher rd = request.getRequestDispatcher("/Update Success.jsp");
          //  rd.forward(request,response);
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
        
     
            
      /*    Dentist d3 = new Dentist();
            d3.selectDB("id");
            d3.setFname(fn);
            d3.setLname("XXXXXXX");
            d3.updateDB();
            d3.display();
            System.out.println("ID = "+d1.getPW());
            */
      
            
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
