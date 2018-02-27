package monprojet.cheval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import monprojet.cheval.dao.OwnerDao;
import monprojet.cheval.model.Owner;

@RestController
@RequestMapping("/ownerapi")
public class OwnerRestController {

	@Autowired
	OwnerDao ownerDao;

	@GetMapping("")
	public ResponseEntity<List<Owner>> findAll() {
		List<Owner> owners = ownerDao.findAll();
		return new ResponseEntity<List<Owner>>(owners, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Owner> findById(@PathVariable("id") Long id) {
		Owner owner = ownerDao.find(id);
		return new ResponseEntity<Owner>(owner, (owner != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Owner> deleteOwner(@PathVariable("id") Long id) {
		Owner owner = ownerDao.find(id);
		if (owner == null)
			return new ResponseEntity<Owner>(owner, HttpStatus.NOT_FOUND);

		ownerDao.delete(owner);
		return new ResponseEntity<Owner>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
		if(owner.getId() != null)
			return new ResponseEntity<Owner>(owner, HttpStatus.BAD_REQUEST);
		ownerDao.create(owner);
		return new ResponseEntity<Owner>(owner, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner) {
		Owner ownerFind = ownerDao.find(owner.getId());
		if (ownerFind != null) {
			ownerDao.update(owner);
			return new ResponseEntity<Owner>(ownerFind, HttpStatus.OK);
		}
		return new ResponseEntity<Owner>(ownerFind, HttpStatus.BAD_REQUEST);
	}
}