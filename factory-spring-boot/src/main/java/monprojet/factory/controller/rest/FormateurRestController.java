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

import monprojet.factory.dao.FormateurDao;
import monprojet.factory.entity.Formateur;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/formateur")
public class FormateurRestController {

	@Autowired
	FormateurDao formateurDao;

	@GetMapping("")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<List<Formateur>> findAll() {
		List<Formateur> formateurs = formateurDao.findAll();
		return new ResponseEntity<List<Formateur>>(formateurs, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<List<Formateur>> test() {
		try {
			Formateur formateur1 = new Formateur("LHOMME", "Thomas", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1985"), "adresse", "email@gmail.com", "numTel", "competence", "Formateur JEE");
			Formateur formateur2 = new Formateur("SULTAN", "Eric", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1978"), "adresse", "email@gmail.com", "numTel", "competence", "Formateur JEE");
			Formateur formateur3 = new Formateur("GOZLAN", "Olivier", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1975"), "adresse", "email@gmail.com", "numTel", "competence", "Formateur JEE");
			Formateur formateur4 = new Formateur("RAZON", "Didier", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-1956"), "adresse", "email@gmail.com", "numTel", "competence", "Coach Management");
			formateurDao.create(formateur1);
			formateurDao.create(formateur2);
			formateurDao.create(formateur3);
			formateurDao.create(formateur4);
		}
		catch (Exception e) {
		}
		List<Formateur> formateurs = formateurDao.findAll();
		return new ResponseEntity<List<Formateur>>(formateurs, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<Formateur> findById(@PathVariable("id") int id) {
		Formateur formateur = formateurDao.find(id);
		return new ResponseEntity<Formateur>(formateur, (formateur != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<Formateur> deleteFormateur(@PathVariable("id") int id) {
		Formateur formateur = formateurDao.find(id);
		if (formateur == null)
			return new ResponseEntity<Formateur>(formateur, HttpStatus.NOT_FOUND);

		formateurDao.delete(formateur);
		return new ResponseEntity<Formateur>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
		if(formateur.getId() != null)
			return new ResponseEntity<Formateur>(formateur, HttpStatus.BAD_REQUEST);
		formateurDao.create(formateur);
		return new ResponseEntity<Formateur>(formateur, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<Formateur> updateFormateur(@RequestBody Formateur formateur) {
		Formateur formateurFind = formateurDao.find(formateur.getId());
		if (formateurFind != null) {
			formateur.setVersion(formateurFind.getVersion());
			formateurDao.update(formateur);
			return new ResponseEntity<Formateur>(formateurFind, HttpStatus.OK);
		}
		return new ResponseEntity<Formateur>(formateurFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}