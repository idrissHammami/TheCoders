/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoClasse;

import DaoInterface.IPrestataireDao;
import Entites.Prestataire;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seif
 */
public class PrestataireDao implements IPrestataireDao{
     Connection connexion = MyConnection.getInstance();

    @Override
    public boolean insertPrestataire(Prestataire prestataire) {
  String requete="INSERT INTO utilisateur (nom,adresse,mail,password,tel,matricule_fiscal,description,nature) VALUES (?,?,?,?,?,?,?,?)";

        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(1,prestataire.getNom());
        pst.setString(2,prestataire.getAdresse());
        pst.setString(3, prestataire.getMail());
        pst.setInt(5, prestataire.getTel());
        pst.setString(4, prestataire.getPassword());
        pst.setString(6, prestataire.getMatriculeFiscale());
        pst.setString(7, prestataire.getDescription());
        pst.setInt(8, prestataire.getNature());
      
       
        pst.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(PrestataireDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        System.out.println("insertion avec succée");
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePrestataire(Prestataire prestataire) {
String requete="UPDATE utilisateur set nom=?, adresse=?, mail=?, tel=?, password=?,matricule_fiscal=?, description=? where id=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
          pst.setString(1,prestataire.getNom());
        pst.setString(2,prestataire.getAdresse());
        pst.setString(3, prestataire.getMail());
        pst.setInt(4, prestataire.getTel());
        pst.setString(5, prestataire.getPassword());
        pst.setString(6, prestataire.getMatriculeFiscale());
        pst.setString(7, prestataire.getDescription());
      pst.setInt(8, prestataire.getId());
       
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
    public boolean deletePrestataire(int id) {
String requete="DELETE FROM utilisateur where id=?";
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
    public Prestataire retrievePrestataireById(int id) {
        Prestataire prestataire = new Prestataire();

        String requete ="select * from utilisateur where id="+id;
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
            {
                 
                prestataire.setId(resultat.getInt(1));
               prestataire.setNom(resultat.getString(2));
               prestataire.setAdresse(resultat.getString(3));
               prestataire.setMail(resultat.getString(4));
               prestataire.setTel(resultat.getInt(5));
               prestataire.setPassword(resultat.getString(7));
               prestataire.setMatriculeFiscale(resultat.getString(11));
               prestataire.setDescription(resultat.getString(12));
               
            }
            return prestataire;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des prestataires "+ex.getMessage());
            return null;
        }
        }

    @Override
    public List<Prestataire> retrieveAllPrestataire() {
      List<Prestataire> listprestataire =new ArrayList<>();
        String requete ="select * from utilisateur where nature=0";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Prestataire ps = new Prestataire();
                ps.setId(resultat.getInt(1));
               ps.setNom(resultat.getString(2));
               ps.setAdresse(resultat.getString(3));
               ps.setMail(resultat.getString(4));
               ps.setTel(resultat.getInt(5));
               ps.setPassword(resultat.getString(7));
                 ps.setMatriculeFiscale(resultat.getString(11));
               ps.setDescription(resultat.getString(12));
               ps.setNature(resultat.getByte(13));

                
                listprestataire.add(ps);
            }
            System.out.println("succées");
            return listprestataire;
            
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des prestataires"+ex.getMessage());
            return null;
        }
    
}}
