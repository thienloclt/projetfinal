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

import monprojet.factory.dao.TechnicienDao;
import monprojet.factory.entity.Technicien;


@CrossOrigin
@RestController
@RequestMapping("/api/technicien")
public class TechnicienRestController {

	@Autowired
	TechnicienDao technicienDao;

	@GetMapping("")
	//@JsonView(View.TechnicienWithCentreEquestre.class)
	public ResponseEntity<List<Technicien>> findAll() {
		List<Technicien> techniciens = technicienDao.findAll();
		return new ResponseEntity<List<Technicien>>(techniciens, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.TechnicienWithCentreEquestre.class)
	public ResponseEntity<Technicien> findById(@PathVariable("id") Long id) {
		Technicien technicien = technicienDao.find(id);
		return new ResponseEntity<Technicien>(technicien, (technicien != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.TechnicienWithCentreEquestre.class)
	public ResponseEntity<Technicien> deleteTechnicien(@PathVariable("id") Long id) {
		Technicien technicien = technicienDao.find(id);
		if (technicien == null)
			return new ResponseEntity<Technicien>(technicien, HttpStatus.NOT_FOUND);

		technicienDao.delete(technicien);
		return new ResponseEntity<Technicien>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.TechnicienWithCentreEquestre.class)
	public ResponseEntity<Technicien> createTechnicien(@RequestBody Technicien technicien) {
		if(technicien.getId() != null)
			return new ResponseEntity<Technicien>(technicien, HttpStatus.BAD_REQUEST);
		technicienDao.create(technicien);
		return new ResponseEntity<Technicien>(technicien, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.TechnicienWithCentreEquestre.class)
	public ResponseEntity<Technicien> updateTechnicien(@RequestBody Technicien technicien) {
		Technicien technicienFind = technicienDao.find(technicien.getId());
		if (technicienFind != null) {
			technicienDao.update(technicien);
			return new ResponseEntity<Technicien>(technicienFind, HttpStatus.OK);
		}
		return new ResponseEntity<Technicien>(technicienFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}