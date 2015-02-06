/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IOffreDao;
import Entites.Offre;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IDRISS
 */
public class OffreDao implements IOffreDao
{
    
           Connection connexion= MyConnection.getInstance();

    public boolean insertOffre(Offre depot) {
String requete="INSERT INTO depot (adresse_depot) VALUES (?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,depot.getId());
        pst.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;
        }    

    public boolean updateOffre(Offre off) {
String requete="UPDATE reclamation set id_reclamation=? where id_reclamation=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,off.getId());
        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;

    }

    public boolean deleteOffre(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Offre retrieveOffreById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Offre> retrieveAllOffre() {
        List<Offre> listRec =new ArrayList<>();
        String requete ="select * from offre";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Offre off = new Offre();
                off.setId(resultat.getInt(2));
                listRec.add(off);
            }
            return listRec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations"+ex.getMessage());
            return null;
        }
    
    }
    
    
    
}
