/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author GODART
 */
public class RapportDAO {
    private Connection CNX = null;
    private Statement smt = null;
    private ResultSet rs = null;
    private Rapport rapport;
    private PreparedStatement pstm = null;
    
    /**
     * 
     * @throws SQLException 
     */
    
    private static String nbRapSect = "select count(*) as nbRapSect from rapport inner join visiteur on rap_idVisiteur = vis_id where vis_departement = ? and year(rap_date) = year(NOW())-1";
    private static String nbRapSectMois = "select count(*) as nbRapSectMois from rapport inner join visiteur on rap_idVisiteur = vis_id where vis_departement = ? and year(rap_date) = year(NOW())-1 and month(rap_date) = ?";
    private static String nbRapAn = "select count(*) as nbRapAn from rapport where year(rap_date) = ?";
    private static String nbRapAnMois = "select count(*) as nbRapAnMois from rapport where year(rap_date) = year(NOW())-1 and month(rap_date) = ?";
    private static String nbRapMoisAn = "select count(*) as nbRapMoisAn from rapport where year(rap_date) = ? and month(rap_date) = ?";
    private static String listDate = "select distinct year(rap_date) as Annee from rapport order by rap_date";
    private static String listSect = "select distinct vis_departement from visiteur";
    private static String annee = "select distinct year(NOW())-1 as AnneeRevolu from rapport";
    
