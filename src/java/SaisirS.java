
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modele.Medecin;
import Modele.MedecinDAO;
import Modele.Medicament;
import Modele.MedicamentDAO;
import Modele.Rapport;
import Modele.RapportDAO;
import Modele.Visiteur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
 * @author gueddoura
 */
@WebServlet(urlPatterns = {"/SaisirS"})
public class SaisirS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SaisirS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaisirS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } */

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

         MedecinDAO mdcDAO;
         MedicamentDAO mdtDAO;
         ArrayList<Medecin> medecins;
         ArrayList<Medicament> medicaments;
             try {
                 
                //int id_visiteur = (int) request.getSession().getAttribute("id");           
                mdcDAO = new MedecinDAO();
                mdtDAO = new MedicamentDAO();
                medecins =  mdcDAO.tousLesMedecins();
                medicaments = mdtDAO.tousLesMedicaments();
                
                
                request.setAttribute("idVisiteur", request.getSession().getAttribute("idVisiteur"));
                request.setAttribute("idVisiteur", request.getSession().getAttribute("NomVisiteur"));
                request.setAttribute("listMedecins", medecins);
               
                request.setAttribute("listMedicaments", medicaments);   
     
          } catch (SQLException ex) {
            Logger.getLogger(ConsulterS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            
       
       
        this.getServletContext().getRequestDispatcher("/WEB-INF/SaisirJ.jsp").forward(request, response);
      
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
      //  processRequest(request, response);
        System.out.println("jesuisla");
          try {
              HttpSession session = request.getSession();
              Visiteur visit = (Visiteur) session.getAttribute("visi");
            MedecinDAO lune = new MedecinDAO();
            RapportDAO rptDAO =new RapportDAO();
            MedicamentDAO mdtDAO = new MedicamentDAO();
            String date = (String) request.getParameter("date");
            String motif = (String) request.getParameter("motif");
              System.out.println("date : "+ date);
            String bilan = (String) request.getParameter("bilan");
            String idVisiteur = (String) request.getParameter("idVisiteur");
            int idMedecin =  Integer.parseInt(request.getParameter("idMedecin"));
              System.out.println("medecinnnn"+idMedecin);
            Rapport rapport = new Rapport(date,motif,bilan, visit.getVis_id(),idMedecin);
            /*String medId1 = (String) request.getAttribute("idMedicament1");
            int quantite1 = (int) request.getAttribute("quantite1");
            String medId2 = (String) request.getAttribute("idMedicament2");
            int quantite2 = (int) request.getAttribute("quantite2");
            String medId3 = (String) request.getAttribute("idMedicament2");
            int quantite3 = (int) request.getAttribute("quantite3");*/
            
            //ici on ajoute qu'un medicament, mais on peut modifier la méthode creeRapportComplet pour mettre les 3 medicaments choisis
            //Medicament leMedicament = mdtDAO.getUnMedicament(medId1);
            //rptDAO.creeRapportComplet(rapport, leMedicament, quantite1);
            rptDAO.creeRapport(rapport);
           
             
           } catch (SQLException ex) {
            Logger.getLogger(ConsulterS.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        //appel a la vue
        this.getServletContext().getRequestDispatcher("/WEB-INF/HomeJ.jsp").forward(request, response);
      
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
