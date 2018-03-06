package monprojet.factory.dao;

import java.util.List;

import monprojet.factory.entity.Formateur;
import monprojet.framework.dao.Dao;

public interface FormateurDao extends Dao<Formateur, Integer> {
	
	public List<Formateur> findByMatiereAndOutOfFormation(Integer matiere_id, Integer formation_id);

}