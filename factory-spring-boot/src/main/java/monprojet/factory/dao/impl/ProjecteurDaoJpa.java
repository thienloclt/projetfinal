package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.ProjecteurDao;
import monprojet.factory.entity.Projecteur;

@Transactional
@Repository
public class ProjecteurDaoJpa implements ProjecteurDao {

	@PersistenceContext
	private EntityManager em;

	public Projecteur find(Long id) {
		return em.find(Projecteur.class, id);
	}

	public void create(Projecteur obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Projecteur> findAll() {
		List<Projecteur> list = null;

		Query query = em.createQuery("from Projecteur");
		list = query.getResultList();

		return list;
	}

	public Projecteur update(Projecteur obj) {
		return em.merge(obj);
	}

	public void delete(Projecteur obj) {
		em.remove(em.merge(obj));
	}
}