package monprojet.cheval.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.cheval.dao.RegistreDao;
import monprojet.cheval.model.Registre;

@Controller
@RequestMapping("/registre")
public class RegistreController {
	
	@Autowired
	RegistreDao registreDao;

	@RequestMapping("")
	public String listRegistre(Model model) {
		
		List<Registre> registres = registreDao.findAll();
		model.addAttribute("registres", registres);
		return "business/registre/registrelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailRegistre(@PathVariable("id") Long id, Model model) {

		model.addAttribute("registre", registreDao.find(id));
		return "business/registre/registredetail";
	}

	@RequestMapping("/del/{id}")
	public String delRegistre(@PathVariable("id") Long id, Model model) {
		
		registreDao.delete(registreDao.find(id));
		return listRegistre(model);
	}

	@RequestMapping("/edit/{id}")
	public String editRegistre(@PathVariable("id") Long id, Model model) {

		model.addAttribute("registreObj", registreDao.find(id));
		return "business/registre/registreadd";
	}

	@RequestMapping("/add")
	public String addRegistre(Model model) {
		
		model.addAttribute("registreObj", new Registre());
		return "business/registre/registreadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitRegistre(@ModelAttribute("registreObj") Registre registre, Model model) {
		System.out.println(registre.toString());
		
		if(registre.getId() == null)
			registreDao.create(registre);
		else
			registreDao.update(registre);
		
		return listRegistre(model);
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