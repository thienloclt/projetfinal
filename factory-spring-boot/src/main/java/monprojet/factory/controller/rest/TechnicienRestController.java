package monprojet.factory.controller.rest;

import java.text.SimpleDateFormat;
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

import monprojet.factory.dao.TechnicienDao;
import monprojet.factory.entity.Technicien;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/technicien")
public class TechnicienRestController {

	@Autowired
	TechnicienDao technicienDao;

	@GetMapping("")
	public ResponseEntity<List<Technicien>> findAll() {
		List<Technicien> techniciens = technicienDao.findAll();
		return new ResponseEntity<List<Technicien>>(techniciens, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Technicien>> test() {
		try {
			Technicien stagiaire1 = new Technicien("nom", "prenom", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1986"), "adresse", "email@gmail.ocm", "numTel");
			Technicien stagiaire2 = new Technicien("nom", "prenom", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1986"), "adresse", "email@gmail.ocm", "numTel");
			Technicien stagiaire3 = new Technicien("nom", "prenom", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1986"), "adresse", "email@gmail.ocm", "numTel");
			Technicien stagiaire4 = new Technicien("nom", "prenom", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1986"), "adresse", "email@gmail.ocm", "numTel");
			technicienDao.create(stagiaire1);
			technicienDao.create(stagiaire2);
			technicienDao.create(stagiaire3);
			technicienDao.create(stagiaire4);
		}
		catch (Exception e) {
		}
		List<Technicien> stagiaires = technicienDao.findAll();
		return new ResponseEntity<List<Technicien>>(stagiaires, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Technicien> findById(@PathVariable("id") int id) {
		Technicien technicien = technicienDao.find(id);
		return new ResponseEntity<Technicien>(technicien, (technicien != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Technicien> deleteTechnicien(@PathVariable("id") int id) {
		Technicien technicien = technicienDao.find(id);
		if (technicien == null)
			return new ResponseEntity<Technicien>(technicien, HttpStatus.NOT_FOUND);

		technicienDao.delete(technicien);
		return new ResponseEntity<Technicien>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	public ResponseEntity<Technicien> createTechnicien(@RequestBody Technicien technicien) {
		if(technicien.getId() != null)
			return new ResponseEntity<Technicien>(technicien, HttpStatus.BAD_REQUEST);
		technicienDao.create(technicien);
		return new ResponseEntity<Technicien>(technicien, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<Technicien> updateTechnicien(@RequestBody Technicien technicien) {
		Technicien technicienFind = technicienDao.find(technicien.getId());
		if (technicienFind != null) {
			technicien.setVersion(technicienFind.getVersion());
			technicienDao.update(technicien);
			return new ResponseEntity<Technicien>(technicienFind, HttpStatus.OK);
		}
		return new ResponseEntity<Technicien>(technicienFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}