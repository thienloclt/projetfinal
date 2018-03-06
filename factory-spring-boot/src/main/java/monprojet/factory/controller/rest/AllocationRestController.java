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

import monprojet.factory.dao.AllocationDao;
import monprojet.factory.entity.Allocation;
import monprojet.framework.model.View;

@CrossOrigin
@RestController
@RequestMapping("/api/allocation")
public class AllocationRestController {

	@Autowired
	AllocationDao allocationDao;

	@GetMapping("")
	//@JsonView(View.AllocationWithEveythingJSON.class)
	public ResponseEntity<List<Allocation>> findAll() {
		List<Allocation> allocations = allocationDao.findAll();
		return new ResponseEntity<List<Allocation>>(allocations, HttpStatus.OK);
	}
	
//	@GetMapping("/stagiairebyformation/{id}")
//	@JsonView(View.AllocationWithEveythingJSON.class)
//	public ResponseEntity<List<Stagiaire>> findStagiairesByFormation(@PathVariable("id") int id) {
//		List<Stagiaire> stagiaires = allocationDao.findStagiairesByFormation(id);
//		return new ResponseEntity<List<Stagiaire>>(stagiaires, HttpStatus.OK);
//	}
	
	@GetMapping("/byformation/{id}")
	//@JsonView(View.AllocationWithEveythingJSON.class)
	public ResponseEntity<List<Allocation>> findByFormation(@PathVariable("id") int id) {
		List<Allocation> allocations = allocationDao.findByFormation(id);
		return new ResponseEntity<List<Allocation>>(allocations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	//@JsonView(View.AllocationWithEveythingJSON.class)
	public ResponseEntity<Allocation> findById(@PathVariable("id") int id) {
		Allocation allocation = allocationDao.find(id);
		return new ResponseEntity<Allocation>(allocation, (allocation != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	//@JsonView(View.AllocationWithEveythingJSON.class)
	public ResponseEntity<Allocation> deleteAllocation(@PathVariable("id") int id) {
		Allocation allocation = allocationDao.find(id);
		if (allocation == null)
			return new ResponseEntity<Allocation>(allocation, HttpStatus.NOT_FOUND);

		allocationDao.delete(allocation);
		return new ResponseEntity<Allocation>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	//@JsonView(View.AllocationWithEveythingJSON.class)
	public ResponseEntity<Allocation> createAllocation(@RequestBody Allocation allocation) {
		if(allocation.getId() != null)
			return new ResponseEntity<Allocation>(allocation, HttpStatus.BAD_REQUEST);
		allocationDao.create(allocation);
		return new ResponseEntity<Allocation>(allocation, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	//@JsonView(View.AllocationWithEveythingJSON.class)
	public ResponseEntity<Allocation> updateAllocation(@RequestBody Allocation allocation) {
		Allocation allocationFind = allocationDao.find(allocation.getId());
		if (allocationFind != null) {
			allocation.setVersion(allocationFind.getVersion());
			allocationDao.update(allocation);
			return new ResponseEntity<Allocation>(allocationFind, HttpStatus.OK);
		}
		return new ResponseEntity<Allocation>(allocationFind, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<Object> errors() {
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}