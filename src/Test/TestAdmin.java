/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DaoClasse.AdminDao;
import DaoInterface.IAdminDao;
import Entites.Admin;

/**
 *
 * @author majed
 */
public class TestAdmin {
     public static void main(String[] args){
         
  Admin aa = new Admin(7, "opooooooo", "ggg", "jj", "seif");
          Admin a =new Admin("popo","popo","popo","popo");
          Admin b =new Admin("aiaida","majed","ma@","5555");
          IAdminDao i=new AdminDao();
          
    
         // i.ajouterAdmin(a);
        //  i.supprimerAdmin(1);
          // System.out.println("aministrateur" + a.getId() + " supprimé");
         // i.ajouterAdmin(b);
           // Admin c =new Admin(8,"benabda","seyf","sey@","6666");
           // Admin d =new Admin("hammmi","driss","dri@","5698");
           
           System.out.println(i.rechercherAdmin(27));
           
          // i.rechercherAdmin(7);

        
     } 
         
         
     
            
   
    
}
