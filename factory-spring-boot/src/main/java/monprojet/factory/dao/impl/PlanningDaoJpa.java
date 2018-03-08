package monprojet.factory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.PlanningDao;
import monprojet.factory.entity.Planning;

@Transactional
@Repository
public class PlanningDaoJpa implements PlanningDao {

	@PersistenceContext
	EntityManager em;

	//////////// à rectifier <<< Planning////
	@Override
	public List<Planning> findMix(Integer formation_id) {

		String querystring = "SELECT f.dateDebut, f.dateFin, p.ordre, m.couleur, m.nom, m.duree, ft.nom,"
				+ " ft.titre FROM Programme p, Matiere m, Formateur ft,"
				+ " Formation f WHERE (p.formateur = ft) AND (p.matiere = m)"
				+ " AND (p.formation = f) AND (f.id = :formation_id) ORDER BY ordre";

		Query query = em.createQuery(querystring);
		query.setParameter("formation_id", formation_id);
		
		List<Object[]> resultSets = query.getResultList();
		List<Planning> plannings = new ArrayList<>();
		for (Object[] e : resultSets) {
			Planning planning = new Planning();
			planning.setOrdre((Integer)e[2]);
			planning.setCouleur((String)e[3]);
			planning.setNom((String)e[4]);
			planning.setDuree((Integer)e[5]);
			planning.setFormateur((String)e[6]);
			planning.setTitreFormateur((String)e[7]);
			plannings.add(planning);
		}
		return plannings;
	}

	@Override
	public Planning find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Planning obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Planning update(Planning obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Planning obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Planning> findAll() {
		 String querystring = "SELECT i FROM Planning i ORDER BY ordre";
		 Query query = em.createQuery(querystring);
		 List<Planning> list =query.getResultList();
		return list;
	}

}
