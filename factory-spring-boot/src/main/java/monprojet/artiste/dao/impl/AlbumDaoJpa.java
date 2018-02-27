package monprojet.artiste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import monprojet.artiste.dao.AlbumDao;
import monprojet.artiste.entity.Album;

@Transactional
@Repository
public class AlbumDaoJpa implements AlbumDao {

	@PersistenceContext
	private EntityManager em;

	public Album find(Long id) {
		return em.find(Album.class, id);
	}

	public void create(Album obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Album> findAll() {
		List<Album> list = null;

		Query query = em.createQuery("from Album");
		list = query.getResultList();

		return list;
	}

	public Album update(Album obj) {
		return em.merge(obj);
	}

	public void delete(Album obj) {
		em.remove(em.merge(obj));
	}
}