package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.EnseignementDao;
import monprojet.factory.entity.Enseignement;

@Transactional
@Repository
public class EnseignementDaoJpa implements EnseignementDao {

	@PersistenceContext
	private EntityManager em;

	public Enseignement find(Integer id) {
		return em.find(Enseignement.class, id);
	}

	public void create(Enseignement obj) {
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<Enseignement> findByMatiereAndOutOfFormation(Integer matiere_id, Integer formation_id) {
		List<Enseignement> list = null;

		
		String sFormateurHasFormation = "(SELECT p.formateur FROM Programme p, Formation f WHERE (p.formation = f) AND (f.id <> :formation_id) AND EXISTS (SELECT f1.id FROM Formation f1 WHERE f1.id = :formation_id AND ((f.dateDebut BETWEEN f1.dateDebut AND f1.dateFin) OR (f.dateFin BETWEEN f1.dateDebut AND f1.dateFin))))";
		Query query = em.createQuery("SELECT e FROM Formateur ft, Enseignement e, Matiere m WHERE (e.formateur = ft) AND (e.matiere = m) AND (m.id = :matiere_id) AND ft NOT IN" + sFormateurHasFormation);
		query.setParameter("matiere_id", matiere_id);
		query.setParameter("formation_id", formation_id);

		list = query.getResultList();	

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Enseignement> findAll() {
		List<Enseignement> list = null;

		Query query = em.createQuery("from Enseignement");
		list = query.getResultList();

		return list;
	}

	public Enseignement update(Enseignement obj) {
		return em.merge(obj);
	}

	public void delete(Enseignement obj) {
		em.remove(em.merge(obj));
	}
}