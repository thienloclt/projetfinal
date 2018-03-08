package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Projecteur;
import monprojet.framework.dao.Dao;

public interface ProjecteurDao extends Dao<Projecteur, Integer> {
	
	public List<Projecteur> findByOutOfFormation(Integer formation_id);

}