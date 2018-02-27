package monprojet.cheval.controller;

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

import monprojet.cheval.dao.UserTestDao;
import monprojet.cheval.model.UserTest;

@CrossOrigin
@RestController
@RequestMapping("/api/usertest")
public class UserTestRestController {

	@Autowired
	UserTestDao usertestDao;

	@GetMapping("")
	public ResponseEntity<List<UserTest>> findAll() {
		List<UserTest> usertests = usertestDao.findAll();
		return new ResponseEntity<List<UserTest>>(usertests, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserTest> findById(@PathVariable("id") Long id) {
		UserTest usertest = usertestDao.find(id);
		return new ResponseEntity<UserTest>(usertest, (usertest != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserTest> deleteUserTest(@PathVariable("id") Long id) {
		UserTest usertest = usertestDao.find(id);
		if (usertest == null)
			return new ResponseEntity<UserTest>(usertest, HttpStatus.NOT_FOUND);

		usertestDao.delete(usertest);
		return new ResponseEntity<UserTest>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("")
	public ResponseEntity<UserTest> createUserTest(@RequestBody UserTest usertest) {
		if(usertest.getId() != null)
			return new ResponseEntity<UserTest>(usertest, HttpStatus.BAD_REQUEST);
		usertestDao.create(usertest);
		return new ResponseEntity<UserTest>(usertest, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<UserTest> updateUserTest(@RequestBody UserTest usertest) {
		UserTest usertestFind = usertestDao.find(usertest.getId());
		if (usertestFind != null) {
			usertestDao.update(usertest);
			return new ResponseEntity<UserTest>(usertestFind, HttpStatus.OK);
		}
		return new ResponseEntity<UserTest>(usertestFind, HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    	return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}