    /**
     * 
     * @throws SQLException 
     */
    public RapportDAO() throws SQLException{
        DAO dao = new DAO();
	this.smt = dao.getStatement();
        this.CNX = dao.getConnection();
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     * @ rapoorts avec les noms des médecins
     */
    public ArrayList<Rapport> getTousRapport() throws SQLException{
        ArrayList<Rapport> listRapport = new ArrayList();
        rs = smt.executeQuery("SELECT * FROM rapport");
        while(rs.next()){
            listRapport.add(new Rapport(rs.getInt("rap_id"), convertDateString(rs.getString("rap_date")), rs.getString("rap_motif"), rs.getString("rap_bilan"), rs.getString("rap_idVisiteur"), rs.getInt("rap_idMedecin")));
        }
        return listRapport;
    }
    
    public Rapport getUnRapport(int num){

        Rapport rapport = new Rapport();
        try {
            rs = smt.executeQuery("SELECT *  FROM rapport WHERE rap_id="+num);
            rs.next();
            Rapport rap = new Rapport(num, rs.getString("rap_date"), rs.getString("rap_motif"),rs.getString("rap_bilan"), rs.getString("rap_idVisiteur"),rs.getInt("rap_idMedecin"));
            rapport = rap;
            rs.close();    
        }
         catch (Exception e) {
            e.printStackTrace();
        }
     return rapport;
    }
    
    public Medicament getMedicament(int idRapport) throws SQLException{
        //ArrayList<Medicament> listMedicaments = new ArrayList();
        MedicamentDAO mdtDao = new MedicamentDAO();
        Medicament medicament = new Medicament();
        rs = smt.executeQuery("SELECT * FROM offrir WHERE off_idRapport = idRapport LIMIT 1");
        while(rs.next()){
            //listMedicaments.add(mdtDao.getUnMedicament(rs.getInt("off_idMedicament")));
            medicament = mdtDao.getUnMedicament(rs.getString("off_idMedicament"));

        }
        return medicament;
    }
    /**
     * 
     * @param uneDate
     * @return
     * @throws SQLException 
     */
    public ArrayList<Rapport> getUnRapportDate(String uneDate) throws SQLException{
        ArrayList<Rapport> listRapport = new ArrayList();
        rs = smt.executeQuery("select * from rapport where rap_date = '" + convertDateSQL(uneDate) + "'");
        while(rs.next()){
            listRapport.add(new Rapport(rs.getInt("rap_id"), convertDateString(rs.getString("rap_date")), rs.getString("rap_motif"), rs.getString("rap_bilan"), rs.getString("rap_idVisiteur"), rs.getInt("rap_idMedecin")));
        }
        return listRapport;
    }
    
    /**
     * 
     * @param unrapport 
     */
    public void creeRapport(Rapport unrapport) throws SQLException{
        System.out.println("avant");
        smt.executeUpdate("insert into rapport values(null, '"+ convertDateSQL(unrapport.getRap_dateStr()) + "', '" + unrapport.getRap_motif() + "', '" + unrapport.getRap_bilan() + "', '" + unrapport.getRap_idVisiteur() + "', " + unrapport.getRap_idMedecin() + ")");
    System.out.println("CREER RAPPORT");
    }

    /*public void creeRapportComplet(Rapport unrapport) throws SQLException{
        this.creeRapport(unrapport);
        System.out.println("CREER RAPPORT COMPLET");
        smt.executeUpdate("insert into offrir values(" + unrapport.getRap_id() + ", '"
                + leMedicament.getmMdc_id() + "', '" + quantite + "')");

        
    }*/
    public void creeRapportDateNull(Rapport unrapport) throws SQLException{
        smt.executeUpdate("insert into rapport values(" + unrapport.getRap_id() + ", null , '" + unrapport.getRap_motif() + "', '" + unrapport.getRap_bilan() + "', '" + unrapport.getRap_idVisiteur() + "', " + unrapport.getRap_idMedecin() + ")");
    System.out.println("CREER RAPPORT DATE");
    }
    
    /**
     * 
     * @param unrapport 
     */
    public void modifRapport(Rapport unrapport) throws SQLException{
        smt.executeUpdate("update rapport set rap_date = '"+ convertDateSQL(unrapport.getRap_dateStr()) + "', rap_motif = '" + unrapport.getRap_motif() + "', rap_bilan = '" + unrapport.getRap_bilan() + "', rap_idVisiteur = '" + unrapport.getRap_idVisiteur() + "', rap_idMedecin = " + unrapport.getRap_idMedecin() + " where rap_id = " +  unrapport.getRap_id());
    }
    
    /**
     * 
     * @param uneDate
     * @return 
     */
    public String convertDateString(String uneDate){
        String[] nwDate = uneDate.split("-");
        String convDate = nwDate[0] + "/" + nwDate[1] + "/" + nwDate[2];
        return convDate;
    }
    
    /**
     * 
     * @param uneDate
     * @return 
     */
    public String convertDateSQL(String uneDate){
        String[] nwDate = uneDate.split("/");
        String convDate = nwDate[0] + "-" + nwDate[1] + "-" + nwDate[2];
        return convDate;
    }
    public ArrayList<String> recupMotif() throws SQLException{
        //retourne la liste des motifs
        ArrayList<String> listMot = new ArrayList<>();
        rs = smt.executeQuery("select rap_motif from rapport group by rap_motif");
        while(rs.next()){
            listMot.add(rs.getString("rap_motif"));
        }
       return listMot; 
    }
    
    public int NbVisit3(String idVisiteur) throws SQLException{
        int nbVisitRap = 0;
        rs = smt.executeQuery("select count(rap_id) as num_rap from rapport where year(NOW()) - year(rap_date) <= 3 and  rap_idVisiteur = " + idVisiteur + " order by rap_id");
        rs.next();
        nbVisitRap = rs.getInt("num_rap");
        return nbVisitRap;
    }
    
    public ArrayList<Integer> NbVisitMois(String idVisiteur, int num) throws SQLException{
        ArrayList<Integer> nbVisitRapM = new ArrayList<>();
        for(int i = 1; i < 13;i++){
            rs = smt.executeQuery("select count(rap_id) as num_rap_mois from rapport where year(rap_date) = year(NOW()) - " + num + " and month(rap_date)= " + i + " and  rap_idVisiteur = " +"'"+ idVisiteur +"' "+ " order by rap_id");
            rs.next();
            nbVisitRapM.add(rs.getInt("num_rap_mois"));
        }
        return nbVisitRapM;
    }
    
    //year(NOW()) - 2019 and month(rap_date)= 10 and  rap_idVisiteur = 'a131'
    
    public ArrayList<Integer> NbVisitAnnee(String idVisiteur, int anneeDem) throws SQLException{
        ArrayList<Integer> nbVisitRapA = new ArrayList<>();
        for(int i = 1; i < 13;i++){
            rs = smt.executeQuery("select count(rap_id) as num_rap_mois from rapport where year(rap_date) = " + anneeDem + " and month(rap_date)= " + i + " and  rap_idVisiteur = " +"'"+ idVisiteur +"' "+ " order by rap_id");
            rs.next();
            nbVisitRapA.add(rs.getInt("num_rap_mois"));
        }
        return nbVisitRapA;
    }
    
    
    
    
    
    
    
    
    
    
    //pour gsbJEE
    
    public int getNbRapportSect(int numSect) throws SQLException{
        int nbRapSect = 0;
        pstm = CNX.prepareStatement(this.nbRapSect);
        pstm.setInt(1, numSect);
        rs = pstm.executeQuery();
        rs.next();
        nbRapSect = rs.getInt("nbRapSect");
        return nbRapSect;
    }
    
    public int getNbRapportSectMois(int numSect, int numMois) throws SQLException{
        int nbRapSectMois = 0;
        pstm = CNX.prepareStatement(this.nbRapSectMois);
        pstm.setInt(1, numSect);
        pstm.setInt(2, numMois);
        rs = pstm.executeQuery();
        rs.next();
        nbRapSectMois = rs.getInt("nbRapSectMois");
        return nbRapSectMois;
    }
    
    public int getTousRapportUnAn(int numAnnée) throws SQLException{
        int nbRapAn = 0;
        pstm = CNX.prepareStatement(this.nbRapAn);
        pstm.setInt(1, numAnnée);
        rs = pstm.executeQuery();
        rs.next();
        nbRapAn = rs.getInt("nbRapAn");
        return nbRapAn;
    }
    
    public int getTousRapportUnAnMois(int numMois) throws SQLException{
        int nbRapAnMois = 0;
        pstm = CNX.prepareStatement(this.nbRapAnMois);
        pstm.setInt(1, numMois);
        rs = pstm.executeQuery();
        rs.next();
        nbRapAnMois = rs.getInt("nbRapAnMois");
        return nbRapAnMois;
    }
    
    public int getTousRapportMoisAnnee(int numMois, int numAnnee) throws SQLException{
        int nbRapMoisAn = 0;
        pstm = CNX.prepareStatement(this.nbRapMoisAn);
        pstm.setInt(1, numAnnee);
        pstm.setInt(2, numMois);
        rs = pstm.executeQuery();
        rs.next();
        nbRapMoisAn = rs.getInt("nbRapMoisAn");
        return nbRapMoisAn;
    }
    
    public ArrayList<Integer> getToutsLesDatesRapport() throws SQLException{
        ArrayList<Integer> listDate = new ArrayList();
        pstm = CNX.prepareStatement(this.listDate);
        rs = pstm.executeQuery();
        while(rs.next()){
            listDate.add(rs.getInt("Annee"));
        }
        return listDate;
    }
    
    public ArrayList<Integer> getToutsLesSectRapport() throws SQLException{
        ArrayList<Integer> listSect = new ArrayList();
        System.out.println("Va envoyé");
        System.out.println(this.listSect);
        pstm = CNX.prepareStatement(this.listSect);
        System.out.println("A envoyé");
        rs = pstm.executeQuery();
        while(rs.next()){
            listSect.add(rs.getInt("vis_departement"));
        }
        return listSect;
    }
    
    public int getAnneeRevolu() throws SQLException{
        int annee = 0;
        pstm = CNX.prepareStatement(this.annee);
        rs = pstm.executeQuery();
        rs.next();
        annee = rs.getInt(1);
        return annee;
    }
}
