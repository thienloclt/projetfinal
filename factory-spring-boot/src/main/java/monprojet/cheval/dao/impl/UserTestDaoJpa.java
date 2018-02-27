package monprojet.cheval.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.cheval.dao.UserTestDao;
import monprojet.cheval.model.UserTest;

@Transactional
@Repository
public class UserTestDaoJpa implements UserTestDao {

	@PersistenceContext
	private EntityManager em;

	public UserTest find(Long id) {
		return em.find(UserTest.class, id);
	}

	public void create(UserTest obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<UserTest> findAll() {
		List<UserTest> list = null;

		Query query = em.createQuery("from UserTest");
		list = query.getResultList();

		return list;
	}

	public UserTest update(UserTest obj) {
		return em.merge(obj);
	}

	public void delete(UserTest obj) {
		em.remove(em.merge(obj));
	}
}