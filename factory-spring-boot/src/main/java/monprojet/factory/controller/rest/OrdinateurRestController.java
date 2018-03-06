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

import monprojet.factory.dao.OrdinateurDao;
import monprojet.factory.entity.Ordinateur;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/ordinateur")
public class OrdinateurRestController {

	@Autowired
	OrdinateurDao ordinateurDao;

	@GetMapping("")
	@JsonView(View.OrdinateurWithEveythingJSON.class)
	public ResponseEntity<List<Ordinateur>> findAll() {
		List<Ordinateur> ordinateurs = ordinateurDao.findAll();
		return new ResponseEntity<List<Ordinateur>>(ordinateurs, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@JsonView(View.OrdinateurWithEveythingJSON.class)
	public ResponseEntity<List<Ordinateur>> test() {
		Ordinateur ordinateur1 = new Ordinateur("ord1", "Ordinateur1", 10);
		Ordinateur ordinateur2 = new Ordinateur("ord2", "Ordinateur2", 20);
		Ordinateur ordinateur3 = new Ordinateur("ord3", "Ordinateur3", 30);
		Ordinateur ordinateur4 = new Ordinateur("ord4", "Ordinateur4", 40);
		ordinateurDao.create(ordinateur1);
		ordinateurDao.create(ordinateur2);
		ordinateurDao.create(ordinateur3);
		ordinateurDao.create(ordinateur4);
		List<Ordinateur> projecteurs = ordinateurDao.findAll();
		return new ResponseEntity<List<Ordinateur>>(projecteurs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.OrdinateurWithEveythingJSON.class)
	public ResponseEntity<Ordinateur> findById(@PathVariable("id") int id) {
		Ordinateur ordinateur = ordinateurDao.find(id);
		return new ResponseEntity<Ordinateur>(ordinateur, (ordinateur != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.OrdinateurWithEveythingJSON.class)
	public ResponseEntity<Ordinateur> deleteOrdinateur(@PathVariable("id") int id) {
		Ordinateur ordinateur = ordinateurDao.find(id);
		if (ordinateur == null)
			return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.NOT_FOUND);

		ordinateurDao.delete(ordinateur);
		return new ResponseEntity<Ordinateur>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.OrdinateurWithEveythingJSON.class)
	public ResponseEntity<Ordinateur> createOrdinateur(@RequestBody Ordinateur ordinateur) {
		if(ordinateur.getId() != null)
			return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.BAD_REQUEST);
		ordinateurDao.create(ordinateur);
		return new ResponseEntity<Ordinateur>(ordinateur, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.OrdinateurWithEveythingJSON.class)
	public ResponseEntity<Ordinateur> updateOrdinateur(@RequestBody Ordinateur ordinateur) {
		Ordinateur ordinateurFind = ordinateurDao.find(ordinateur.getId());
		if (ordinateurFind != null) {
			ordinateur.setVersion(ordinateurFind.getVersion());
			ordinateurDao.update(ordinateur);
			return new ResponseEntity<Ordinateur>(ordinateurFind, HttpStatus.OK);
		}
		return new ResponseEntity<Ordinateur>(ordinateurFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}