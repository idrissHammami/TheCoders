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
 * @author GaiaDev
 */
public interface IOffreDao {
    public void insertOffre(Offre offre);
    public void updateOffre(Offre offre);
    public void deleteOffre(int d);
    public Offre retrievOffreById(int id);
    public List<Offre> DisplayAllOffre();
    
}
