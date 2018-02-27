package monprojet.scolaire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.scolaire.dao.ProfesseurDao;
import monprojet.scolaire.entity.Professeur;

@Transactional
@Repository
public class ProfesseurDaoJpa implements ProfesseurDao {

	@PersistenceContext
	private EntityManager em;

	public Professeur find(Long id) {
		return em.find(Professeur.class, id);
	}

	public void create(Professeur obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Professeur> findAll() {
		List<Professeur> list = null;

		Query query = em.createQuery("from Professeur");
		list = query.getResultList();

		return list;
	}

	public Professeur update(Professeur obj) {
		return em.merge(obj);
	}

	public void delete(Professeur obj) {
		em.remove(em.merge(obj));
	}
}