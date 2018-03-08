package monprojet.factory.dao;

import java.util.Date;
import java.util.List;

import monprojet.factory.entity.Salle;
import monprojet.framework.dao.Dao;

public interface SalleDao extends Dao<Salle, Integer> {
	
	public List<Salle> findByOutOfFormation(Integer formation_id);
	public List<Salle> findByDuration(Date fromDat, Date endDate);

}