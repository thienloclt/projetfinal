package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Matiere;
import monprojet.framework.dao.Dao;

public interface MatiereDao extends Dao<Matiere, Integer> {
	
	public List<Matiere> findByOutOfFormation(Integer formation_id);
	public List<Matiere> findByFormation(Integer formation_id);
}