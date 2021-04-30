/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author florevittonemaldonado
 */

public class Rapport {
    private int rap_id;
    private LocalDate rap_date;
    private String rap_dateStr;
    private String rap_motif;
    private String rap_bilan;
    private String rap_idVisiteur;
    private int rap_idMedecin;  
    private Medecin leMedecin; 
    private ArrayList<Medicament> lesMedicaments = new ArrayList();
    private Medicament leMedicament = new Medicament();

/**
 * 
 * @param id
 * @param date
 * @param motif
 * @param bilan
 * @param idVisiteur
 * @param idMedecin 
 */
public Rapport(LocalDate date, String motif, String bilan, String idVisiteur, int idMedecin){
        //this.rap_id = id;
        this.rap_bilan= bilan;
        this.rap_date= date;
        this.rap_dateStr = String.valueOf(date);
        this.rap_idMedecin= idMedecin;
        this.rap_motif= motif;
        this.rap_idVisiteur= idVisiteur;       
}

public Rapport(String motif, String bilan, String idVisiteur, int idMedecin){
    this.rap_bilan = bilan;
    this.rap_motif = motif;
    this.rap_idVisiteur = idVisiteur;
    this.rap_idMedecin = idMedecin;
}

/**
 * 
 * @param id
 * @param date
 * @param motif
 * @param bilan
 * @param idVisiteur
 * @param idMedecin 
 */

public Rapport( String date, String motif, String bilan, String idVisiteur, int idMedecin){
    this.rap_dateStr = date;
    this.rap_bilan = bilan;
    this.rap_idMedecin= idMedecin;
    this.rap_motif = motif;
    this.rap_idVisiteur= idVisiteur;
    this.leMedecin = new Medecin();
        
    
    /*String[] ladate = rap_dateStr.split("/");
        int yy= Integer.parseInt(ladate[0]);
        int mm=Integer.parseInt(ladate[1]);
        int dd= Integer.parseInt(ladate[2]);
        try{
            rap_date = LocalDate.of(yy, mm, dd);
        }
        catch(Exception e){
            System.out.println("La date n'est pas valide Format yyyy,mm,dd");
        }*/
}

public Rapport() {
}



    public Medecin getLeMedecin() {
        return leMedecin;
    }

    public void setLeMedecin(Medecin leMedecin) {
        this.leMedecin = leMedecin;
    }

    public ArrayList<Medicament> getLesMedicaments() {
        return lesMedicaments;
    }

    public void setLesMedicaments(ArrayList<Medicament> lesMedicaments) {
        this.lesMedicaments = lesMedicaments;
    }

    public Medicament getLeMedicament() {
        return leMedicament;
    }

    public void setLeMedicament(Medicament leMedicament) {
        this.leMedicament = leMedicament;
    }
    



    public int getRap_id() {
        return rap_id;
    }

    public void setRap_id(int rap_id) {
        this.rap_id = rap_id;
    }



    /**
     * 
     * @return 
     */
    public LocalDate getRap_date() {
        return rap_date;
    }

    /**
     * 
     * @return 
     */
    public String getRap_dateStr() {
        return rap_dateStr;
    }
    
    /**
     * 
     * @return 
     */
    public String getRap_motif() {
        return rap_motif;
    }

    /**
     * 
     * @return 
     */
    public String getRap_bilan() {
        return rap_bilan;
    }

    /**
     * 
     * @return 
     */
    public String getRap_idVisiteur() {
        return rap_idVisiteur;
    }

    /**
     * 
     * @return 
     */
    public int getRap_idMedecin() {
        return rap_idMedecin;
    }



    /**
     * 
     * @param rap_date 
     */
    public void setRap_date(LocalDate rap_date) {
        this.rap_date = rap_date;
    }

    /**
     * 
     * @param rap_dateStr 
     */
    public void setRap_dateStr(String rap_dateStr) {
        this.rap_dateStr = rap_dateStr;
    }

    /**
     * 
     * @param rap_motif 
     */
    public void setRap_motif(String rap_motif) {
        this.rap_motif = rap_motif;
    }

    /**
     * 
     * @param rap_bilan 
     */
    public void setRap_bilan(String rap_bilan) {
        this.rap_bilan = rap_bilan;
    }

    /**
     * 
     * @param rap_idVisiteur 
     */
    public void setRap_idVisiteur(String rap_idVisiteur) {
        this.rap_idVisiteur = rap_idVisiteur;
    }

    /**
     * 
     * @param rap_idMedecin 
     */
    public void setRap_idMedecin(int rap_idMedecin) {
        this.rap_idMedecin = rap_idMedecin;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Rapport{" + " rap_date=" + rap_date + ", rap_motif=" + rap_motif + ", rap_bilan=" + rap_bilan + ", rap_idVisiteur=" + rap_idVisiteur + ", rap_idMedecin=" + rap_idMedecin + '}';
    }   
}
