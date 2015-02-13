/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DaoClasse.EvenementDAO;
import DaoInterface.IEvenementDAO;
import Entites.Evenement;

/**
 *
 * @author IDRISS
 */
public class TestEvenement {
    
    
     public static void main(String[] args) 
            
    {  
    Evenement event = new Evenement();
        IEvenementDAO iVen = new EvenementDAO();
    
    iVen.retrievEvenementByName("even");
    }
    
}
