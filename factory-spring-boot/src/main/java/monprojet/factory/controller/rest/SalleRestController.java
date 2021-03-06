package monprojet.factory.controller.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.factory.dao.SalleDao;
import monprojet.factory.entity.Salle;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/salle")
public class SalleRestController {

	@Autowired
	SalleDao salleDao;

	@GetMapping("")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<List<Salle>> findAll() {
		List<Salle> salles = salleDao.findAll();
		return new ResponseEntity<List<Salle>>(salles, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<List<Salle>> test() {
		Salle salle1 = new Salle("sal1", "Salle1", 10.3, 10);
		Salle salle2 = new Salle("sal2", "Salle2", 50.8, 20);
		Salle salle3 = new Salle("sal3", "Salle3", 20.0, 30);
		Salle salle4 = new Salle("sal4", "Salle4", 40.6, 40);
		salle4.setCapacite(40);
		salleDao.create(salle1);
		salleDao.create(salle2);
		salleDao.create(salle3);
		salleDao.create(salle4);
		List<Salle> salles = salleDao.findAll();
		return new ResponseEntity<List<Salle>>(salles, HttpStatus.OK);
	}
	
	@GetMapping("/ByDuration/{fromDate}/{endDate}")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<List<Salle>> findByDuration(@PathVariable("fromDate") String fromDate, @PathVariable("endDate") String endDate) {
		
		List<Salle> salles = null;
		try {
//			Date d, d1;
//			System.out.println(fromDate + "  " +endDate);
//			d = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
//			d1
//			
//			System.out.println( + "  " +(new SimpleDateFormat("yyyy-MM-dd").parse(endDate)).toString());
			salles = salleDao.findByDuration(new SimpleDateFormat("dd-MM-yyyy").parse(fromDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate));
			return new ResponseEntity<List<Salle>>(salles, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<List<Salle>>(salles, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ByOutOfFormation/{id}")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<List<Salle>> findByOutOfFormation(@PathVariable("id") int id) {
		List<Salle> salles = salleDao.findByOutOfFormation(id);
		return new ResponseEntity<List<Salle>>(salles, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> findById(@PathVariable("id") int id) {
		Salle salle = salleDao.find(id);
		return new ResponseEntity<Salle>(salle, (salle != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> deleteSalle(@PathVariable("id") int id) {
		Salle salle = salleDao.find(id);
		if (salle == null)
			return new ResponseEntity<Salle>(salle, HttpStatus.NOT_FOUND);

		salleDao.delete(salle);
		return new ResponseEntity<Salle>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> createSalle(@RequestBody Salle salle) {
		if(salle.getId() != null)
			return new ResponseEntity<Salle>(salle, HttpStatus.BAD_REQUEST);
		salleDao.create(salle);
		return new ResponseEntity<Salle>(salle, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.SalleWithEveythingJSON.class)
	public ResponseEntity<Salle> updateSalle(@RequestBody Salle salle) {
		Salle salleFind = salleDao.find(salle.getId());
		if (salleFind != null) {
			salle.setVersion(salleFind.getVersion());
			salleDao.update(salle);
			return new ResponseEntity<Salle>(salleFind, HttpStatus.OK);
		}
		return new ResponseEntity<Salle>(salleFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}