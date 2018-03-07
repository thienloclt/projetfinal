package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Ordinateur;
import monprojet.framework.dao.Dao;

public interface OrdinateurDao extends Dao<Ordinateur, Integer> {
	
	public List<Ordinateur> findByOutOfFormation(Integer formation_id);
	public List<Ordinateur> findByFormation(Integer formation_id);
}