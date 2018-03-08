package monprojet.factory.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.SalleDao;
import monprojet.factory.entity.Salle;

@Transactional
@Repository
public class SalleDaoJpa implements SalleDao {

	@PersistenceContext
	private EntityManager em;

	public Salle find(Integer id) {
		return em.find(Salle.class, id);
	}

	public void create(Salle obj) {
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<Salle> findByOutOfFormation(Integer formation_id) {
		List<Salle> list = null;

		String sSalleHasFormation = "(SELECT s1.id FROM Salle s1, Formation f "
				+ "WHERE (f.salle = s1) AND (f.id <> :formation_id) AND EXISTS "
				+ "(SELECT fviewing.id FROM Formation fviewing WHERE fviewing.id = :formation_id AND "
				+ "((f.dateDebut BETWEEN fviewing.dateDebut AND fviewing.dateFin) "
				+ "OR (f.dateFin BETWEEN fviewing.dateDebut AND fviewing.dateFin) "
				+ "OR (f.dateDebut < fviewing.dateDebut AND f.dateFin > fviewing.dateFin)"
				+ ")))";
		
		Query query = em.createQuery("SELECT s FROM Salle s WHERE s.id NOT IN " + sSalleHasFormation);

		query.setParameter("formation_id", formation_id);
		list = query.getResultList();

		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Salle> findByDuration(Date fromDate, Date endDate) {
		List<Salle> list = null;

		Query query = em.createQuery("SELECT DISTINCT  s FROM Salle s JOIN s.formations f WHERE f.dateFin >= :fromDate AND f.dateDebut <= :endDate");

		System.out.println(fromDate.toString() + "  " +endDate.toString());
		query.setParameter("fromDate", fromDate, TemporalType.DATE);
		query.setParameter("endDate", endDate, TemporalType.DATE);
		list = query.getResultList();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Salle> findAll() {
		List<Salle> list = null;

		Query query = em.createQuery("from Salle");
		list = query.getResultList();

		return list;
	}

	public Salle update(Salle obj) {
		return em.merge(obj);
	}

	public void delete(Salle obj) {
		em.remove(em.merge(obj));
	}
}