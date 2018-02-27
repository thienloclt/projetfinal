package monprojet.scolaire.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.scolaire.dao.MatiereDao;
import monprojet.scolaire.dao.SalleDao;
import monprojet.scolaire.entity.Matiere;
import monprojet.scolaire.entity.Salle;
import monprojet.scolaire.validator.SalleValidator;

@Controller
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleDao salleDao;
	@Autowired
	MatiereDao matiereDao;

	@RequestMapping("")
	public String listSalle(Model model) {

		List<Salle> salles = salleDao.findAll();
		model.addAttribute("salles", salles);
		return "business/salle/sallelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailSalle(@PathVariable("id") Long id, Model model) {

		model.addAttribute("salle", salleDao.find(id));
		return "business/salle/salledetail";
	}

	@RequestMapping("/del/{id}")
	public String delSalle(@PathVariable("id") Long id, Model model) {

		salleDao.delete(salleDao.find(id));
		return listSalle(model);
	}

	@RequestMapping("/edit/{id}")
	public String editSalle(@PathVariable("id") Long id, Model model) {

		model.addAttribute("salleObj", salleDao.find(id));
		model.addAttribute("matieres", matiereDao.findAll());
		return "business/salle/salleadd";
	}

	@RequestMapping("/add")
	public String addSalle(Model model) {

		model.addAttribute("salleObj", new Salle());
		model.addAttribute("matieres", matiereDao.findAll());
		return "business/salle/salleadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitSalle(@Valid @ModelAttribute("salleObj") Salle salle, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError objectError : errors)
				System.out.println(objectError.toString());
			model.addAttribute("matieres", matiereDao.findAll());

			return "business/salle/salleadd";
		} else {
			if (salle.getId() == null)
				salleDao.create(salle);
			else
				salleDao.update(salle);

			return listSalle(model);
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// register the SalleValidator used to validate objects of type Salle
		binder.setValidator(new SalleValidator());
		binder.registerCustomEditor(Matiere.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String id) {
				Matiere matiere = matiereDao.find(Long.parseLong(id));
				setValue(matiere);
			}
		});
	}
}