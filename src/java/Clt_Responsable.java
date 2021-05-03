/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modele.RapportDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GODART
 */


public class Clt_Responsable {

private RapportDAO unRapDAO;

    public Clt_Responsable() throws SQLException {
        unRapDAO = new RapportDAO();
    }
    
    public ArrayList<Integer> leGraphVisiteParSecteur(ArrayList<Integer> listSecteur) throws SQLException{
        System.out.println("va passer leGraphVisiteParSecteur");
        ArrayList<Integer> listNbRapSect = new ArrayList<Integer>();
        for(int numSect : listSecteur){
            listNbRapSect.add(unRapDAO.getNbRapportSect(numSect));
        }
        System.out.println("a passer leGraphVisiteParSecteur");
        return listNbRapSect;
    }
    
    public ArrayList<ArrayList<Integer>> leGraphVisiteParSecteurParMois(ArrayList<Integer> listSecteur) throws SQLException{
        ArrayList<ArrayList<Integer>> listRapMois = new ArrayList();
        for(int i = 1; i <=12; i++){
            ArrayList<Integer> listNbRapSectMois = new ArrayList<Integer>();
            for(int numSect : listSecteur){
                listNbRapSectMois.add(unRapDAO.getNbRapportSectMois(numSect, i));
            }
            listRapMois.add(listNbRapSectMois);

        }
        return listRapMois;
        
    }
    
    public ArrayList<Integer> leGraphVisiteToutesLesAnnées(ArrayList<Integer> listAnnée) throws SQLException{
        ArrayList<Integer> listNbRap = new ArrayList();
        for(int numAnnée : listAnnée){
            listNbRap.add(unRapDAO.getTousRapportUnAn(numAnnée));
        }
        return listNbRap;        
    }
    
    public ArrayList<Integer> leGraphVisiteAnMois() throws SQLException{
        ArrayList<Integer> listNbRapMois = new ArrayList<Integer>();
        for(int i = 1; i <=12; i++){
            listNbRapMois.add(unRapDAO.getTousRapportUnAnMois(i));
        }
        return listNbRapMois;
    }
    
    public ArrayList<Integer> leGraphVisiteMoisAn(int numAnnée) throws SQLException{
        ArrayList<Integer> listNbRapMoisAn = new ArrayList<Integer>();
        for(int i = 1; i <=12; i++){
            listNbRapMoisAn.add(unRapDAO.getTousRapportMoisAnnee(i, numAnnée));
        }
        return listNbRapMoisAn;
    }
    
    public ArrayList<Integer> listDate() throws SQLException{
        ArrayList<Integer> listDate = new ArrayList();
        listDate = unRapDAO.getToutsLesDatesRapport();
        return listDate;
    }
    
    public ArrayList<Integer> listSect() throws SQLException{
        ArrayList<Integer> listSect = new ArrayList();
        listSect = unRapDAO.getToutsLesSectRapport();
        return listSect;
    }
    
    public int anneeRevolu() throws SQLException{
        int annee = 0;
        annee = unRapDAO.getAnneeRevolu();
        return annee;
    }
    
    public void affiche(ArrayList unList){
        for(Object o : unList){
            System.out.println(o.toString());
        }
    }
    
}
