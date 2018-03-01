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

import monprojet.factory.dao.EnseignementDao;
import monprojet.factory.entity.Enseignement;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/enseignement")
public class EnseignementRestController {

	@Autowired
	EnseignementDao enseignementDao;

	@GetMapping("")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<List<Enseignement>> findAll() {
		List<Enseignement> enseignements = enseignementDao.findAll();
		return new ResponseEntity<List<Enseignement>>(enseignements, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> findById(@PathVariable("id") int id) {
		Enseignement enseignement = enseignementDao.find(id);
		return new ResponseEntity<Enseignement>(enseignement, (enseignement != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> deleteEnseignement(@PathVariable("id") int id) {
		Enseignement enseignement = enseignementDao.find(id);
		if (enseignement == null)
			return new ResponseEntity<Enseignement>(enseignement, HttpStatus.NOT_FOUND);

		enseignementDao.delete(enseignement);
		return new ResponseEntity<Enseignement>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> createEnseignement(@RequestBody Enseignement enseignement) {
		if(enseignement.getId() != null)
			return new ResponseEntity<Enseignement>(enseignement, HttpStatus.BAD_REQUEST);
		enseignementDao.create(enseignement);
		return new ResponseEntity<Enseignement>(enseignement, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> updateEnseignement(@RequestBody Enseignement enseignement) {
		Enseignement enseignementFind = enseignementDao.find(enseignement.getId());
		if (enseignementFind != null) {
			enseignementDao.update(enseignement);
			return new ResponseEntity<Enseignement>(enseignementFind, HttpStatus.OK);
		}
		return new ResponseEntity<Enseignement>(enseignementFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}