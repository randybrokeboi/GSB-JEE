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
 * @author Semedo
 */
public class VisiteDAO {
    private Statement smt = null ;
    private ResultSet rs = null ;
    private Visiteur visiteur ;
    
    public VisiteDAO() throws SQLException{ 
	DAO dao = new DAO();
	smt = dao.getStatement();
	}
    /**
     *
     * @return  
     * @throws SQLException 
     */
    public ArrayList<Visiteur> allVisiteur() throws SQLException{
        rs = smt.executeQuery("select * from visiteur");
	ArrayList<Visiteur> listVisiteur = new ArrayList();
	//parcours le ResultSet
	while(rs.next()){
            //instancie un Lardon pour chaque occurrence du ResultSet
            visiteur = new Visiteur(rs.getString("vis_id"), 
                rs.getString("vis_nom"),
                rs.getString("vis_prenom"),
                rs.getString("vis_login"), 
                rs.getString("vis_mdp"), 
                rs.getString("vis_adresse"), 
                rs.getString("vis_cp"), 
                rs.getString("vis_ville"),
                convertDate(rs.getString("vis_dateEmbauche")));
                //Ajoute l'objet Lardon dans l'ArrayList
                listVisiteur.add(visiteur);
            }
	//Retourne l'ArrayList avec tous les Lardons de la base
	return listVisiteur;
	}
    /**
     * 
     * @param login
     * @param mdp
     * @return
     * @throws SQLException 
     */
    public boolean verifUser(String login, String mdp) throws SQLException{
        String testLogin;
        String testMdp;
        boolean test = false;
        //recupere le visiteur correspondant au login si il existe
        
        rs = smt.executeQuery("select vis_login, vis_mdp from visiteur");
        //parcours le resultat de la requete 
        while(rs.next()){
            testLogin = rs.getString("vis_login");
            testMdp = rs.getString("vis_mdp");
            System.out.println(" identifiant de la base:  "+testLogin +" "+ testMdp);
            System.out.println("identifiant: "+login+ " "+mdp);
            System.out.println("Concordent ? : "+(testLogin.equals(login) && testMdp.equals(mdp)));
            //verifie si le login et le mot de passe corresponde
            if(testLogin.equals(login) && testMdp.equals(mdp)){ 
                test = true;
                return test;
            }
        }
        return test;
    }
    /**
     * 
     * @param login
     * @return
     * @throws SQLException 
     */
    public Visiteur creatVisiteur(String login) throws SQLException{
        rs = smt.executeQuery("select * from visiteur where vis_login =" 
                +"'"+login+"'");
        rs.next();
        visiteur = new Visiteur(rs.getString("vis_id"), 
                rs.getString("vis_nom"),
                rs.getString("vis_prenom"),
                rs.getString("vis_login"), 
                rs.getString("vis_mdp"), 
                rs.getString("vis_adresse"), 
                rs.getString("vis_cp"), 
                rs.getString("vis_ville"),
                convertDate(rs.getString("vis_dateEmbauche")));
        return visiteur;
    }
    public ArrayList<String> infoIdent(String login, String mdp) throws SQLException{
        rs = smt.executeQuery("select vis_nom, vis_prenom from visiteur where vis_login =" 
                +"'"+login+"'"+"and vis_mdp =" 
                +"'"+mdp+"'");
        ArrayList<String> listVisiteur = new ArrayList();
	//parcours le ResultSet
	while(rs.next()){
            //instancie un Lardon pour chaque occurrence du ResultSet
            visiteur = new Visiteur(rs.getString("vis_nom"),
                rs.getString("vis_prenom"));
                //Ajoute l'objet Lardon dans l'ArrayList
                listVisiteur.add(visiteur.toString());
            }
	//Retourne l'ArrayList avec tous les Lardons de la base
	return listVisiteur;
	}
    /**
     * 
     * @param d
     * @return 
     */
    public static String convertDate(String d){
            if (d!=null){
		//transforme la date format mariadb (aaaa-mm-jj) par aaaa/mm/jj
		String[] nwDate = d.split("-");
		String convDate = nwDate[0] + "/" + nwDate[1] + "/" + nwDate[2];
		// pour instancier un lardon
		return convDate;
            }
            return "00/00/00";
	}
    
    public Boolean isresp(Visiteur visi) throws SQLException{
        rs = smt.executeQuery("select * from visiteur where vis_id in (select res_id from responsable) and vis_id = '" + visi.getVis_id()+"'");
        rs = smt.executeQuery("select res_id from responsable");
        while(rs.next()){
            //instancie un Lardon pour chaque occurrence du ResultSet
                if (visi.getVis_id().equals(rs.getString("res_id"))){
                    return true;
                }
            }
        System.out.println("id = "+ visi.getVis_id());
        
        return false;
    }
}