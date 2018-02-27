package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.cheval.dao.ChevalDao;
import monprojet.cheval.model.Cheval;

@Transactional
@Repository
public class ChevalDaoJpa implements ChevalDao {

	@PersistenceContext
	private EntityManager em;

	public Cheval find(Long id) {
		return em.find(Cheval.class, id);
	}

	public void create(Cheval obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Cheval> findAll() {
		List<Cheval> list = null;

		Query query = em.createQuery("from Cheval");
		list = query.getResultList();

		return list;
	}

	public Cheval update(Cheval obj) {
		return em.merge(obj);
	}

	public void delete(Cheval obj) {
		em.remove(em.merge(obj));
	}
}