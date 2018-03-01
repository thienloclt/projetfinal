package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.MaterielDao;
import monprojet.factory.entity.Materiel;

@Transactional
@Repository
public class MaterielDaoJpa implements MaterielDao {

	@PersistenceContext
	private EntityManager em;

	public Materiel find(Integer id) {
		return em.find(Materiel.class, id);
	}

	public void create(Materiel obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Materiel> findAll() {
		List<Materiel> list = null;

		Query query = em.createQuery("from Materiel");
		list = query.getResultList();

		return list;
	}

	public Materiel update(Materiel obj) {
		return em.merge(obj);
	}

	public void delete(Materiel obj) {
		em.remove(em.merge(obj));
	}
}