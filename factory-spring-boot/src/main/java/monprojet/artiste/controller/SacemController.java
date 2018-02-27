package monprojet.artiste.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import monprojet.artiste.dao.SacemDao;
import monprojet.artiste.entity.Sacem;

@Controller
@RequestMapping("/sacem")
public class SacemController {
	
	@Autowired
	SacemDao sacemDao;
	
	@RequestMapping("")
	public String listSacem(Model model) {
		
		List<Sacem> sacems = sacemDao.findAll();
		model.addAttribute("sacems", sacems);
		return "business/sacem/sacemlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailSacem(@PathVariable("id") String id, Model model) {

		model.addAttribute("sacem", sacemDao.find(id));
		return "business/sacem/sacemdetail";
	}

	@RequestMapping("/del/{id}")
	public String delSacem(@PathVariable("id") String id, Model model) {
		
		sacemDao.delete(sacemDao.find(id));
		return listSacem(model);
	}

	@RequestMapping("/edit/{id}")
	public String editSacem(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("modeSave", "edt");
		model.addAttribute("sacemObj", sacemDao.find(id));
		return "business/sacem/sacemadd";
	}

	@RequestMapping("/add")
	public String addSacem(Model model) {
		
		model.addAttribute("modeSave", "add");
		model.addAttribute("sacemObj", new Sacem());
		return "business/sacem/sacemadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitSacem(@RequestParam("modeSave") String modeSave, @ModelAttribute("sacemObj") Sacem sacem, BindingResult bindingResult, Model model) {
		
//		if (bindingResult.hasErrors()) {
//			System.out.println("111111111111111111");
//			return "sacem/sacemadd";
//		}
//		else {
			if("add".equals(modeSave)) {
				System.out.println("*****************************");
				System.out.println("*****************************");
				System.out.println("*****************************");
				System.out.println("*****************************");
				System.out.println("*****************************");
				sacemDao.create(sacem);
			}
			else {
				System.out.println("++++++++++++++++++++++++++++++");
				System.out.println("++++++++++++++++++++++++++++++");
				System.out.println("++++++++++++++++++++++++++++++");
				System.out.println("++++++++++++++++++++++++++++++");
				System.out.println("++++++++++++++++++++++++++++++");
				sacemDao.update(sacem);
			}
			return listSacem(model);
//		}
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