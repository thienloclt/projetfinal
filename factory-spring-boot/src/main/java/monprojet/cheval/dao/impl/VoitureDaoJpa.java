package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.cheval.dao.VoitureDao;
import monprojet.cheval.model.Voiture;

@Transactional
@Repository
public class VoitureDaoJpa implements VoitureDao {

	@PersistenceContext
	private EntityManager em;

	public Voiture find(Long id) {
		return em.find(Voiture.class, id);
	}

	public void create(Voiture obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Voiture> findAll() {
		List<Voiture> list = null;

		Query query = em.createQuery("from Voiture");
		list = query.getResultList();

		return list;
	}

	public Voiture update(Voiture obj) {
		return em.merge(obj);
	}

	public void delete(Voiture obj) {
		em.remove(em.merge(obj));
	}
}