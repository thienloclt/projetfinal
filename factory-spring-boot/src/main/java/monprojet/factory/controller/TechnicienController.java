package monprojet.factory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.factory.dao.TechnicienDao;
import monprojet.factory.entity.Technicien;
import monprojet.factory.validation.TechnicienValidator;

@Controller
@RequestMapping("/technicien")
public class TechnicienController {
	
	@Autowired
	TechnicienDao technicienDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listTechnicien(Model model) {
		
		List<Technicien> techniciens = technicienDao.findAll();
		model.addAttribute("techniciens", techniciens);
		return "business/technicien/technicienlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailTechnicien(@PathVariable("id") int id, Model model) {

		model.addAttribute("technicien", technicienDao.find(id));
		return "business/technicien/techniciendetail";
	}

	@RequestMapping("/del/{id}")
	public String delTechnicien(@PathVariable("id") int id, Model model) {
		
		technicienDao.delete(technicienDao.find(id));
		return listTechnicien(model);
	}

	@RequestMapping("/edit/{id}")
	public String editTechnicien(@PathVariable("id") int id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("technicienObj", technicienDao.find(id));
		return "business/technicien/technicienadd";
	}

	@RequestMapping("/add")
	public String addTechnicien(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("technicienObj", new Technicien());
		return "business/technicien/technicienadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitTechnicien(@Valid @ModelAttribute("technicienObj") Technicien technicien, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/technicien/technicienadd";
		}
		else {
			if(technicien.getId() == null)
				technicienDao.create(technicien);
			else
				technicienDao.update(technicien);
			
			return listTechnicien(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new TechnicienValidator());
	}
}