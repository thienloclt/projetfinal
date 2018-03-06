package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Programme;
import monprojet.framework.dao.Dao;

public interface ProgrammeDao extends Dao<Programme, Integer> {
	
	public List<Programme> findByFormation(Integer formation_id);

}