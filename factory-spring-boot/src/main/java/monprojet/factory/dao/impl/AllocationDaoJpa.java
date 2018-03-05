package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.AllocationDao;
import monprojet.factory.entity.Allocation;
import monprojet.factory.entity.Stagiaire;

@Transactional
@Repository
public class AllocationDaoJpa implements AllocationDao {

	@PersistenceContext
	private EntityManager em;

	public Allocation find(Integer id) {
		return em.find(Allocation.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Stagiaire> findStagiairesByFormation(Integer formation_id) {
		List<Stagiaire> list = null;

		Query query = em.createQuery("SELECT a.stagiaire FROM Allocation a, Formation f WHERE (a.formation = f) AND (f.id = :formation_id)");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();	

		return list;
	}
	
	public void create(Allocation obj) {
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<Allocation> findAllocationsByFormation(Integer formation_id) {
		List<Allocation> list = null;

		Query query = em.createQuery("SELECT a FROM Allocation a, Formation f WHERE (a.formation = f) AND (f.id = :formation_id)");
		query.setParameter("formation_id", formation_id);
		list = query.getResultList();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Allocation> findAll() {
		List<Allocation> list = null;

		Query query = em.createQuery("from Allocation");
		list = query.getResultList();

		return list;
	}

	public Allocation update(Allocation obj) {
		return em.merge(obj);
	}

	public void delete(Allocation obj) {
		em.remove(em.merge(obj));
	}
}