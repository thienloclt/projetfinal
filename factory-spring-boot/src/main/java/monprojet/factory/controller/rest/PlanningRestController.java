package monprojet.factory.controller.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.MediaType;
import org.springframework.core.io.InputStreamResource;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.factory.dao.PlanningDao;
import monprojet.factory.entity.Planning;
import monprojet.factory.Planning.util.GenSimpleReport;
import monprojet.factory.Planning.util.GeneratePdfReport;

@RestController
@CrossOrigin
public class PlanningRestController {

	@Autowired
	PlanningDao planningDao;

	//////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/planning")
	public ResponseEntity<List<Planning>> findAll() {
		List<Planning> modules = planningDao.findAll();
		return new ResponseEntity<List<Planning>>(modules, HttpStatus.OK);
	}
	////////////////////////////////////////////////////////////////////////////////////// GeneratePdfReport
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> planningReport() throws IOException {
		List<Planning> modules = (List<Planning>) planningDao.findAll();
		ByteArrayInputStream bis = GeneratePdfReport.planningReport(modules);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=planningReport.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	///////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////// GenSimpleReport
	@RequestMapping(value = "/simplereport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> simpleReport() throws IOException {
		List<Planning> modules = (List<Planning>) planningDao.findAll();
		ByteArrayInputStream bis = GenSimpleReport.simpleReport(modules);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=simpleReport.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	//////////////////////////////////////////////////////////////////////////////////////
}
