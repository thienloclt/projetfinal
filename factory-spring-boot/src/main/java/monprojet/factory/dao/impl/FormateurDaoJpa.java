package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.FormateurDao;
import monprojet.factory.entity.Formateur;

@Transactional
@Repository
public class FormateurDaoJpa implements FormateurDao {

	@PersistenceContext
	private EntityManager em;

	public Formateur find(Long id) {
		return em.find(Formateur.class, id);
	}

	public void create(Formateur obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Formateur> findAll() {
		List<Formateur> list = null;

		Query query = em.createQuery("from Formateur");
		list = query.getResultList();

		return list;
	}

	public Formateur update(Formateur obj) {
		return em.merge(obj);
	}

	public void delete(Formateur obj) {
		em.remove(em.merge(obj));
	}
}