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

import monprojet.factory.dao.ProjecteurDao;
import monprojet.factory.entity.Projecteur;


@CrossOrigin
@RestController
@RequestMapping("/api/projecteur")
public class ProjecteurRestController {

	@Autowired
	ProjecteurDao projecteurDao;

	@GetMapping("")
	//@JsonView(View.ProjecteurWithCentreEquestre.class)
	public ResponseEntity<List<Projecteur>> findAll() {
		List<Projecteur> projecteurs = projecteurDao.findAll();
		return new ResponseEntity<List<Projecteur>>(projecteurs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.ProjecteurWithCentreEquestre.class)
	public ResponseEntity<Projecteur> findById(@PathVariable("id") int id) {
		Projecteur projecteur = projecteurDao.find(id);
		return new ResponseEntity<Projecteur>(projecteur, (projecteur != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.ProjecteurWithCentreEquestre.class)
	public ResponseEntity<Projecteur> deleteProjecteur(@PathVariable("id") int id) {
		Projecteur projecteur = projecteurDao.find(id);
		if (projecteur == null)
			return new ResponseEntity<Projecteur>(projecteur, HttpStatus.NOT_FOUND);

		projecteurDao.delete(projecteur);
		return new ResponseEntity<Projecteur>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.ProjecteurWithCentreEquestre.class)
	public ResponseEntity<Projecteur> createProjecteur(@RequestBody Projecteur projecteur) {
		if(projecteur.getId() != null)
			return new ResponseEntity<Projecteur>(projecteur, HttpStatus.BAD_REQUEST);
		projecteurDao.create(projecteur);
		return new ResponseEntity<Projecteur>(projecteur, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.ProjecteurWithCentreEquestre.class)
	public ResponseEntity<Projecteur> updateProjecteur(@RequestBody Projecteur projecteur) {
		Projecteur projecteurFind = projecteurDao.find(projecteur.getId());
		if (projecteurFind != null) {
			projecteurDao.update(projecteur);
			return new ResponseEntity<Projecteur>(projecteurFind, HttpStatus.OK);
		}
		return new ResponseEntity<Projecteur>(projecteurFind, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> errors() {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}