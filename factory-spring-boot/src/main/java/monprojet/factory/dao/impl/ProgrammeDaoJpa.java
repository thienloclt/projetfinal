package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.ProgrammeDao;
import monprojet.factory.entity.Programme;

@Transactional
@Repository
public class ProgrammeDaoJpa implements ProgrammeDao {

	@PersistenceContext
	private EntityManager em;

	public Programme find(Integer id) {
		return em.find(Programme.class, id);
	}

	public void create(Programme obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Programme> findAll() {
		List<Programme> list = null;

		Query query = em.createQuery("from Programme");
		list = query.getResultList();

		return list;
	}

	public Programme update(Programme obj) {
		return em.merge(obj);
	}

	public void delete(Programme obj) {
		em.remove(em.merge(obj));
	}
}