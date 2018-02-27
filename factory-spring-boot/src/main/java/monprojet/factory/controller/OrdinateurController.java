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

import monprojet.factory.dao.OrdinateurDao;
import monprojet.factory.entity.Ordinateur;
import monprojet.factory.validation.OrdinateurValidator;

@Controller
@RequestMapping("/ordinateur")
public class OrdinateurController {
	
	@Autowired
	OrdinateurDao ordinateurDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listOrdinateur(Model model) {
		
		List<Ordinateur> ordinateurs = ordinateurDao.findAll();
		model.addAttribute("ordinateurs", ordinateurs);
		return "business/ordinateur/ordinateurlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailOrdinateur(@PathVariable("id") Long id, Model model) {

		model.addAttribute("ordinateur", ordinateurDao.find(id));
		return "business/ordinateur/ordinateurdetail";
	}

	@RequestMapping("/del/{id}")
	public String delOrdinateur(@PathVariable("id") Long id, Model model) {
		
		ordinateurDao.delete(ordinateurDao.find(id));
		return listOrdinateur(model);
	}

	@RequestMapping("/edit/{id}")
	public String editOrdinateur(@PathVariable("id") Long id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("ordinateurObj", ordinateurDao.find(id));
		return "business/ordinateur/ordinateuradd";
	}

	@RequestMapping("/add")
	public String addOrdinateur(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("ordinateurObj", new Ordinateur());
		return "business/ordinateur/ordinateuradd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitOrdinateur(@Valid @ModelAttribute("ordinateurObj") Ordinateur ordinateur, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/ordinateur/ordinateuradd";
		}
		else {
			if(ordinateur.getId() == null)
				ordinateurDao.create(ordinateur);
			else
				ordinateurDao.update(ordinateur);
			
			return listOrdinateur(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new OrdinateurValidator());
	}
}