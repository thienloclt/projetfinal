package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Enseignement;
import monprojet.framework.dao.Dao;

public interface EnseignementDao extends Dao<Enseignement, Integer> {
	
	public List<Enseignement> findByMatiereAndOutOfFormation(Integer matiere_id, Integer formation_id);

}