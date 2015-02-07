/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IReclamationDao;
import Entites.Reclamation;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Date.parse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IDRISS
 */
public class ReclamationDao implements IReclamationDao{

        Connection connexion= MyConnection.getInstance();

    @Override
    public boolean insertReclamation(Reclamation rec) {
String requete="INSERT INTO reclamation ( `Contenu`,`id_expediteur`) VALUES (?,?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        

        pst.setString(1,rec.getContenuReclamation());
        pst.setInt(2, 2);
       
        pst.executeUpdate();
                    System.out.println("Ajout effectuee avec succes");

        }
        catch (SQLException ex){
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;
        }    

    @Override
    public boolean updateReclamation(Reclamation rec) {
String requete="UPDATE reclamation set id_expediteur=? where Contenu=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,1);
        pst.setString(2,rec.getContenuReclamation());
        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;

    }

    @Override
    public boolean deleteReclamation(int id) {
        String requete="DELETE FROM reclamation where id=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,id);
       
        pst.executeUpdate();
            System.out.println("Suppression effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la Suppression"+ex.getMessage());
        }     
        
        
   return true;
    }

    @Override
    public Reclamation retrieveReclamationById(int id) {
        
        String requete ="select * from reclamation where id="+ id;

           try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
                Reclamation rec = new Reclamation();
                rec.setIdReclamation(resultat.getInt(1));
                rec.setDateReclamation(resultat.getDate(2));
                rec.setContenuReclamation(resultat.getString(3));
           return rec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations "+ex.getMessage());
            return null;
        }
        }

    @Override
    public List<Reclamation> retrieveAllReclamation() {
        List<Reclamation> listRec =new ArrayList<Reclamation>();
        String requete ="select * from reclamation";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Reclamation rec = new Reclamation();
                rec.setIdReclamation(resultat.getInt(1));
                rec.setDateReclamation(resultat.getDate(2));
                rec.setContenuReclamation(resultat.getString(3));

                
                listRec.add(rec);
            }
            return listRec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations"+ex.getMessage());
            return null;
        }
    
    }
    
}
