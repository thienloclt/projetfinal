package monprojet.cheval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.cheval.dao.VoitureDao;
import monprojet.cheval.model.Couleur;
import monprojet.cheval.model.Voiture;
import monprojet.cheval.validator.VoitureValidator;

@Controller
@RequestMapping("/voiture")
public class VoitureController {
	
	@Autowired
	VoitureDao voitureDao;
	
	@RequestMapping("/")
	public String greeting(Model model) {

		return listVoiture(model);
	}

	@RequestMapping("/list")
	public String listVoiture(Model model) {
		
		List<Voiture> voitures = voitureDao.findAll();
		model.addAttribute("voitures", voitures);
		return "business/voiture/voiturelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailVoiture(@PathVariable("id") Long id, Model model) {

		model.addAttribute("voiture", voitureDao.find(id));
		return "business/voiture/voituredetail";
	}

	@RequestMapping("/del/{id}")
	public String delVoiture(@PathVariable("id") Long id, Model model) {
		
		voitureDao.delete(voitureDao.find(id));
		return listVoiture(model);
	}

	@RequestMapping("/edit/{id}")
	public String editVoiture(@PathVariable("id") Long id, Model model) {

		model.addAttribute("couleurs", Couleur.values());
		model.addAttribute("voitureObj", voitureDao.find(id));
		return "business/voiture/voitureadd";
	}

	@RequestMapping("/add")
	public String addVoiture(Model model) {
		model.addAttribute("couleurs", Couleur.values());
		model.addAttribute("voitureObj", new Voiture());
		return "business/voiture/voitureadd";
	}

	Validator contactValidator = new VoitureValidator();
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitVoiture(@ModelAttribute("voitureObj") Voiture voiture, BindingResult bindingResult, Model model) {
		
		contactValidator.validate(voiture, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("couleurs", Couleur.values());
			return "business/voiture/voitureadd";
		}
		else {
			if(voiture.getId() == null)
				voitureDao.create(voiture);
			else
				voitureDao.update(voiture);
			
			return listVoiture(model);
		}
	}
}