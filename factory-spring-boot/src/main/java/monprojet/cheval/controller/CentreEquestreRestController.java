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

import monprojet.cheval.dao.CentreEquestreDao;
import monprojet.cheval.model.CentreEquestre;
import monprojet.framework.model.View;

@CrossOrigin
@RestController
@RequestMapping("/api/centreequestre")
public class CentreEquestreRestController {

	@Autowired
	CentreEquestreDao centreEquestreDao;

	@GetMapping("")
	@JsonView(View.CentreEquestreWithCheval.class)
	public ResponseEntity<List<CentreEquestre>> findAll() {
		List<CentreEquestre> centreEquestres = centreEquestreDao.findAll();
		return new ResponseEntity<List<CentreEquestre>>(centreEquestres, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.CentreEquestreWithCheval.class)
	public ResponseEntity<CentreEquestre> findById(@PathVariable("id") Long id) {
		CentreEquestre centreEquestre = centreEquestreDao.find(id);
		return new ResponseEntity<CentreEquestre>(centreEquestre, (centreEquestre != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.CentreEquestreWithCheval.class)
	public ResponseEntity<CentreEquestre> deleteCentreEquestre(@PathVariable("id") Long id) {
		CentreEquestre centreEquestre = centreEquestreDao.find(id);
		if (centreEquestre == null)
			return new ResponseEntity<CentreEquestre>(centreEquestre, HttpStatus.NOT_FOUND);

		centreEquestreDao.delete(centreEquestre);
		return new ResponseEntity<CentreEquestre>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("")
	@JsonView(View.CentreEquestreWithCheval.class)
	public ResponseEntity<CentreEquestre> createCentreEquestre(@RequestBody CentreEquestre centreEquestre) {
		if (centreEquestre.getId() != null)
			return new ResponseEntity<CentreEquestre>(centreEquestre, HttpStatus.BAD_REQUEST);
		centreEquestreDao.create(centreEquestre);
		return new ResponseEntity<CentreEquestre>(centreEquestre, HttpStatus.CREATED);
	}

	@PutMapping("")
	@JsonView(View.CentreEquestreWithCheval.class)
	public ResponseEntity<CentreEquestre> updateCentreEquestre(@RequestBody CentreEquestre centreEquestre) {
		CentreEquestre centreEquestreFind = centreEquestreDao.find(centreEquestre.getId());
		if (centreEquestreFind != null) {
			centreEquestreDao.update(centreEquestre);
			return new ResponseEntity<CentreEquestre>(centreEquestreFind, HttpStatus.OK);
		}
		return new ResponseEntity<CentreEquestre>(centreEquestreFind, HttpStatus.BAD_REQUEST);
	}
}