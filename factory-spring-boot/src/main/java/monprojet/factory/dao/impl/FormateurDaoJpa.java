package monprojet.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.factory.dao.FormateurDao;
import monprojet.factory.entity.Formateur;

@Transactional
@Repository
public class FormateurDaoJpa implements FormateurDao {

	@PersistenceContext
	private EntityManager em;

	public Formateur find(Integer id) {
		return em.find(Formateur.class, id);
	}

	public void create(Formateur obj) {
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<Formateur> findByMatiereAndOutOfFormation(Integer matiere_id, Integer formation_id) {
		List<Formateur> list = null;

		
		String sFormateurHasFormation = "(SELECT p.formateur FROM Programme p, Formation f WHERE (p.formation = f) AND (f.id <> :formation_id) AND EXISTS (SELECT f1.id FROM Formation f1 WHERE f1.id = :formation_id AND ((f.dateDebut BETWEEN f1.dateDebut AND f1.dateFin) OR (f.dateFin BETWEEN f1.dateDebut AND f1.dateFin))))";
		Query query = em.createQuery("SELECT ft FROM Formateur ft, Enseignement e, Matiere m WHERE (e.formateur = ft) AND (e.matiere = m) AND (m.id = :matiere_id) AND ft NOT IN" + sFormateurHasFormation);
		query.setParameter("matiere_id", matiere_id);
		query.setParameter("formation_id", formation_id);

		list = query.getResultList();	

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Formateur> findAll() {
		List<Formateur> list = null;

		Query query = em.createQuery("from Formateur");
		list = query.getResultList();

		return list;
	}

	public Formateur update(Formateur obj) {
		return em.merge(obj);
	}

	public void delete(Formateur obj) {
		em.remove(em.merge(obj));
	}
}