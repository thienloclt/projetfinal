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

import monprojet.factory.dao.FormateurDao;
import monprojet.factory.entity.Formateur;
import monprojet.factory.validation.FormateurValidator;

@Controller
@RequestMapping("/formateur")
public class FormateurController {
	
	@Autowired
	FormateurDao formateurDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listFormateur(Model model) {
		
		List<Formateur> formateurs = formateurDao.findAll();
		model.addAttribute("formateurs", formateurs);
		return "business/formateur/formateurlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailFormateur(@PathVariable("id") Long id, Model model) {

		model.addAttribute("formateur", formateurDao.find(id));
		return "business/formateur/formateurdetail";
	}

	@RequestMapping("/del/{id}")
	public String delFormateur(@PathVariable("id") Long id, Model model) {
		
		formateurDao.delete(formateurDao.find(id));
		return listFormateur(model);
	}

	@RequestMapping("/edit/{id}")
	public String editFormateur(@PathVariable("id") Long id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("formateurObj", formateurDao.find(id));
		return "business/formateur/formateuradd";
	}

	@RequestMapping("/add")
	public String addFormateur(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("formateurObj", new Formateur());
		return "business/formateur/formateuradd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitFormateur(@Valid @ModelAttribute("formateurObj") Formateur formateur, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/formateur/formateuradd";
		}
		else {
			if(formateur.getId() == null)
				formateurDao.create(formateur);
			else
				formateurDao.update(formateur);
			
			return listFormateur(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new FormateurValidator());
	}
}