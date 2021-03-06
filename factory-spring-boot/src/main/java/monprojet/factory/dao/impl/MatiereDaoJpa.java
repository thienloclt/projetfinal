package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.MatiereDao;
import monprojet.factory.entity.Matiere;

@Transactional
@Repository
public class MatiereDaoJpa implements MatiereDao {

	@PersistenceContext
	private EntityManager em;

	public Matiere find(Integer id) {
		return em.find(Matiere.class, id);
	}

	public void create(Matiere obj) {
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<Matiere> findByOutOfFormation(Integer formation_id) {
		List<Matiere> list = null;

		Query query = em.createQuery("SELECT m FROM Matiere m WHERE m.id NOT IN (SELECT p.matiere.id FROM Programme p, Formation f WHERE (p.formation = f) AND (f.id = :formation_id)) ORDER BY m.nom ASC");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();	

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Matiere> findByFormation(Integer formation_id) {
		List<Matiere> list = null;

		Query query = em.createQuery("SELECT m FROM Matiere m, Programme p, Formation f WHERE (p.matiere = m) AND (p.formation = f) AND (f.id = :formation_id)");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();	

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Matiere> findAll() {
		List<Matiere> list = null;

		Query query = em.createQuery("from Matiere");
		list = query.getResultList();

		return list;
	}

	public Matiere update(Matiere obj) {
		return em.merge(obj);
	}

	public void delete(Matiere obj) {
		em.remove(em.merge(obj));
	}
}