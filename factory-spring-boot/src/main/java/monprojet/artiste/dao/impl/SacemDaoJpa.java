package monprojet.artiste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.artiste.dao.SacemDao;
import monprojet.artiste.entity.Sacem;

@Transactional
@Repository
public class SacemDaoJpa implements SacemDao {

	@PersistenceContext
	private EntityManager em;

	public Sacem find(String code) {
		return em.find(Sacem.class, code);
	}

	public void create(Sacem obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Sacem> findAll() {
		List<Sacem> list = null;

		Query query = em.createQuery("from Sacem");
		list = query.getResultList();

		return list;
	}

	public Sacem update(Sacem obj) {
		return em.merge(obj);
	}

	public void delete(Sacem obj) {
		em.remove(em.merge(obj));
	}
}