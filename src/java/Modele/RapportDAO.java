/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author GODART
 */
public class RapportDAO {
    private Statement smt = null;
    private ResultSet rs = null;
    private Rapport rapport;
    
    /**
     * 
     * @throws SQLException 
     */
    public RapportDAO() throws SQLException{
        DAO dao = new DAO();
	this.smt = dao.getStatement();
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
}
