package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author florevittonemaldonado
 */
public class MedecinDAO {

  private Connection cnx;
  private Statement smt = null;
  private  Medecin unM;
  private ResultSet rs;
  private ArrayList<Medecin> medecins = new ArrayList<>();

 
    public MedecinDAO() throws SQLException {
        //instancie une connexion et un statement
          DAO dao = new DAO();
         
             cnx = dao.getConnection();
             smt = dao.getStatement();
    }
   
    public ArrayList<Medecin> tousLesMedecins(){
        
        //récupère le résultat de la requête dans un resultSet;
        try {
            rs = smt.executeQuery("SELECT * FROM medecin");
        //parcours le ResultSet
            
             while(rs.next()){
                 //instancie un médecin pour chaque occurence du ResultSet
               
                 Medecin med = new Medecin(rs.getString("med_nom"), rs.getString("med_prenom"),rs.getString("med_adresse"), rs.getString("med_tel"),rs.getString("med_specialitecomplementaire"),rs.getString("med_departement"));
                 
                 //Ajoute l'objet Medecin dans l'ArrayList
                 medecins.add(med);
                 
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
      //Retourne l'ArrayList avec tous les médecins de la base
      return medecins;
    }
    
    public  int compteLesMedecins(){
        //retourne le résultat du select count(*)
        int res = 0;
        try {
            rs = smt.executeQuery("SELECT count(*) as total FROM medecin");
            rs.first();
            res = rs.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        }
     
     return res;
    }
    public void mettreAJourMedecin(int numero, String med_nom, String med_prenom, String med_adresse, String med_tel, String med_specialitecomplementaire, String med_departement){
        try {
          
            String parametres[] = {"med_nom","med_prenom","med_adresse","med_tel","med_specialitecomplementaire"};
            String query =  "UPDATE medecin set ";
            if (!med_nom.isEmpty() || !med_prenom.isEmpty() || !med_adresse.isEmpty() || !med_tel.isEmpty() || !med_specialitecomplementaire.isEmpty() || !med_departement.isEmpty()){
                if (!med_nom.isEmpty()) query+="med_nom = "+med_nom;
                if (!med_prenom.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="med_prenom = "+med_prenom;
                }   
                if (!med_adresse.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="med_adresse = "+med_adresse;
                }    
                if (!med_tel.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="med_tel = "+med_tel;
                }  
                if (!med_specialitecomplementaire.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="med_specialitecomplementaire = "+med_specialitecomplementaire;
                }
                if (!med_departement.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="med_departement = "+med_departement;
                }
              
                query += " , where id = "+numero;
            }
            
          
            PreparedStatement preparedStmt = cnx.prepareStatement(query);
            //preparedStmt.setString(1, med_nom);
            //preparedStmt.setInt(2, numero);
            
            preparedStmt.executeUpdate();
            
            cnx.close();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void supprimerMedecin(int numero){
        try {
    
            String query = "DELETE FROM medecin  where id = ?";
            PreparedStatement preparedStmt = cnx.prepareStatement(query);
            preparedStmt.setInt(1, numero);
            
            preparedStmt.executeQuery();
            
            cnx.close();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Medecin getUnMedecin(int num){
        //retourne le médecin dont le numéro est passé en paramètre
        //return medecins.get(num);
        //retourne le résultat du select count(*)
        int res = 0;
        //String retour = "";
        Medecin medecin = new Medecin();
        try {
            rs = smt.executeQuery("SELECT *  FROM medecin WHERE med_id="+num);
            rs.next();
            Medecin med = new Medecin(rs.getString("med_nom"), rs.getString("med_prenom"),rs.getString("med_adresse"), rs.getString("med_tel"),rs.getString("med_specialitecomplementaire"),rs.getString("med_departement"));
            //retour = med.toString();
            medecin = med;
            rs.close();    
        }
         catch (Exception e) {
            e.printStackTrace();
        }
     //return retour;
     return medecin;
    }
  
    public static String convertDate(String d){
        //transforme la date format mariadb (aaaa-mm-jj) par aaaa/mm/jj
        //pour instancier un médecin
        String date ="";
        date = d.replace("-","/");
        
        return date;   
    }
}
