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

import monprojet.factory.dao.MatiereDao;
import monprojet.factory.entity.Matiere;

@CrossOrigin
@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {

	@Autowired
	MatiereDao matiereDao;

	@GetMapping("")
	//@JsonView(View.MatiereWithCentreEquestre.class)
	public ResponseEntity<List<Matiere>> findAll() {
		List<Matiere> matieres = matiereDao.findAll();
		return new ResponseEntity<List<Matiere>>(matieres, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.MatiereWithCentreEquestre.class)
	public ResponseEntity<Matiere> findById(@PathVariable("id") Long id) {
		Matiere matiere = matiereDao.find(id);
		return new ResponseEntity<Matiere>(matiere, (matiere != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.MatiereWithCentreEquestre.class)
	public ResponseEntity<Matiere> deleteMatiere(@PathVariable("id") Long id) {
		Matiere matiere = matiereDao.find(id);
		if (matiere == null)
			return new ResponseEntity<Matiere>(matiere, HttpStatus.NOT_FOUND);

		matiereDao.delete(matiere);
		return new ResponseEntity<Matiere>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.MatiereWithCentreEquestre.class)
	public ResponseEntity<Matiere> createMatiere(@RequestBody Matiere matiere) {
		if(matiere.getId() != null)
			return new ResponseEntity<Matiere>(matiere, HttpStatus.BAD_REQUEST);
		matiereDao.create(matiere);
		return new ResponseEntity<Matiere>(matiere, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.MatiereWithCentreEquestre.class)
	public ResponseEntity<Matiere> updateMatiere(@RequestBody Matiere matiere) {
		Matiere matiereFind = matiereDao.find(matiere.getId());
		if (matiereFind != null) {
			matiereDao.update(matiere);
			return new ResponseEntity<Matiere>(matiereFind, HttpStatus.OK);
		}
		return new ResponseEntity<Matiere>(matiereFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}