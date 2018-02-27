package monprojet.artiste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.artiste.dao.SacemDao;
import monprojet.artiste.entity.Sacem;
import monprojet.artiste.entity.View;

@CrossOrigin
@RestController
@RequestMapping("/sacemapi")
public class SacemRestController {

	@Autowired
	SacemDao sacemDao;

	@GetMapping("")
	@JsonView(View.SacemWithAlbum.class)
	public ResponseEntity<List<Sacem>> findAll() {
		List<Sacem> sacems = sacemDao.findAll();
		return new ResponseEntity<List<Sacem>>(sacems, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.SacemWithAlbum.class)
	public ResponseEntity<Sacem> findById(@PathVariable("id") String id) {
		Sacem sacem = sacemDao.find(id);
		return new ResponseEntity<Sacem>(sacem, (sacem != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Sacem> deleteSacem(@PathVariable("id") String id) {
		Sacem sacem = sacemDao.find(id);
		if (sacem == null)
			return new ResponseEntity<Sacem>(sacem, HttpStatus.NOT_FOUND);

		sacemDao.delete(sacem);
		return new ResponseEntity<Sacem>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.SacemWithAlbum.class)
	public ResponseEntity<Sacem> createSacem(@RequestBody Sacem sacem) {
		sacemDao.create(sacem);
		return new ResponseEntity<Sacem>(sacem, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.SacemWithAlbum.class)
	public ResponseEntity<Sacem> updateSacem(@RequestBody Sacem sacem) {
		Sacem sacemFind = sacemDao.find(sacem.getId());
		if (sacemFind != null) {
			sacemDao.update(sacem);
			return new ResponseEntity<Sacem>(sacemFind, HttpStatus.OK);
		}
		return new ResponseEntity<Sacem>(sacemFind, HttpStatus.BAD_REQUEST);
	}
}