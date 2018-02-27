package monprojet.cheval.controller;

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

import monprojet.cheval.dao.RegistreDao;
import monprojet.cheval.model.Registre;

@RestController
@RequestMapping("/registreapi")
public class RegistreRestController {

	@Autowired
	RegistreDao registreDao;

	@GetMapping("")
	public ResponseEntity<List<Registre>> findAll() {
		List<Registre> registres = registreDao.findAll();
		return new ResponseEntity<List<Registre>>(registres, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Registre> findById(@PathVariable("id") Long id) {
		Registre registre = registreDao.find(id);
		return new ResponseEntity<Registre>(registre, (registre != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Registre> deleteRegistre(@PathVariable("id") Long id) {
		Registre registre = registreDao.find(id);
		if (registre == null)
			return new ResponseEntity<Registre>(registre, HttpStatus.NOT_FOUND);

		registreDao.delete(registre);
		return new ResponseEntity<Registre>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	public ResponseEntity<Registre> createRegistre(@RequestBody Registre registre) {
		if(registre.getId() != null)
			return new ResponseEntity<Registre>(registre, HttpStatus.BAD_REQUEST);
		registreDao.create(registre);
		return new ResponseEntity<Registre>(registre, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<Registre> updateRegistre(@RequestBody Registre registre) {
		Registre registreFind = registreDao.find(registre.getId());
		if (registreFind != null) {
			registreDao.update(registre);
			return new ResponseEntity<Registre>(registreFind, HttpStatus.OK);
		}
		return new ResponseEntity<Registre>(registreFind, HttpStatus.BAD_REQUEST);
	}
}