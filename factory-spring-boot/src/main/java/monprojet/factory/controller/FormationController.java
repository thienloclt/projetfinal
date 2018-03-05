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

import monprojet.factory.dao.FormationDao;
import monprojet.factory.entity.Formation;
import monprojet.factory.validation.FormationValidator;

@Controller
@RequestMapping("/formation")
public class FormationController {
	
	@Autowired
	FormationDao formationDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listFormation(Model model) {
		
		List<Formation> formations = formationDao.findAll();
		model.addAttribute("formations", formations);
		return "business/formation/formationlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailFormation(@PathVariable("id") int id, Model model) {

		model.addAttribute("formation", formationDao.find(id));
		return "business/formation/formationdetail";
	}

	@RequestMapping("/del/{id}")
	public String delFormation(@PathVariable("id") int id, Model model) {
		
		formationDao.delete(formationDao.find(id));
		return listFormation(model);
	}

	@RequestMapping("/edit/{id}")
	public String editFormation(@PathVariable("id") int id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("formationObj", formationDao.find(id));
		return "business/formation/formationadd";
	}

	@RequestMapping("/add")
	public String addFormation(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("formationObj", new Formation());
		return "business/formation/formationadd";
	}
	
	@RequestMapping("/test")
	public String testFormation(Model model) {
		
		Formation formation = new Formation();
		formation.setTitre("vv1");
		formationDao.create(formation);
		Formation find = formationDao.find(formation.getId());
		find.setTitre("vv2");
		find = formationDao.update(find);
		find = formationDao.find(find.getId());
		find.setTitre("vv3");
		find = formationDao.update(find);
		find = formationDao.find(find.getId());
		find.setTitre("vv4");
		find = formationDao.update(find);
		find = formationDao.find(find.getId());
		find.setTitre("vv5");
		find = formationDao.update(find);
		find = formationDao.find(find.getId());
		return listFormation(model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitFormation(@Valid @ModelAttribute("formationObj") Formation formation, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/formation/formationadd";
		}
		else {
			if(formation.getId() == null)
				formationDao.create(formation);
			else
				formationDao.update(formation);
			
			return listFormation(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// register the FormationValidator used to validate objects of type Formation
		binder.setValidator(new FormationValidator());
	}
}