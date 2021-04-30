/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author claude
 */
public class Medicament implements Comparable<Medicament>{
    private String mMdc_id,mMdc_idFamille,mMdc_nomCommercial, mMdc_composition, mMdc_effets, mMdc_contreIndications;
   

    public Medicament(String mMdc_id, String mMdc_nomCommercial, String mMdc_idFamille, String mMdc_composition, String mMdc_effets, String mMdc_contreIndications) {
        this.mMdc_id = mMdc_id;
        this.mMdc_nomCommercial = mMdc_nomCommercial;
        this.mMdc_idFamille = mMdc_idFamille;
        this.mMdc_composition = mMdc_composition;
        this.mMdc_effets = mMdc_effets;
        this.mMdc_contreIndications = mMdc_contreIndications;
    }

    public Medicament() {
    }

    public String getmMdc_id() {
        return mMdc_id;
    }

    public void setmMdc_id(String mMdc_id) {
        this.mMdc_id = mMdc_id;
    }

    
    public String getmMdc_nomCommercial() {
        return mMdc_nomCommercial;
    }

    public void setmMdc_nomCommercial(String mMdc_nomCommercial) {
        this.mMdc_nomCommercial = mMdc_nomCommercial;
    }

    public String getmMdc_idFamille() {
        return mMdc_idFamille;
    }

    public void setmMdc_idFamille(String mMdc_idFamille) {
        this.mMdc_idFamille = mMdc_idFamille;
    }

    public String getmMdc_composition() {
        return mMdc_composition;
    }

    public void setmMdc_composition(String mMdc_composition) {
        this.mMdc_composition = mMdc_composition;
    }

    public String getmMdc_effets() {
        return mMdc_effets;
    }

    public void setmMdc_effets(String mMdc_effets) {
        this.mMdc_effets = mMdc_effets;
    }

    public String getmMdc_contreIndications() {
        return mMdc_contreIndications;
    }

    public void setmMdc_contreIndications(String mMdc_contreIndications) {
        this.mMdc_contreIndications = mMdc_contreIndications;
    }

    @Override
    public int compareTo(Medicament autreMedicament) {
       return mMdc_nomCommercial.toLowerCase().compareTo(autreMedicament.getmMdc_nomCommercial().toLowerCase());
    }
    
    
}
