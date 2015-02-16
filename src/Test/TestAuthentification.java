/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import DaoClasse.UtilisateurDao;
import DaoInterface.IUtilisateurDao;
import Entites.Utilisateur;
import java.text.ParseException;

/**
 *
 * @author aiaida
 */
public class TestAuthentification {
    public static void main(String[] args){
        IUtilisateurDao iu =new UtilisateurDao();
        Utilisateur a = new Utilisateur(5, 555, 1, "mdmldk","dhdhdj","terrz","bcrett");
        
    }
    
}
