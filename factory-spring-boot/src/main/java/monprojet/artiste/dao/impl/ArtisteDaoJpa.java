package monprojet.artiste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.artiste.dao.ArtisteDao;
import monprojet.artiste.entity.Artiste;

@Transactional
@Repository
public class ArtisteDaoJpa implements ArtisteDao {

	@PersistenceContext
	private EntityManager em;

	public Artiste find(String nom) {
		return em.find(Artiste.class, nom);
	}

	public void create(Artiste obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Artiste> findAll() {
		List<Artiste> list = null;

		Query query = em.createQuery("from Artiste");
		list = query.getResultList();

		return list;
	}

	public Artiste update(Artiste obj) {
		return em.merge(obj);
	}

	public void delete(Artiste obj) {
		em.remove(em.merge(obj));
	}
}