package monprojet.factory.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.factory.dao.SalleDao;
import monprojet.factory.entity.Salle;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/salle")
public class SalleRestController {

	@Autowired
	SalleDao salleDao;

	@GetMapping("")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<List<Salle>> findAll() {
		List<Salle> salles = salleDao.findAll();
		return new ResponseEntity<List<Salle>>(salles, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> findById(@PathVariable("id") Long id) {
		Salle salle = salleDao.find(id);
		return new ResponseEntity<Salle>(salle, (salle != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> deleteSalle(@PathVariable("id") Long id) {
		Salle salle = salleDao.find(id);
		if (salle == null)
			return new ResponseEntity<Salle>(salle, HttpStatus.NOT_FOUND);

		salleDao.delete(salle);
		return new ResponseEntity<Salle>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> createSalle(@RequestBody Salle salle) {
		if(salle.getId() != null)
			return new ResponseEntity<Salle>(salle, HttpStatus.BAD_REQUEST);
		salleDao.create(salle);
		return new ResponseEntity<Salle>(salle, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) {
		Salle salleFind = salleDao.find(salle.getId());
		if (salleFind != null) {
			salleDao.update(salle);
			return new ResponseEntity<Salle>(salleFind, HttpStatus.OK);
		}
		return new ResponseEntity<Salle>(salleFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}