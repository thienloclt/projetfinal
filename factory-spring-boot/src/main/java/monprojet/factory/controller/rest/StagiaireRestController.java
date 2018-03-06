package monprojet.factory.controller.rest;

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

import monprojet.factory.dao.StagiaireDao;
import monprojet.factory.entity.Stagiaire;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/stagiaire")
public class StagiaireRestController {

	@Autowired
	StagiaireDao stagiaireDao;

	@GetMapping("")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Stagiaire>> findAll() {
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
	}

	@GetMapping("/test")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Stagiaire>> test() {
		Stagiaire stagiaire1 = new Stagiaire();
		stagiaire1.setNom("stagiaire1");
		stagiaire1.setPrenom("stagiaire1");
		Stagiaire stagiaire2 = new Stagiaire();
		stagiaire2.setNom("stagiaire2");
		stagiaire2.setPrenom("stagiaire2");
		Stagiaire stagiaire3 = new Stagiaire();
		stagiaire3.setNom("stagiaire3");
		stagiaire3.setPrenom("stagiaire3");
		Stagiaire stagiaire4 = new Stagiaire();
		stagiaire4.setNom("stagiaire4");
		stagiaire4.setPrenom("stagiaire4");
		stagiaireDao.create(stagiaire1);
		stagiaireDao.create(stagiaire2);
		stagiaireDao.create(stagiaire3);
		stagiaireDao.create(stagiaire4);
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<Stagiaire> findById(@PathVariable("id") int id) {
		Stagiaire stagiaire = stagiaireDao.find(id);
		return new ResponseEntity<Stagiaire>(stagiaire, (stagiaire != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/outofformation/{id}")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Stagiaire>> findByOutOfFormation(@PathVariable("id") int id) {
		List<Stagiaire> stagiaires = stagiaireDao.findByOutOfFormation(id);
		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
	}
	
	@GetMapping("/formation/{id}")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Stagiaire>> findByFormation(@PathVariable("id") int id) {
		List<Stagiaire> stagiaires = stagiaireDao.findByFormation(id);
		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<Stagiaire> deleteStagiaire(@PathVariable("id") int id) {
		Stagiaire stagiaire = stagiaireDao.find(id);
		if (stagiaire == null)
			return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.NOT_FOUND);

		stagiaireDao.delete(stagiaire);
		return new ResponseEntity<Stagiaire>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<Stagiaire> createStagiaire(@RequestBody Stagiaire stagiaire) {
		if(stagiaire.getId() != null)
			return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.BAD_REQUEST);
		stagiaireDao.create(stagiaire);
		return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<Stagiaire> updateStagiaire(@RequestBody Stagiaire stagiaire) {
		Stagiaire stagiaireFind = stagiaireDao.find(stagiaire.getId());
		if (stagiaireFind != null) {
			stagiaire.setVersion(stagiaireFind.getVersion());
			stagiaireDao.update(stagiaire);
			return new ResponseEntity<Stagiaire>(stagiaireFind, HttpStatus.OK);
		}
		return new ResponseEntity<Stagiaire>(stagiaireFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}