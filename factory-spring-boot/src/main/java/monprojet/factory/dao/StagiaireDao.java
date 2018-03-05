package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Stagiaire;
import monprojet.framework.dao.Dao;

public interface StagiaireDao extends Dao<Stagiaire, Integer> {
	
	public List<Stagiaire> findByOutOfFormation(Integer formation_id);
	public List<Stagiaire> findByFormation(Integer formation_id);

}