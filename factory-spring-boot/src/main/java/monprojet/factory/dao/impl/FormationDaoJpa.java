package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.FormationDao;
import monprojet.factory.entity.Formation;

@Transactional
@Repository
public class FormationDaoJpa implements FormationDao {

	@PersistenceContext
	private EntityManager em;

	public Formation find(Integer id) {
		return em.find(Formation.class, id);
	}

	public void create(Formation obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Formation> findAll() {
		List<Formation> list = null;

		Query query = em.createQuery("from Formation");
		list = query.getResultList();

		return list;
	}

	public Formation update(Formation obj) {
		return em.merge(obj);
	}

	public void delete(Formation obj) {
		em.remove(em.merge(obj));
	}
}