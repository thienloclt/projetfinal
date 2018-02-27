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

import monprojet.factory.dao.StagiaireDao;
import monprojet.factory.entity.Stagiaire;
import monprojet.factory.validation.StagiaireValidator;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {
	
	@Autowired
	StagiaireDao stagiaireDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listStagiaire(Model model) {
		
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		model.addAttribute("stagiaires", stagiaires);
		return "business/stagiaire/stagiairelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailStagiaire(@PathVariable("id") Long id, Model model) {

		model.addAttribute("stagiaire", stagiaireDao.find(id));
		return "business/stagiaire/stagiairedetail";
	}

	@RequestMapping("/del/{id}")
	public String delStagiaire(@PathVariable("id") Long id, Model model) {
		
		stagiaireDao.delete(stagiaireDao.find(id));
		return listStagiaire(model);
	}

	@RequestMapping("/edit/{id}")
	public String editStagiaire(@PathVariable("id") Long id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("stagiaireObj", stagiaireDao.find(id));
		return "business/stagiaire/stagiaireadd";
	}

	@RequestMapping("/add")
	public String addStagiaire(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("stagiaireObj", new Stagiaire());
		return "business/stagiaire/stagiaireadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitStagiaire(@Valid @ModelAttribute("stagiaireObj") Stagiaire stagiaire, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/stagiaire/stagiaireadd";
		}
		else {
			if(stagiaire.getId() == null)
				stagiaireDao.create(stagiaire);
			else
				stagiaireDao.update(stagiaire);
			
			return listStagiaire(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StagiaireValidator());
	}
}