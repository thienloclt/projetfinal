package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.OrdinateurDao;
import monprojet.factory.entity.Ordinateur;

@Transactional
@Repository
public class OrdinateurDaoJpa implements OrdinateurDao {

	@PersistenceContext
	private EntityManager em;

	public Ordinateur find(Integer id) {
		return em.find(Ordinateur.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordinateur> findByOutOfFormation(Integer formation_id) {
		List<Ordinateur> list = null;

		String sOrdinateurHasFormation = "(SELECT o.id FROM Ordinateur o JOIN o.formations fs "
				+ "WHERE EXISTS "
				+ "(SELECT f1.id FROM Formation f1 WHERE f1.id = :formation_id AND "
				+ "((fs.dateDebut BETWEEN f1.dateDebut AND f1.dateFin) OR (fs.dateFin BETWEEN f1.dateDebut AND f1.dateFin))))";
		
		Query query = em.createQuery("SELECT ord FROM Ordinateur ord WHERE ord.id NOT IN " + sOrdinateurHasFormation);

		query.setParameter("formation_id", formation_id);
		list = query.getResultList();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Ordinateur> findByFormation(Integer formation_id) {
		List<Ordinateur> list = null;

		Query query = em.createQuery("SELECT o FROM Ordinateur o JOIN o.formations fs WHERE fs.id = :formation_id");

		query.setParameter("formation_id", formation_id);
		list = query.getResultList();

		return list;
	}
	
	public void create(Ordinateur obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Ordinateur> findAll() {
		List<Ordinateur> list = null;

		Query query = em.createQuery("from Ordinateur");
		list = query.getResultList();

		return list;
	}

	public Ordinateur update(Ordinateur obj) {
		return em.merge(obj);
	}

	public void delete(Ordinateur obj) {
		em.remove(em.merge(obj));
	}
}