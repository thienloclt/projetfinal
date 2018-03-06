package monprojet.factory.controller.rest;

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

import monprojet.factory.dao.GestionnaireDao;
import monprojet.factory.entity.Gestionnaire;
import monprojet.framework.model.View;

@CrossOrigin
@RestController
@RequestMapping("/api/gestionnaire")
public class GestionnaireRestController {

	@Autowired
	GestionnaireDao gestionnaireDao;

	@GetMapping("")
	@JsonView(View.GestionnaireWithEveythingJSON.class)
	public ResponseEntity<List<Gestionnaire>> findAll() {
		List<Gestionnaire> gestionnaires = gestionnaireDao.findAll();
		return new ResponseEntity<List<Gestionnaire>>(gestionnaires, HttpStatus.OK);
	}

	@GetMapping("/test")
	@JsonView(View.GestionnaireWithEveythingJSON.class)
	public ResponseEntity<List<Gestionnaire>> test() {
		Gestionnaire gestionnaire1 = new Gestionnaire();
		gestionnaire1.setNom("gestionnaire1");
		gestionnaire1.setPrenom("gestionnaire1");
		Gestionnaire gestionnaire2 = new Gestionnaire();
		gestionnaire2.setNom("gestionnaire2");
		gestionnaire2.setPrenom("gestionnaire2");
		Gestionnaire gestionnaire3 = new Gestionnaire();
		gestionnaire3.setNom("gestionnaire3");
		gestionnaire3.setPrenom("gestionnaire3");
		Gestionnaire gestionnaire4 = new Gestionnaire();
		gestionnaire4.setNom("gestionnaire4");
		gestionnaire4.setPrenom("gestionnaire4");
		gestionnaireDao.create(gestionnaire1);
		gestionnaireDao.create(gestionnaire2);
		gestionnaireDao.create(gestionnaire3);
		gestionnaireDao.create(gestionnaire4);
		List<Gestionnaire> gestionnaires = gestionnaireDao.findAll();
		return new ResponseEntity<List<Gestionnaire>>(gestionnaires, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@JsonView(View.GestionnaireWithEveythingJSON.class)
	public ResponseEntity<Gestionnaire> findById(@PathVariable("id") int id) {
		Gestionnaire gestionnaire = gestionnaireDao.find(id);
		return new ResponseEntity<Gestionnaire>(gestionnaire, (gestionnaire != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.GestionnaireWithEveythingJSON.class)
	public ResponseEntity<Gestionnaire> deleteGestionnaire(@PathVariable("id") int id) {
		Gestionnaire gestionnaire = gestionnaireDao.find(id);
		if (gestionnaire == null)
			return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.NOT_FOUND);

		gestionnaireDao.delete(gestionnaire);
		return new ResponseEntity<Gestionnaire>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.GestionnaireWithEveythingJSON.class)
	public ResponseEntity<Gestionnaire> createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		if(gestionnaire.getId() != null)
			return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.BAD_REQUEST);
		gestionnaireDao.create(gestionnaire);
		return new ResponseEntity<Gestionnaire>(gestionnaire, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.GestionnaireWithEveythingJSON.class)
	public ResponseEntity<Gestionnaire> updateGestionnaire(@RequestBody Gestionnaire gestionnaire) {
		Gestionnaire gestionnaireFind = gestionnaireDao.find(gestionnaire.getId());
		if (gestionnaireFind != null) {
			gestionnaire.setVersion(gestionnaireFind.getVersion());
			gestionnaireDao.update(gestionnaire);
			return new ResponseEntity<Gestionnaire>(gestionnaireFind, HttpStatus.OK);
		}
		return new ResponseEntity<Gestionnaire>(gestionnaireFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}