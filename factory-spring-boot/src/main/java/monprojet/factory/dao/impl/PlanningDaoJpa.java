package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.PlanningDao;
import monprojet.factory.entity.Planning;

@Transactional
@Repository
public class PlanningDaoJpa implements PlanningDao {

	@PersistenceContext
	EntityManager em;

	//////////// à rectifier <<< Planning////
	@Override
	public List<Planning> findAll() {
		String querystring = "SELECT i FROM Planning i ORDER BY ordre";
		Query query = em.createQuery(querystring);
		List<Planning> list = query.getResultList();
		return list;
	}

	@Override
	public Planning find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Planning obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Planning update(Planning obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Planning obj) {
		// TODO Auto-generated method stub

	}

}
