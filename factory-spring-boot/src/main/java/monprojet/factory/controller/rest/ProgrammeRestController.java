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

import monprojet.factory.dao.ProgrammeDao;
import monprojet.factory.entity.Programme;
import monprojet.framework.model.View;


@CrossOrigin
@RestController
@RequestMapping("/api/programme")
public class ProgrammeRestController {

	@Autowired
	ProgrammeDao programmeDao;

	@GetMapping("")
	@JsonView(View.ProgrammeWithEveythingJSON.class)
	public ResponseEntity<List<Programme>> findAll() {
		List<Programme> programmes = programmeDao.findAll();
		return new ResponseEntity<List<Programme>>(programmes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@JsonView(View.ProgrammeWithEveythingJSON.class)
	public ResponseEntity<Programme> findById(@PathVariable("id") int id) {
		Programme programme = programmeDao.find(id);
		return new ResponseEntity<Programme>(programme, (programme != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@JsonView(View.ProgrammeWithEveythingJSON.class)
	public ResponseEntity<Programme> deleteProgramme(@PathVariable("id") int id) {
		Programme programme = programmeDao.find(id);
		if (programme == null)
			return new ResponseEntity<Programme>(programme, HttpStatus.NOT_FOUND);

		programmeDao.delete(programme);
		return new ResponseEntity<Programme>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	@JsonView(View.ProgrammeWithEveythingJSON.class)
	public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme) {
		if(programme.getId() != null)
			return new ResponseEntity<Programme>(programme, HttpStatus.BAD_REQUEST);
		programmeDao.create(programme);
		return new ResponseEntity<Programme>(programme, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	@JsonView(View.ProgrammeWithEveythingJSON.class)
	public ResponseEntity<Programme> updateProgramme(@RequestBody Programme programme) {
		Programme programmeFind = programmeDao.find(programme.getId());
		if (programmeFind != null) {
			programme.setVersion(programmeFind.getVersion());
			programmeDao.update(programme);
			return new ResponseEntity<Programme>(programmeFind, HttpStatus.OK);
		}
		return new ResponseEntity<Programme>(programmeFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}