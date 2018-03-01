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