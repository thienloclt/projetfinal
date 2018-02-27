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

import monprojet.factory.dao.StagiaireDao;
import monprojet.factory.entity.Stagiaire;


@CrossOrigin
@RestController
@RequestMapping("/api/stagiaire")
public class StagiaireRestController {

	@Autowired
	StagiaireDao stagiaireDao;

	@GetMapping("")
	//@JsonView(View.StagiaireWithCentreEquestre.class)
	public ResponseEntity<List<Stagiaire>> findAll() {
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.StagiaireWithCentreEquestre.class)
	public ResponseEntity<Stagiaire> findById(@PathVariable("id") Long id) {
		Stagiaire stagiaire = stagiaireDao.find(id);
		return new ResponseEntity<Stagiaire>(stagiaire, (stagiaire != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.StagiaireWithCentreEquestre.class)
	public ResponseEntity<Stagiaire> deleteStagiaire(@PathVariable("id") Long id) {
		Stagiaire stagiaire = stagiaireDao.find(id);
		if (stagiaire == null)
			return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.NOT_FOUND);

		stagiaireDao.delete(stagiaire);
		return new ResponseEntity<Stagiaire>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.StagiaireWithCentreEquestre.class)
	public ResponseEntity<Stagiaire> createStagiaire(@RequestBody Stagiaire stagiaire) {
		if(stagiaire.getId() != null)
			return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.BAD_REQUEST);
		stagiaireDao.create(stagiaire);
		return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.StagiaireWithCentreEquestre.class)
	public ResponseEntity<Stagiaire> updateStagiaire(@RequestBody Stagiaire stagiaire) {
		Stagiaire stagiaireFind = stagiaireDao.find(stagiaire.getId());
		if (stagiaireFind != null) {
			stagiaireDao.update(stagiaire);
			return new ResponseEntity<Stagiaire>(stagiaireFind, HttpStatus.OK);
		}
		return new ResponseEntity<Stagiaire>(stagiaireFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}