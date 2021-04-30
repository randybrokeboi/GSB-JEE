package Modele;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claude
 */
public class MedicamentDAO {

  private Connection cnx;
  private Statement smt = null;
  private  Rapport unR;
  private ResultSet rs;

 
    public MedicamentDAO() throws SQLException {
        //instancie une connexion et un statement
          DAO dao = new DAO();
         
             cnx = dao.getConnection();
             smt = dao.getStatement();
    }
   
    public ArrayList<Medicament> tousLesMedicaments(){
        ArrayList<Medicament> medicaments = new ArrayList<>();
        //récupère le résultat de la requête dans un resultSet;
        try {
            rs = smt.executeQuery("SELECT * FROM medicament");
        //parcours le ResultSet
            
             while(rs.next()){
                 //instancie un médicament pour chaque occurence du ResultSet
               
                 Medicament med = new Medicament(rs.getString("mdc_id"),rs.getString("mdc_nomCommercial"), 
                         rs.getString("mdc_idFamille"),rs.getString("mdc_composition"), rs.getString("mdc_effets"),rs.getString("mdc_contreIndications"));
                 
                 //Ajoute l'objet Medicament dans l'ArrayList
                 medicaments.add(med);
                 
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
      //Retourne l'ArrayList avec tous les médicaments de la base
      return medicaments;
    }
    
    public  int compteLesMedicaments(){
        //retourne le résultat du select count(*)
        int res = 0;
        try {
            rs = smt.executeQuery("SELECT count(*) as total FROM medicament");
            rs.first();
            res = rs.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        }
     
     return res;
    }
    public void mettreAJourMedicament(String mdc_id, String mdc_nomCommercial, String mdc_idFamille, String mdc_composition, String mdc_effets, String mdc_contreIndications){
        try {
          
            String parametres[] = {"mdc_id","mdc_nomCommercial","mdc_idFamille","mdc_composition","mdc_effets","mdc_contreIndications"};
            String query =  "UPDATE medicament set ";
            if (!mdc_id.isEmpty() ||!mdc_nomCommercial.isEmpty() || !mdc_idFamille.isEmpty()|| !mdc_composition.isEmpty()  || !mdc_effets.isEmpty() || !mdc_contreIndications.isEmpty()){
                if (!mdc_nomCommercial.isEmpty()) query+="mdc_nomCommercial = "+mdc_nomCommercial;
                if (!mdc_idFamille.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="mdc_idFamille = "+mdc_idFamille;
                }   
                if (!mdc_composition.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="mdc_composition = "+mdc_composition;
                }    
                if (!mdc_effets.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="mdc_effets = "+mdc_effets;
                }  
                if (!mdc_contreIndications.isEmpty()) 
                {
                    if (!query.isEmpty()) query+=" , ";
                    query+="mdc_contreIndications = "+mdc_contreIndications;
                }
              
              
                query += " , where id = "+mdc_id;
            }
            
          
            PreparedStatement preparedStmt = cnx.prepareStatement(query);
            //preparedStmt.setString(1, mdc_nomCommercial);
            //preparedStmt.setInt(2, numero);
            
            preparedStmt.executeUpdate();
            
            cnx.close();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void supprimerMedicament(int numero){
        try {
    
            String query = "DELETE FROM medicament  where id = ?";
            PreparedStatement preparedStmt = cnx.prepareStatement(query);
            preparedStmt.setInt(1, numero);
            
            preparedStmt.executeQuery();
            
            cnx.close();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Medicament getUnMedicament(String num){

        int res = 0;

        Medicament medicament = new Medicament();
        try {
            rs = smt.executeQuery("SELECT *  FROM medicament WHERE med_id="+num);
            rs.next();
            Medicament med = new Medicament(num,rs.getString("mdc_nomCommercial"), rs.getString("mdc_idFamille"),rs.getString("mdc_composition"), rs.getString("mdc_effets"),rs.getString("mdc_contreIndications"));
     
            medicament = med;
            rs.close();    
        }
         catch (Exception e) {
            e.printStackTrace();
        }

     return medicament;
    }
  
    public static String convertDate(String d){
        //transforme la date format mariadb (aaaa-mm-jj) par aaaa/mm/jj
        //pour instancier un médicament
        String date ="";
        date = d.replace("-","/");
        
        return date;   
    }

    
}
