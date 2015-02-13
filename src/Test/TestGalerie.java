/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DaoClasse.GalerieDao;
import DaoInterface.IGalerieDao;
import Entites.Evenement;
import Entites.Galerie;
import Entites.Offre;

/**
 *
 * @author IDRISS
 */
public class TestGalerie {
    public static void main(String[] args) 
            
    {  
    Galerie galerie = new Galerie();
    IGalerieDao iGal = new GalerieDao();
    galerie.setUrl("google.test1");
   
        Offre of = new Offre();
       of.setId(1);
       Evenement event = new Evenement();
       
       galerie.setEvent(event);
       galerie.setOffre(of);
       galerie.setType(1);
       
       
  // iGal.insertPicture(galerie);
  // iGal.deleteReclamation(1);
  // iGal.retrieveAllPicture();
   iGal.retrievePictureById(2);
    }
    
    
}
