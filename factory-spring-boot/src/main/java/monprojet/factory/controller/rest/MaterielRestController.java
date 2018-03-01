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

import monprojet.factory.dao.MaterielDao;
import monprojet.factory.entity.Materiel;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/materiel")
public class MaterielRestController {

	@Autowired
	MaterielDao materielDao;

	@GetMapping("")
	@JsonView(View.MaterielWithEveythingJSON.class)
	public ResponseEntity<List<Materiel>> findAll() {
		List<Materiel> materiels = materielDao.findAll();
		return new ResponseEntity<List<Materiel>>(materiels, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.MaterielWithEveythingJSON.class)
	public ResponseEntity<Materiel> findById(@PathVariable("id") int id) {
		Materiel materiel = materielDao.find(id);
		return new ResponseEntity<Materiel>(materiel, (materiel != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.MaterielWithEveythingJSON.class)
	public ResponseEntity<Materiel> deleteMateriel(@PathVariable("id") int id) {
		Materiel materiel = materielDao.find(id);
		if (materiel == null)
			return new ResponseEntity<Materiel>(materiel, HttpStatus.NOT_FOUND);

		materielDao.delete(materiel);
		return new ResponseEntity<Materiel>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.MaterielWithEveythingJSON.class)
	public ResponseEntity<Materiel> createMateriel(@RequestBody Materiel materiel) {
		if(materiel.getId() != null)
			return new ResponseEntity<Materiel>(materiel, HttpStatus.BAD_REQUEST);
		materielDao.create(materiel);
		return new ResponseEntity<Materiel>(materiel, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.MaterielWithEveythingJSON.class)
	public ResponseEntity<Materiel> updateMateriel(@RequestBody Materiel materiel) {
		Materiel materielFind = materielDao.find(materiel.getId());
		if (materielFind != null) {
			materielDao.update(materiel);
			return new ResponseEntity<Materiel>(materielFind, HttpStatus.OK);
		}
		return new ResponseEntity<Materiel>(materielFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}