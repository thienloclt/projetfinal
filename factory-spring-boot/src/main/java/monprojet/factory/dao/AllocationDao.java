package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Allocation;
import monprojet.factory.entity.Stagiaire;
import monprojet.framework.dao.Dao;

public interface AllocationDao extends Dao<Allocation, Integer> {
	
	//public List<Stagiaire> findStagiairesByFormation(Integer formation_id);
	public List<Allocation> findByFormation(Integer formation_id);

}