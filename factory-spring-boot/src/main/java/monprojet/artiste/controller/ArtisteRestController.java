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

import monprojet.artiste.dao.ArtisteDao;
import monprojet.artiste.entity.Artiste;
import monprojet.artiste.entity.View;

@RestController
@RequestMapping("/artisteapi")
public class ArtisteRestController {

	@Autowired
	ArtisteDao artisteDao;

	@GetMapping("")
	@JsonView(View.ArtisteWithAlbum.class)
	public ResponseEntity<List<Artiste>> findAll() {
		List<Artiste> artistes = artisteDao.findAll();
		return new ResponseEntity<List<Artiste>>(artistes, HttpStatus.OK);
	}

	@GetMapping("/{nom}")
	@JsonView(View.ArtisteWithAlbum.class)
	public ResponseEntity<Artiste> findById(@PathVariable("nom") String nom) {
		Artiste artiste = artisteDao.find(nom);
		return new ResponseEntity<Artiste>(artiste, (artiste != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{nom}")
	public ResponseEntity<Artiste> deleteArtiste(@PathVariable("nom") String nom) {
		Artiste artiste = artisteDao.find(nom);
		if (artiste == null)
			return new ResponseEntity<Artiste>(artiste, HttpStatus.NOT_FOUND);

		artisteDao.delete(artiste);
		return new ResponseEntity<Artiste>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.ArtisteWithAlbum.class)
	public ResponseEntity<Artiste> createArtiste(@RequestBody Artiste artiste) {
		artisteDao.create(artiste);
		return new ResponseEntity<Artiste>(artiste, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.ArtisteWithAlbum.class)
	public ResponseEntity<Artiste> updateArtiste(@RequestBody Artiste artiste) {
		Artiste artisteFind = artisteDao.find(artiste.getNom_Artiste());
		if (artisteFind != null) {
			artisteDao.update(artiste);
			return new ResponseEntity<Artiste>(artisteFind, HttpStatus.OK);
		}
		return new ResponseEntity<Artiste>(artisteFind, HttpStatus.BAD_REQUEST);
	}
}