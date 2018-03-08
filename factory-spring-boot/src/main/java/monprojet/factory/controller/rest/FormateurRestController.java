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
		Formateur formateur1 = new Formateur();
		formateur1.setNom("formateur1");
		formateur1.setPrenom("formateur1");
		formateur1.setTitre("titre1");
		formateur1.setCompetence("competence1");
		Formateur formateur2 = new Formateur();
		formateur2.setNom("formateur2");
		formateur2.setPrenom("formateur2");
		formateur1.setTitre("titre2");
		formateur2.setCompetence("competence2");
		Formateur formateur3 = new Formateur();
		formateur3.setNom("formateur3");
		formateur3.setPrenom("formateur3");
		formateur1.setTitre("titre3");
		formateur3.setCompetence("competence3");
		Formateur formateur4 = new Formateur();
		formateur4.setNom("formateur4");
		formateur4.setPrenom("formateur4");
		formateur1.setTitre("titre4");
		formateur4.setCompetence("competence4");
		formateurDao.create(formateur1);
		formateurDao.create(formateur2);
		formateurDao.create(formateur3);
		formateurDao.create(formateur4);
		List<Formateur> formateurs = formateurDao.findAll();
		return new ResponseEntity<List<Formateur>>(formateurs, HttpStatus.OK);
	}
	
//	@GetMapping("/ByMatiereAndOutOfFormation/{matiere_id}/{formation_id}")
//	@JsonView(View.FormateurWithEveythingJSON.class)
//	public ResponseEntity<List<Formateur>> findByMatiereAndOutOfFormation(@PathVariable("matiere_id") int matiere_id, @PathVariable("formation_id") int formation_id) {
//		try {
//			List<Formateur> formateurs = formateurDao.findByMatiereAndOutOfFormation(matiere_id, formation_id);
//			return new ResponseEntity<List<Formateur>>(formateurs, HttpStatus.OK);
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return new ResponseEntity<List<Formateur>>(HttpStatus.NOT_FOUND);
//		
//	}

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