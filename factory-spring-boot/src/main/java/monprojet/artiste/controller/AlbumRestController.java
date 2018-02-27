package monprojet.artiste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.artiste.dao.AlbumDao;
import monprojet.artiste.entity.Album;
import monprojet.artiste.entity.View;

@RestController
@RequestMapping("/albumapi")
public class AlbumRestController {

	@Autowired
	AlbumDao albumDao;

	@GetMapping("")
	@JsonView(View.AlbumWithEverything.class)
	public ResponseEntity<List<Album>> findAll() {
		List<Album> albums = albumDao.findAll();
		return new ResponseEntity<List<Album>>(albums, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.AlbumWithEverything.class)
	public ResponseEntity<Album> findById(@PathVariable("id") Long id) {
		Album album = albumDao.find(id);
		return new ResponseEntity<Album>(album, (album != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Album> deleteAlbum(@PathVariable("id") Long id) {
		Album album = albumDao.find(id);
		if (album == null)
			return new ResponseEntity<Album>(album, HttpStatus.NOT_FOUND);

		albumDao.delete(album);
		return new ResponseEntity<Album>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.AlbumWithEverything.class)
	public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
		if(album.getId() != null)
			return new ResponseEntity<Album>(album, HttpStatus.BAD_REQUEST);
		albumDao.create(album);
		return new ResponseEntity<Album>(album, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.AlbumWithEverything.class)
	public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
		Album albumFind = albumDao.find(album.getId());
		if (albumFind != null) {
			albumDao.update(album);
			return new ResponseEntity<Album>(albumFind, HttpStatus.OK);
		}
		return new ResponseEntity<Album>(albumFind, HttpStatus.BAD_REQUEST);
	}
}