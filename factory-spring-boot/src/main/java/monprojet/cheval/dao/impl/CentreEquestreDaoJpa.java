package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.cheval.dao.CentreEquestreDao;
import monprojet.cheval.model.CentreEquestre;

@Transactional
@Repository
public class CentreEquestreDaoJpa implements CentreEquestreDao {

	@PersistenceContext
	private EntityManager em;

	public CentreEquestre find(Long id) {
		return em.find(CentreEquestre.class, id);
	}

	public void create(CentreEquestre obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<CentreEquestre> findAll() {
		List<CentreEquestre> list = null;

		Query query = em.createQuery("from CentreEquestre");
		list = query.getResultList();

		return list;
	}

	public CentreEquestre update(CentreEquestre obj) {
		return em.merge(obj);
	}

	public void delete(CentreEquestre obj) {
		em.remove(em.merge(obj));
	}
}