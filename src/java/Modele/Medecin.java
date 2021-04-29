/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author florevittonemaldonado
 */
public class Medecin implements Comparable<Medecin>{
    private String mNom, mPrenom, mAdresse, mTel, mSpecialite, mDept;
    public Medecin(String nom,String prenom,String adresse, String tel,String specialite,String dept) {
        mNom = nom;
        mPrenom = prenom;
        mAdresse = adresse;
        mTel = tel;
        mSpecialite = specialite;
        mDept = dept;
    }

    public void setmNom(String mNom) {
        this.mNom = mNom;
    }

    public void setmPrenom(String mPrenom) {
        this.mPrenom = mPrenom;
    }

    public void setmAdresse(String mAdresse) {
        this.mAdresse = mAdresse;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public void setmSpecialite(String mSpecialite) {
        this.mSpecialite = mSpecialite;
    }

    public void setmDept(String mDept) {
        this.mDept = mDept;
    }

         @Override
    public String toString() {

       return mNom + " , " + mPrenom + " ";
    }
    public Medecin() {

    }
    public Medecin getLardon(int num) {
        return this;
    }

       @Override
    public int compareTo(Medecin autreMedecin) {
      return mNom.toLowerCase().compareTo(autreMedecin.getmNom().toLowerCase());
    }

    public String getmNom() {
        return mNom;
    }

    public String getmAdresse() {
        return mAdresse;
    }

    public String getmTel() {
        return mTel;
    }

    public String getmSpecialite() {
        return mSpecialite;
    }

    public String getmDept() {
        return mDept;
    }



}
