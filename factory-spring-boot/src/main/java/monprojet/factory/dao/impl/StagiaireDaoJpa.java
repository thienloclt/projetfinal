package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.StagiaireDao;
import monprojet.factory.entity.Stagiaire;

@Transactional
@Repository
public class StagiaireDaoJpa implements StagiaireDao {

	@PersistenceContext
	private EntityManager em;

	public Stagiaire find(Integer id) {
		return em.find(Stagiaire.class, id);
	}

	public void create(Stagiaire obj) {
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<Stagiaire> findByOutOfFormation(Integer formation_id) {
		List<Stagiaire> list = null;

		Query query = em.createQuery("SELECT s FROM Stagiaire s WHERE s NOT IN(SELECT a.stagiaire FROM Allocation a, Formation f WHERE (a.formation = f) AND (f.id = :formation_id))");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();	

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stagiaire> findByFormation(Integer formation_id) {
		List<Stagiaire> list = null;

		Query query = em.createQuery("SELECT s FROM Stagiaire s, Allocation a, Formation f WHERE (a.stagiaire = s) AND (a.formation = f) AND (f.id = :formation_id)");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();	

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Stagiaire> findAll() {
		List<Stagiaire> list = null;

		Query query = em.createQuery("from Stagiaire");
		list = query.getResultList();

		return list;
	}

	public Stagiaire update(Stagiaire obj) {
		return em.merge(obj);
	}

	public void delete(Stagiaire obj) {
		em.remove(em.merge(obj));
	}
}