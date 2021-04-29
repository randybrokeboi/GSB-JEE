
import Modele.Medecin;
import Modele.MedecinDAO;
import Modele.Rapport;
import Modele.RapportDAO;
import Modele.VisiteDAO;
import Modele.Visiteur;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gueddoura
 */
public class Clt {


    private RapportDAO rapDAO;
    private static Rapport rap;
    private VisiteDAO visDAO;
    private static Visiteur vis;
    private MedecinDAO medDAO;
    private Medecin med;
    private static boolean source;

    public Clt() throws SQLException{
        rapDAO = new RapportDAO();
        visDAO = new VisiteDAO();
        medDAO = new MedecinDAO();
    }

    public MedecinDAO getMedDAO() {
        return medDAO;
    }

    public void setMedDAO(MedecinDAO medDAO) {
        this.medDAO = medDAO;
    }

    public Medecin getMed() {
        return med;
    }

    public void setMed(Medecin med) {
        this.med = med;
    }

    public RapportDAO getRapDAO() {
        return rapDAO;
    }

    public void setRapDAO(RapportDAO rapDAO) {
        this.rapDAO = rapDAO;
    }

    public static Rapport getRap() {
        return rap;
    }

    public static void setRap(Rapport rapo) {
        rap = rapo;
    }

    public VisiteDAO getVisDAO() {
        return visDAO;
    }

    public void setVisDAO(VisiteDAO visDAO) {
        this.visDAO = visDAO;
    }

    public static Visiteur getVis() {
        return vis;
    }

    public static void setVis(Visiteur visi) {
        vis = visi;
    }

    public static boolean isSource() {
        return source;
    }

    public static void setSource(boolean source) {
        Clt.source = source;
    }
    
}
