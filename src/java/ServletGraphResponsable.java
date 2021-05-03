/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modele.VisiteDAO;
import Modele.Visiteur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author godart
 */
@WebServlet(name = "ServletGraphResponsable", urlPatterns = {"/ServletGraphResponsable"})
public class ServletGraphResponsable extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Clt_Responsable clt_Responsable;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        VisiteDAO visit;
        try {
            clt_Responsable = new Clt_Responsable();
            request.setAttribute("listDate",clt_Responsable.listDate());
            visit = new VisiteDAO();
            HttpSession session = request.getSession();
            if (visit.isresp((Visiteur) session.getAttribute("visi"))){
                
               
                this.getServletContext().getRequestDispatcher("/WEB-INF/StatResponsableJ.jsp").forward(request, response);
                
            }
            else{
            
                this.getServletContext().getRequestDispatcher("/WEB-INF/HomeJ.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletGraphResponsable.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        try {
            clt_Responsable = new Clt_Responsable();
            if(request.getParameter("buttonGraph").equals("leGraphVisiteParSecteur")){
                request.setAttribute("typeGraph", "1");
                request.setAttribute("LaList", clt_Responsable.leGraphVisiteParSecteur(clt_Responsable.listSect()));
            }
            else if(request.getParameter("buttonGraph").equals("leGraphVisiteParSecteurParMois")){
                request.setAttribute("typeGraph", "2");
                request.setAttribute("LaList", clt_Responsable.leGraphVisiteParSecteurParMois(clt_Responsable.listSect()));
            }
            else if(request.getParameter("buttonGraph").equals("leGraphVisiteToutesLesAnnees")){
                request.setAttribute("typeGraph", "3");
                request.setAttribute("LaList", clt_Responsable.leGraphVisiteToutesLesAnnées(clt_Responsable.listDate()));
            }
            else if(request.getParameter("buttonGraph").equals("leGraphVisiteAnMois")){
                request.setAttribute("typeGraph", "4");
                request.setAttribute("LaList", clt_Responsable.leGraphVisiteAnMois());
            }
            else if(request.getParameter("buttonGraph").equals("leGraphVisiteMoisAn")){
                request.setAttribute("typeGraph", "5");
                request.setAttribute("LaList", clt_Responsable.leGraphVisiteMoisAn(Integer.parseInt(request.getParameter("Annee"))));
            }
            request.setAttribute("listSect",clt_Responsable.listSect());
            request.setAttribute("listDate",clt_Responsable.listDate());
            request.setAttribute("anneeRevolu",clt_Responsable.anneeRevolu());
            this.getServletContext().getRequestDispatcher("/WEB-INF/StatResponsableJ.jsp").forward(request, response);
        }catch (SQLException ex) {
            Logger.getLogger(ServletGraphResponsable.class.getName()).log(Level.SEVERE, null, ex);
        }
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
