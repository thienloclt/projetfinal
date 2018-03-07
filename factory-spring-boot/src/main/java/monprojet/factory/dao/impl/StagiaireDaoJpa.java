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

		Query query = em.createQuery("SELECT s FROM Stagiaire s JOIN s.formations fs WHERE fs.id <> :formation_id");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();	

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stagiaire> findByFormation(Integer formation_id) {
		List<Stagiaire> list = null;

		Query query = em.createQuery("SELECT s FROM Stagiaire s JOIN s.formations fs WHERE fs.id = :formation_id");
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