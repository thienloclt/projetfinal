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

import monprojet.factory.dao.FormationDao;
import monprojet.factory.entity.Formation;

@CrossOrigin
@RestController
@RequestMapping("/api/formation")
public class FormationRestController {

	@Autowired
	FormationDao formationDao;

	@GetMapping("")
	//@JsonView(View.FormationWithCentreEquestre.class)
	public ResponseEntity<List<Formation>> findAll() {
		List<Formation> formations = formationDao.findAll();
		return new ResponseEntity<List<Formation>>(formations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.FormationWithCentreEquestre.class)
	public ResponseEntity<Formation> findById(@PathVariable("id") Long id) {
		Formation formation = formationDao.find(id);
		return new ResponseEntity<Formation>(formation, (formation != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.FormationWithCentreEquestre.class)
	public ResponseEntity<Formation> deleteFormation(@PathVariable("id") Long id) {
		Formation formation = formationDao.find(id);
		if (formation == null)
			return new ResponseEntity<Formation>(formation, HttpStatus.NOT_FOUND);

		formationDao.delete(formation);
		return new ResponseEntity<Formation>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.FormationWithCentreEquestre.class)
	public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
		if(formation.getId() != null)
			return new ResponseEntity<Formation>(formation, HttpStatus.BAD_REQUEST);
		formationDao.create(formation);
		return new ResponseEntity<Formation>(formation, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.FormationWithCentreEquestre.class)
	public ResponseEntity<Formation> updateFormation(@RequestBody Formation formation) {
		Formation formationFind = formationDao.find(formation.getId());
		if (formationFind != null) {
			formationDao.update(formation);
			return new ResponseEntity<Formation>(formationFind, HttpStatus.OK);
		}
		return new ResponseEntity<Formation>(formationFind, HttpStatus.BAD_REQUEST);
	}
}