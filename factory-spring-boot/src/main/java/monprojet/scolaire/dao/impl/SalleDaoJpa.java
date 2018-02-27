package monprojet.scolaire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.scolaire.dao.SalleDao;
import monprojet.scolaire.entity.Salle;


@Transactional
@Repository
public class SalleDaoJpa implements SalleDao {

	@PersistenceContext
	private EntityManager em;

	public Salle find(Long id) {
		return em.find(Salle.class, id);
	}

	public void create(Salle obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Salle> findAll() {
		List<Salle> list = null;

		Query query = em.createQuery("from Salle");
		list = query.getResultList();

		return list;
	}

	public Salle update(Salle obj) {
		return em.merge(obj);
	}

	public void delete(Salle obj) {
		em.remove(em.merge(obj));
	}
}