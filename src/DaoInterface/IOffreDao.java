/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Offre;
import java.util.List;

/**
 *
 * @author IDRISS
 */
public interface IOffreDao {
     public boolean insertOffre(Offre depot);


    public boolean updateOffre(Offre depot);
    public boolean deleteOffre(int id);
    public Offre retrieveOffreById(int id);
    public List<Offre> retrieveAllOffre();
    
}
