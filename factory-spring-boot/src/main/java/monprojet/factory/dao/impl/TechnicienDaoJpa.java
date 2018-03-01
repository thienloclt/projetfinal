package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.TechnicienDao;
import monprojet.factory.entity.Technicien;

@Transactional
@Repository
public class TechnicienDaoJpa implements TechnicienDao {

	@PersistenceContext
	private EntityManager em;

	public Technicien find(Integer id) {
		return em.find(Technicien.class, id);
	}

	public void create(Technicien obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Technicien> findAll() {
		List<Technicien> list = null;

		Query query = em.createQuery("from Technicien");
		list = query.getResultList();

		return list;
	}

	public Technicien update(Technicien obj) {
		return em.merge(obj);
	}

	public void delete(Technicien obj) {
		em.remove(em.merge(obj));
	}
}