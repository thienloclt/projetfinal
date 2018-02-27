package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import monprojet.cheval.dao.OwnerDao;
import monprojet.cheval.model.Owner;

@Repository
@Transactional
public class OwnerDaoImpl implements OwnerDao {

	@PersistenceContext
	private EntityManager em;

	public Owner find(Long id) {
		return em.find(Owner.class, id);
	}

	public void create(Owner obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Owner> findAll() {
		List<Owner> list = null;

		Query query = em.createQuery("from Owner");
		list = query.getResultList();

		return list;
	}

	public Owner update(Owner obj) {
		return em.merge(obj);
	}

	public void delete(Owner obj) {
		em.remove(em.merge(obj));
	}
}
