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

	public Projecteur find(Integer id) {
		return em.find(Projecteur.class, id);
	}

	public void create(Projecteur obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Projecteur> findByOutOfFormation(Integer formation_id) {
		List<Projecteur> list = null;

		String sProjecteurHasFormation = "(SELECT p1.id FROM Projecteur p1, Formation f "
				+ "WHERE (f.projecteur = p1) AND (f.id <> :formation_id) AND EXISTS "
				+ "(SELECT fviewing.id FROM Formation fviewing WHERE fviewing.id = :formation_id AND "
				+ "((f.dateDebut BETWEEN fviewing.dateDebut AND fviewing.dateFin) "
				+ "OR (f.dateFin BETWEEN fviewing.dateDebut AND fviewing.dateFin) "
				+ "OR (f.dateDebut < fviewing.dateDebut AND f.dateFin > fviewing.dateFin)"
				+ ")))";
		
		Query query = em.createQuery("SELECT p FROM Projecteur p WHERE p.id NOT IN " + sProjecteurHasFormation);

		query.setParameter("formation_id", formation_id);
		list = query.getResultList();

		return list;
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