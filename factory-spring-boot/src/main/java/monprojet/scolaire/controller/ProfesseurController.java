package monprojet.scolaire.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.scolaire.dao.MatiereDao;
import monprojet.scolaire.dao.ProfesseurDao;
import monprojet.scolaire.entity.Matiere;
import monprojet.scolaire.entity.Professeur;
import monprojet.scolaire.validator.ProfesseurValidator;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {
	
	@Autowired
	ProfesseurDao professeurDao;
	
	@Autowired
	MatiereDao matiereDao;
	
	@RequestMapping("")
	public String listProfesseur(Model model) {
		
		List<Professeur> professeurs = professeurDao.findAll();
		model.addAttribute("professeurs", professeurs);
		return "business/professeur/professeurlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailProfesseur(@PathVariable("id") Long id, Model model) {

		model.addAttribute("professeur", professeurDao.find(id));
		return "business/professeur/professeurdetail";
	}

	@RequestMapping("/del/{id}")
	public String delProfesseur(@PathVariable("id") Long id, Model model) {
		
		professeurDao.delete(professeurDao.find(id));
		return listProfesseur(model);
	}

	@RequestMapping("/edit/{id}")
	public String editProfesseur(@PathVariable("id") Long id, Model model) {

		model.addAttribute("matieres", matiereDao.findAll());
		model.addAttribute("professeurObj", professeurDao.find(id));
		return "business/professeur/professeuradd";
	}

	@RequestMapping("/add")
	public String addProfesseur(Model model) {
		
		model.addAttribute("matieres", matiereDao.findAll());
		model.addAttribute("professeurObj", new Professeur());
		return "business/professeur/professeuradd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitProfesseur(@Valid @ModelAttribute("professeurObj") Professeur professeur, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("matieres", matiereDao.findAll());
			return "business/professeur/professeuradd";
		}
		else {
			if(professeur.getId() == null)
				professeurDao.create(professeur);
			else
				professeurDao.update(professeur);
			return listProfesseur(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProfesseurValidator());
		
	    binder.registerCustomEditor(Matiere.class, new PropertyEditorSupport() {
	        @Override
	        public void setAsText(String id) {
	        	Matiere matiere = matiereDao.find(Long.parseLong(id));
	            setValue(matiere);
	        }
	    });
	}
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		//The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
}