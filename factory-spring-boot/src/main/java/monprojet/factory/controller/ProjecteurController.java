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

import monprojet.factory.dao.ProjecteurDao;
import monprojet.factory.entity.Projecteur;
import monprojet.factory.validation.ProjecteurValidator;

@Controller
@RequestMapping("/projecteur")
public class ProjecteurController {
	
	@Autowired
	ProjecteurDao projecteurDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listProjecteur(Model model) {
		
		List<Projecteur> projecteurs = projecteurDao.findAll();
		model.addAttribute("projecteurs", projecteurs);
		return "business/projecteur/projecteurlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailProjecteur(@PathVariable("id") Long id, Model model) {

		model.addAttribute("projecteur", projecteurDao.find(id));
		return "business/projecteur/projecteurdetail";
	}

	@RequestMapping("/del/{id}")
	public String delProjecteur(@PathVariable("id") Long id, Model model) {
		
		projecteurDao.delete(projecteurDao.find(id));
		return listProjecteur(model);
	}

	@RequestMapping("/edit/{id}")
	public String editProjecteur(@PathVariable("id") Long id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("projecteurObj", projecteurDao.find(id));
		return "business/projecteur/projecteuradd";
	}

	@RequestMapping("/add")
	public String addProjecteur(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("projecteurObj", new Projecteur());
		return "business/projecteur/projecteuradd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitProjecteur(@Valid @ModelAttribute("projecteurObj") Projecteur projecteur, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/projecteur/projecteuradd";
		}
		else {
			if(projecteur.getId() == null)
				projecteurDao.create(projecteur);
			else
				projecteurDao.update(projecteur);
			
			return listProjecteur(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProjecteurValidator());
	}
}