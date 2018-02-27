package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.cheval.dao.RegistreDao;
import monprojet.cheval.model.Registre;

@Transactional
@Repository
public class RegistreDaoJpa implements RegistreDao {

	@PersistenceContext
	private EntityManager em;

	public Registre find(Long id) {
		return em.find(Registre.class, id);
	}

	public void create(Registre obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Registre> findAll() {
		List<Registre> list = null;

		Query query = em.createQuery("from Registre");
		list = query.getResultList();

		return list;
	}

	public Registre update(Registre obj) {
		return em.merge(obj);
	}

	public void delete(Registre obj) {
		em.remove(em.merge(obj));
	}
}