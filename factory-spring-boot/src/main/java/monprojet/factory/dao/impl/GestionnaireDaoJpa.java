package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.GestionnaireDao;
import monprojet.factory.entity.Gestionnaire;

@Transactional
@Repository
public class GestionnaireDaoJpa implements GestionnaireDao {

	@PersistenceContext
	private EntityManager em;

	public Gestionnaire find(Long id) {
		return em.find(Gestionnaire.class, id);
	}

	public void create(Gestionnaire obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Gestionnaire> findAll() {
		List<Gestionnaire> list = null;

		Query query = em.createQuery("from Gestionnaire");
		list = query.getResultList();

		return list;
	}

	public Gestionnaire update(Gestionnaire obj) {
		return em.merge(obj);
	}

	public void delete(Gestionnaire obj) {
		em.remove(em.merge(obj));
	}
}