package monprojet.cheval.controller;

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

import monprojet.cheval.dao.ChevalDao;
import monprojet.cheval.model.Cheval;
import monprojet.framework.model.View;

@CrossOrigin
@RestController
@RequestMapping("/api/cheval")
public class ChevalRestController {

	@Autowired
	ChevalDao chevalDao;

	@GetMapping("")
	@JsonView(View.ChevalWithCentreEquestre.class)
	public ResponseEntity<List<Cheval>> findAll() {
		List<Cheval> chevals = chevalDao.findAll();
		return new ResponseEntity<List<Cheval>>(chevals, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.ChevalWithCentreEquestre.class)
	public ResponseEntity<Cheval> findById(@PathVariable("id") Long id) {
		Cheval cheval = chevalDao.find(id);
		return new ResponseEntity<Cheval>(cheval, (cheval != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.ChevalWithCentreEquestre.class)
	public ResponseEntity<Cheval> deleteCheval(@PathVariable("id") Long id) {
		Cheval cheval = chevalDao.find(id);
		if (cheval == null)
			return new ResponseEntity<Cheval>(cheval, HttpStatus.NOT_FOUND);

		chevalDao.delete(cheval);
		return new ResponseEntity<Cheval>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.ChevalWithCentreEquestre.class)
	public ResponseEntity<Cheval> createCheval(@RequestBody Cheval cheval) {
		if(cheval.getId() != null)
			return new ResponseEntity<Cheval>(cheval, HttpStatus.BAD_REQUEST);
		chevalDao.create(cheval);
		return new ResponseEntity<Cheval>(cheval, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.ChevalWithCentreEquestre.class)
	public ResponseEntity<Cheval> updateCheval(@RequestBody Cheval cheval) {
		Cheval chevalFind = chevalDao.find(cheval.getId());
		if (chevalFind != null) {
			chevalDao.update(cheval);
			return new ResponseEntity<Cheval>(chevalFind, HttpStatus.OK);
		}
		return new ResponseEntity<Cheval>(chevalFind, HttpStatus.BAD_REQUEST);
	}
}