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
		
		Enseignement obj1 = new Enseignement();
		obj1.setFormateur(formateurDao.find(1));
		obj1.setMatiere(matiereDao.find(1));
		obj1.setNiveau(Niveau.Avancé);
		
		Enseignement obj2 = new Enseignement();
		obj2.setFormateur(formateurDao.find(2));
		obj2.setMatiere(matiereDao.find(1));
		obj2.setNiveau(Niveau.Débutant);
		
		Enseignement obj3 = new Enseignement();
		obj3.setFormateur(formateurDao.find(4));
		obj3.setMatiere(matiereDao.find(1));
		obj3.setNiveau(Niveau.Débutant);
		
		Enseignement obj4 = new Enseignement();
		obj4.setFormateur(formateurDao.find(1));
		obj4.setMatiere(matiereDao.find(2));
		obj4.setNiveau(Niveau.Débutant);
		
		Enseignement obj5 = new Enseignement();
		obj5.setFormateur(formateurDao.find(3));
		obj5.setMatiere(matiereDao.find(2));
		obj5.setNiveau(Niveau.Débutant);
		
		Enseignement obj6 = new Enseignement();
		obj6.setFormateur(formateurDao.find(4));
		obj6.setMatiere(matiereDao.find(2));
		obj6.setNiveau(Niveau.Débutant);
		
		Enseignement obj7 = new Enseignement();
		obj7.setFormateur(formateurDao.find(2));
		obj7.setMatiere(matiereDao.find(3));
		obj7.setNiveau(Niveau.Débutant);
		
		Enseignement obj8 = new Enseignement();
		obj8.setFormateur(formateurDao.find(1));
		obj8.setMatiere(matiereDao.find(3));
		obj8.setNiveau(Niveau.Débutant);
		
		Enseignement obj9= new Enseignement();
		obj9.setFormateur(formateurDao.find(1));
		obj9.setMatiere(matiereDao.find(4));
		obj9.setNiveau(Niveau.Débutant);
		
		Enseignement obj10= new Enseignement();
		obj10.setFormateur(formateurDao.find(1));
		obj10.setMatiere(matiereDao.find(5));
		obj10.setNiveau(Niveau.Débutant);
		
		Enseignement obj11= new Enseignement();
		obj11.setFormateur(formateurDao.find(2));
		obj11.setMatiere(matiereDao.find(5));
		obj11.setNiveau(Niveau.Débutant);
		
		Enseignement obj12= new Enseignement();
		obj12.setFormateur(formateurDao.find(2));
		obj12.setMatiere(matiereDao.find(6));
		obj12.setNiveau(Niveau.Débutant);
		
		Enseignement obj13= new Enseignement();
		obj13.setFormateur(formateurDao.find(2));
		obj13.setMatiere(matiereDao.find(7));
		obj13.setNiveau(Niveau.Débutant);
		
		Enseignement obj14= new Enseignement();
		obj14.setFormateur(formateurDao.find(2));
		obj14.setMatiere(matiereDao.find(8));
		obj14.setNiveau(Niveau.Débutant);
		
		Enseignement obj15= new Enseignement();
		obj15.setFormateur(formateurDao.find(3));
		obj15.setMatiere(matiereDao.find(9));
		obj15.setNiveau(Niveau.Débutant);
		
		Enseignement obj16= new Enseignement();
		obj16.setFormateur(formateurDao.find(3));
		obj16.setMatiere(matiereDao.find(10));
		obj16.setNiveau(Niveau.Débutant);
		
		Enseignement obj17= new Enseignement();
		obj17.setFormateur(formateurDao.find(3));
		obj17.setMatiere(matiereDao.find(11));
		obj17.setNiveau(Niveau.Débutant);
		
		Enseignement obj18= new Enseignement();
		obj18.setFormateur(formateurDao.find(4));
		obj18.setMatiere(matiereDao.find(12));
		obj18.setNiveau(Niveau.Débutant);
		
		Enseignement obj19= new Enseignement();
		obj19.setFormateur(formateurDao.find(4));
		obj19.setMatiere(matiereDao.find(13));
		obj19.setNiveau(Niveau.Débutant);
		
		Enseignement obj20= new Enseignement();
		obj20.setFormateur(formateurDao.find(4));
		obj20.setMatiere(matiereDao.find(14));
		obj20.setNiveau(Niveau.Débutant);
		
		Enseignement obj21= new Enseignement();
		obj21.setFormateur(formateurDao.find(4));
		obj21.setMatiere(matiereDao.find(15));
		obj21.setNiveau(Niveau.Débutant);
		
		enseignementDao.create(obj1);
		enseignementDao.create(obj2);
		enseignementDao.create(obj3);
		enseignementDao.create(obj4);
		enseignementDao.create(obj5);
		enseignementDao.create(obj6);
		enseignementDao.create(obj7);
		enseignementDao.create(obj8);
		enseignementDao.create(obj9);
		enseignementDao.create(obj10);
		enseignementDao.create(obj11);
		enseignementDao.create(obj12);
		enseignementDao.create(obj13);
		enseignementDao.create(obj14);
		enseignementDao.create(obj15);
		enseignementDao.create(obj16);
		enseignementDao.create(obj17);
		enseignementDao.create(obj18);
		enseignementDao.create(obj19);
		enseignementDao.create(obj20);
		enseignementDao.create(obj21);
		
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