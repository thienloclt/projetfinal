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

import monprojet.factory.dao.MatiereDao;
import monprojet.factory.entity.Matiere;
import monprojet.framework.model.View;

@CrossOrigin
@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {

	@Autowired
	MatiereDao matiereDao;

	@GetMapping("")
	@JsonView(View.MatiereWithEveythingJSON.class)
	public ResponseEntity<List<Matiere>> findAll() {
		List<Matiere> matieres = matiereDao.findAll();
		return new ResponseEntity<List<Matiere>>(matieres, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@JsonView(View.MatiereWithEveythingJSON.class)
	public ResponseEntity<List<Matiere>> test() {
		Matiere matiere1 = new Matiere("UML", "#ff0037", 2, "objectif1", "prerequis1", "contenu1");
		Matiere matiere2 = new Matiere("ALGO ET OBJET", "#fb00ff", 2, "objectif2", "prerequis2", "contenu2");
		Matiere matiere3 = new Matiere("INIT PROG JAVA", "#0055ff", 3, "objectif3", "prerequis3", "contenu3");
		Matiere matiere4 = new Matiere("POO JAVA", "#00ff80", 2, "objectif4", "prerequis4", "contenu4");
		Matiere matiere5 = new Matiere("HIBERNATE", "#44ff00", 3, "objectif5", "prerequis5", "contenu5");
		Matiere matiere6 = new Matiere("SPRING", "#ffaa00", 2, "objectif6", "prerequis6", "contenu6");
		Matiere matiere7 = new Matiere("SERVLET/JSP", "#ff33cc", 3, "objectif7", "prerequis7", "contenu7");
		Matiere matiere8 = new Matiere("JAVASCRIPT", "#990000", 2, "objectif8", "prerequis7", "contenu7");
		Matiere matiere9 = new Matiere("JSF", "#ff33cc", 3, "objectif9", "prerequis7", "contenu7");
		Matiere matiere10 = new Matiere("HTML", "#00ffcc", 2, "objectif", "prerequis", "contenu");
		Matiere matiere11 = new Matiere("CSS", "#ff33cc", 3, "objectif", "prerequis", "contenu");
		Matiere matiere12 = new Matiere("JQuery", "#006600", 2, "objectif", "prerequis", "contenu");
		Matiere matiere13 = new Matiere("Git", "#ff33cc", 1, "objectif", "prerequis", "contenu");
		Matiere matiere14 = new Matiere("SPRING Boot", "#ffff00", 2, "objectif", "prerequis", "contenu");
		Matiere matiere15 = new Matiere("Angular", "#ff33cc", 4, "objectif", "prerequis", "contenu");
		matiereDao.create(matiere1);
		matiereDao.create(matiere2);
		matiereDao.create(matiere3);
		matiereDao.create(matiere4);
		matiereDao.create(matiere5);
		matiereDao.create(matiere6);
		matiereDao.create(matiere7);
		matiereDao.create(matiere8);
		matiereDao.create(matiere9);
		matiereDao.create(matiere10);
		matiereDao.create(matiere11);
		matiereDao.create(matiere12);
		matiereDao.create(matiere13);
		matiereDao.create(matiere14);
		matiereDao.create(matiere15);
		
		List<Matiere> matieres = matiereDao.findAll();
		return new ResponseEntity<List<Matiere>>(matieres, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.MatiereWithEveythingJSON.class)
	public ResponseEntity<Matiere> findById(@PathVariable("id") int id) {
		Matiere matiere = matiereDao.find(id);
		return new ResponseEntity<Matiere>(matiere, (matiere != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/outofformation/{id}")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Matiere>> findByOutOfFormation(@PathVariable("id") int id) {
		List<Matiere> matieres = matiereDao.findByOutOfFormation(id);
		return new ResponseEntity<List<Matiere>>(matieres, HttpStatus.OK);
	}
	
	@GetMapping("/formation/{id}")
	@JsonView(View.StagiaireWithEveythingJSON.class)
	public ResponseEntity<List<Matiere>> findByFormation(@PathVariable("id") int id) {
		List<Matiere> matieres = matiereDao.findByFormation(id);
		return new ResponseEntity<List<Matiere>>(matieres, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(View.MatiereWithEveythingJSON.class)
	public ResponseEntity<Matiere> deleteMatiere(@PathVariable("id") int id) {
		Matiere matiere = matiereDao.find(id);
		if (matiere == null)
			return new ResponseEntity<Matiere>(matiere, HttpStatus.NOT_FOUND);

		matiereDao.delete(matiere);
		return new ResponseEntity<Matiere>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.MatiereWithEveythingJSON.class)
	public ResponseEntity<Matiere> createMatiere(@RequestBody Matiere matiere) {
		if(matiere.getId() != null)
			return new ResponseEntity<Matiere>(matiere, HttpStatus.BAD_REQUEST);
		matiereDao.create(matiere);
		return new ResponseEntity<Matiere>(matiere, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.MatiereWithEveythingJSON.class)
	public ResponseEntity<Matiere> updateMatiere(@RequestBody Matiere matiere) {
		Matiere matiereFind = matiereDao.find(matiere.getId());
		if (matiereFind != null) {
			matiere.setVersion(matiereFind.getVersion());
			matiereDao.update(matiere);
			return new ResponseEntity<Matiere>(matiereFind, HttpStatus.OK);
		}
		return new ResponseEntity<Matiere>(matiereFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}