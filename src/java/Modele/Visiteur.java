/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.time.LocalDate;


/**
 *
 * @author Semedo
 */
public class Visiteur {
   private String vis_id;
   private String vis_nom;
   private String vis_prenom;
   private String vis_login;
   private String vis_mdp;
   private String vis_adresse;
   private String vis_cp;
   private String vis_ville;
   private LocalDate vis_dateEmbauche;
    
   /**
    * 
    * @param id
    * @param nom
    * @param prenom
    * @param login
    * @param mdp
    * @param adresse
    * @param cp
    * @param ville
    * @param dateEmbauche 
    */
    public Visiteur (String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String dateEmbauche ){
        this.vis_id = id;
        this.vis_nom = nom;
        this.vis_prenom = prenom;
        this.vis_login = login;
        this.vis_mdp = mdp;
        this.vis_adresse = adresse; 
        this.vis_cp = cp;
        this.vis_ville = ville;

        String[] ladate = dateEmbauche.split("/");
        int yy= Integer.parseInt(ladate[0]);
        int mm=Integer.parseInt(ladate[1]);
        int dd= Integer.parseInt(ladate[2]);
        try{
            this.vis_dateEmbauche = LocalDate.of(yy, mm, dd);
        }
        catch(Exception e){
            System.out.println("La date n'est pas valide Format yyyy,mm,dd");
        }
                 
    }
    
    /**
     * 
     * @param id
     * @param nom
     * @param login
     * @param mdp
     * @param adresse
     * @param cp
     * @param ville 
     */
    public Visiteur (String id, String nom, String login, String mdp, String adresse, String cp, String ville){
        this.vis_id = id;
        this.vis_nom = nom;
        this.vis_login = login;
        this.vis_mdp = mdp;
        this.vis_adresse = adresse; 
        this.vis_cp = cp;
        this.vis_ville = ville;
    }
    public Visiteur (String nom, String prenom){
        this.vis_nom = nom;
        this.vis_prenom = prenom;
    }

    /**
     * 
     * @return 
     */
    public String getVis_id() {
        return vis_id;
    }

    /**
     * 
     * @param vis_id 
     */
    public void setVis_id(String vis_id) {
        this.vis_id = vis_id;
    }

    /**
     * 
     * @return 
     */
    public String getVis_nom() {
        return vis_nom;
    }

    /**
     * 
     * @param vis_nom 
     */
    public void setVis_nom(String vis_nom) {
        this.vis_nom = vis_nom;
    }

    /**
     * 
     * @return 
     */
    public String getVis_login() {
        return vis_login;
    }

    /**
     * 
     * @param vis_login 
     */
    public void setVis_login(String vis_login) {
        this.vis_login = vis_login;
    }

    /**
     * 
     * @return 
     */
    public String getVis_mdp() {
        return vis_mdp;
    }

    /**
     * 
     * @param vis_mdp 
     */
    public void setVis_mdp(String vis_mdp) {
        this.vis_mdp = vis_mdp;
    }

    /**
     * 
     * @return 
     */
    public String getVis_adresse() {
        return vis_adresse;
    }

    /**
     * 
     * @param vis_adresse 
     */
    public void setVis_adresse(String vis_adresse) {
        this.vis_adresse = vis_adresse;
    }

    /**
     * 
     * @return 
     */
    public String getVis_cp() {
        return vis_cp;
    }

    /**
     * 
     * @param vis_cp 
     */
    public void setVis_cp(String vis_cp) {
        this.vis_cp = vis_cp;
    }

    /**
     * 
     * @return 
     */
    public String getVis_ville() {
        return vis_ville;
    }

    /**
     * 
     * @param vis_ville 
     */
    public void setVis_ville(String vis_ville) {
        this.vis_ville = vis_ville;
    }

    /**
     * 
     * @return 
     */
    public LocalDate getVis_dateEmbauche() {
        return vis_dateEmbauche;
    }

    /**
     * 
     * @param vis_dateEmbauche 
     */
    public void setVis_dateEmbauche(LocalDate vis_dateEmbauche) {
        this.vis_dateEmbauche = vis_dateEmbauche;
    }
    
    /**
     * 
     * @return 
     */
    public String toString(){
        return this.vis_nom + " " + this.vis_prenom; 
    }
}
