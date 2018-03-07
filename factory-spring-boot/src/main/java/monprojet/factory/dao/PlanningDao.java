package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Planning;
import monprojet.framework.dao.Dao;

public interface PlanningDao extends Dao<Planning, Integer>{
	
	public List<Planning> findMix(Integer formation_id);
}
