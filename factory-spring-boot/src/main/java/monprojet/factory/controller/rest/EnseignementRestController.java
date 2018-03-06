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

import monprojet.factory.dao.EnseignementDao;
import monprojet.factory.dao.FormateurDao;
import monprojet.factory.dao.MatiereDao;
import monprojet.factory.entity.Enseignement;
import monprojet.factory.entity.enumeration.Niveau;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/enseignement")
public class EnseignementRestController {

	@Autowired
	EnseignementDao enseignementDao;
	
	@Autowired
	FormateurDao formateurDao;
	
	@Autowired
	MatiereDao matiereDao;

	@GetMapping("")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<List<Enseignement>> findAll() {
		List<Enseignement> enseignements = enseignementDao.findAll();
		return new ResponseEntity<List<Enseignement>>(enseignements, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<List<Enseignement>> test() {
		Enseignement obj1 = new Enseignement(Niveau.Débutant);
		obj1.setFormateur(formateurDao.find(1));
		obj1.setMatiere(matiereDao.find(1));
		Enseignement obj2 = new Enseignement(Niveau.Avancé);
		obj2.setFormateur(formateurDao.find(2));
		obj2.setMatiere(matiereDao.find(2));
		Enseignement obj3 = new Enseignement(Niveau.Expert);
		obj3.setFormateur(formateurDao.find(3));
		obj3.setMatiere(matiereDao.find(3));
		Enseignement obj4 = new Enseignement(Niveau.Intermédiaire);
		obj4.setFormateur(formateurDao.find(4));
		obj4.setMatiere(matiereDao.find(4));
		enseignementDao.create(obj1);
		enseignementDao.create(obj2);
		enseignementDao.create(obj3);
		enseignementDao.create(obj4);
		List<Enseignement> objs = enseignementDao.findAll();
		return new ResponseEntity<List<Enseignement>>(objs, HttpStatus.OK);
	}
	
	@GetMapping("/ByMatiereAndOutOfFormation/{matiere_id}/{formation_id}")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<List<Enseignement>> findByMatiereAndOutOfFormation(@PathVariable("matiere_id") int matiere_id, @PathVariable("formation_id") int formation_id) {
		try {
			List<Enseignement> enseignements = enseignementDao.findByMatiereAndOutOfFormation(matiere_id, formation_id);
			return new ResponseEntity<List<Enseignement>>(enseignements, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<List<Enseignement>>(HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/{id}")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> findById(@PathVariable("id") int id) {
		Enseignement enseignement = enseignementDao.find(id);
		return new ResponseEntity<Enseignement>(enseignement, (enseignement != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> deleteEnseignement(@PathVariable("id") int id) {
		Enseignement enseignement = enseignementDao.find(id);
		if (enseignement == null)
			return new ResponseEntity<Enseignement>(enseignement, HttpStatus.NOT_FOUND);

		enseignementDao.delete(enseignement);
		return new ResponseEntity<Enseignement>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> createEnseignement(@RequestBody Enseignement enseignement) {
		if(enseignement.getId() != null)
			return new ResponseEntity<Enseignement>(enseignement, HttpStatus.BAD_REQUEST);
		enseignementDao.create(enseignement);
		return new ResponseEntity<Enseignement>(enseignement, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.EnseignementWithEveythingJSON.class)
	public ResponseEntity<Enseignement> updateEnseignement(@RequestBody Enseignement enseignement) {
		Enseignement enseignementFind = enseignementDao.find(enseignement.getId());
		if (enseignementFind != null) {
			enseignement.setVersion(enseignementFind.getVersion());
			enseignementDao.update(enseignement);
			return new ResponseEntity<Enseignement>(enseignementFind, HttpStatus.OK);
		}
		return new ResponseEntity<Enseignement>(enseignementFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}