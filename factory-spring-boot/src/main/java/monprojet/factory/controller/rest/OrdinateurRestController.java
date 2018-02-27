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

import monprojet.factory.dao.OrdinateurDao;
import monprojet.factory.entity.Ordinateur;


@CrossOrigin
@RestController
@RequestMapping("/api/ordinateur")
public class OrdinateurRestController {

	@Autowired
	OrdinateurDao ordinateurDao;

	@GetMapping("")
	//@JsonView(View.OrdinateurWithCentreEquestre.class)
	public ResponseEntity<List<Ordinateur>> findAll() {
		List<Ordinateur> ordinateurs = ordinateurDao.findAll();
		return new ResponseEntity<List<Ordinateur>>(ordinateurs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.OrdinateurWithCentreEquestre.class)
	public ResponseEntity<Ordinateur> findById(@PathVariable("id") Long id) {
		Ordinateur ordinateur = ordinateurDao.find(id);
		return new ResponseEntity<Ordinateur>(ordinateur, (ordinateur != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.OrdinateurWithCentreEquestre.class)
	public ResponseEntity<Ordinateur> deleteOrdinateur(@PathVariable("id") Long id) {
		Ordinateur ordinateur = ordinateurDao.find(id);
		if (ordinateur == null)
			return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.NOT_FOUND);

		ordinateurDao.delete(ordinateur);
		return new ResponseEntity<Ordinateur>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.OrdinateurWithCentreEquestre.class)
	public ResponseEntity<Ordinateur> createOrdinateur(@RequestBody Ordinateur ordinateur) {
		if(ordinateur.getId() != null)
			return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.BAD_REQUEST);
		ordinateurDao.create(ordinateur);
		return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.OrdinateurWithCentreEquestre.class)
	public ResponseEntity<Ordinateur> updateOrdinateur(@RequestBody Ordinateur ordinateur) {
		Ordinateur ordinateurFind = ordinateurDao.find(ordinateur.getId());
		if (ordinateurFind != null) {
			ordinateurDao.update(ordinateur);
			return new ResponseEntity<Ordinateur>(ordinateurFind, HttpStatus.OK);
		}
		return new ResponseEntity<Ordinateur>(ordinateurFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}