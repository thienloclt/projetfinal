package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.EnseignementDao;
import monprojet.factory.entity.Enseignement;

@Transactional
@Repository
public class EnseignementDaoJpa implements EnseignementDao {

	@PersistenceContext
	private EntityManager em;

	public Enseignement find(Integer id) {
		return em.find(Enseignement.class, id);
	}

	public void create(Enseignement obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Enseignement> findAll() {
		List<Enseignement> list = null;

		Query query = em.createQuery("from Enseignement");
		list = query.getResultList();

		return list;
	}

	public Enseignement update(Enseignement obj) {
		return em.merge(obj);
	}

	public void delete(Enseignement obj) {
		em.remove(em.merge(obj));
	}
}