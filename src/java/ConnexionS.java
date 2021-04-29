/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modele.VisiteDAO;
import java.io.IOException;
import java.sql.DriverManager;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gueddoura
 */
@WebServlet(urlPatterns = {"/ConnexionS"})
public class ConnexionS extends HttpServlet {

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
        this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionJ.jsp").forward(request, response);
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
        
        
        String login = (String)request.getParameter("login");
        String mdp = (String)request.getParameter("mdp");
        VisiteDAO visit = new VisiteDAO();
        Boolean Verif = visit.verifUser(login, mdp);
        if (Verif == true){

            System.out.println("c'est " + Verif);
            ArrayList info = visit.infoIdent(login, mdp);
            request.setAttribute("info", " "+info);
            request.setAttribute("rep", "concordent avec ceux present");
            this.getServletContext().getRequestDispatcher("/WEB-INF/HomeJ.jsp").forward(request, response);

        }
        else{

            System.out.println("c'est " + Verif);
            request.setAttribute("info", "");
            request.setAttribute("rep", "ne concordent avec aucun de ceux present");
            this.getServletContext().getRequestDispatcher("/WEB-INF/HomeJ.jsp").forward(request, response);
        }
        System.out.println("identifiant:: "+login+ " "+mdp);
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
