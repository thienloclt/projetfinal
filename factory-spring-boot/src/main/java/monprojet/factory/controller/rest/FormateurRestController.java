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

	@GetMapping("/{id}")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<Formateur> findById(@PathVariable("id") Long id) {
		Formateur formateur = formateurDao.find(id);
		return new ResponseEntity<Formateur>(formateur, (formateur != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.FormateurWithEveythingJSON.class)
	public ResponseEntity<Formateur> deleteFormateur(@PathVariable("id") Long id) {
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
			formateurDao.update(formateur);
			return new ResponseEntity<Formateur>(formateurFind, HttpStatus.OK);
		}
		return new ResponseEntity<Formateur>(formateurFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}