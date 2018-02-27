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

import monprojet.factory.dao.MatiereDao;
import monprojet.factory.entity.Matiere;
import monprojet.factory.validation.MatiereValidator;

@Controller
@RequestMapping("/matiere")
public class MatiereController {
	
	@Autowired
	MatiereDao matiereDao;
	
//	@Autowired
//	CentreEquestreDao centreEquestreDao;
//	
//	@Autowired
//	RegistreDao registreDao;

	@RequestMapping("")
	public String listMatiere(Model model) {
		
		List<Matiere> matieres = matiereDao.findAll();
		model.addAttribute("matieres", matieres);
		return "business/matiere/matierelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailMatiere(@PathVariable("id") Long id, Model model) {

		model.addAttribute("matiere", matiereDao.find(id));
		return "business/matiere/matieredetail";
	}

	@RequestMapping("/del/{id}")
	public String delMatiere(@PathVariable("id") Long id, Model model) {
		
		matiereDao.delete(matiereDao.find(id));
		return listMatiere(model);
	}

	@RequestMapping("/edit/{id}")
	public String editMatiere(@PathVariable("id") Long id, Model model) {

		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("matiereObj", matiereDao.find(id));
		return "business/matiere/matiereadd";
	}

	@RequestMapping("/add")
	public String addMatiere(Model model) {
		
		//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("matiereObj", new Matiere());
		return "business/matiere/matiereadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitMatiere(@Valid @ModelAttribute("matiereObj") Matiere matiere, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			//model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/matiere/matiereadd";
		}
		else {
			if(matiere.getId() == null)
				matiereDao.create(matiere);
			else
				matiereDao.update(matiere);
			
			return listMatiere(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// register the MatiereValidator used to validate objects of type Matiere
		binder.setValidator(new MatiereValidator());
	}
}