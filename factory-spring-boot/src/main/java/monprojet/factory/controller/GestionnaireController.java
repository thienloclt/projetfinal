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

import monprojet.factory.dao.GestionnaireDao;
import monprojet.factory.entity.Gestionnaire;
import monprojet.factory.validation.GestionnaireValidator;

@Controller
@RequestMapping("/gestionnaire")
public class GestionnaireController {
	
	@Autowired
	GestionnaireDao gestionnaireDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listGestionnaire(Model model) {
		
		List<Gestionnaire> gestionnaires = gestionnaireDao.findAll();
		model.addAttribute("gestionnaires", gestionnaires);
		return "business/gestionnaire/gestionnairelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailGestionnaire(@PathVariable("id") int id, Model model) {

		model.addAttribute("gestionnaire", gestionnaireDao.find(id));
		return "business/gestionnaire/gestionnairedetail";
	}

	@RequestMapping("/del/{id}")
	public String delGestionnaire(@PathVariable("id") int id, Model model) {
		
		gestionnaireDao.delete(gestionnaireDao.find(id));
		return listGestionnaire(model);
	}

	@RequestMapping("/edit/{id}")
	public String editGestionnaire(@PathVariable("id") int id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("gestionnaireObj", gestionnaireDao.find(id));
		return "business/gestionnaire/gestionnaireadd";
	}

	@RequestMapping("/add")
	public String addGestionnaire(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("gestionnaireObj", new Gestionnaire());
		return "business/gestionnaire/gestionnaireadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitGestionnaire(@Valid @ModelAttribute("gestionnaireObj") Gestionnaire gestionnaire, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/gestionnaire/gestionnaireadd";
		}
		else {
			if(gestionnaire.getId() == null)
				gestionnaireDao.create(gestionnaire);
			else
				gestionnaireDao.update(gestionnaire);
			
			return listGestionnaire(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new GestionnaireValidator());
	}
}