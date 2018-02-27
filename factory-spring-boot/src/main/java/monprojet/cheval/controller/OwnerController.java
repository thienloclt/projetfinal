package monprojet.cheval.controller;

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

import monprojet.cheval.dao.CentreEquestreDao;
import monprojet.cheval.dao.OwnerDao;
import monprojet.cheval.dao.RegistreDao;
import monprojet.cheval.model.Owner;
import monprojet.cheval.validator.OwnerValidator;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	CentreEquestreDao centreEquestreDao;
	
	@Autowired
	RegistreDao registreDao;

	@RequestMapping("")
	public String listOwner(Model model) {
		
		List<Owner> owners = ownerDao.findAll();
		model.addAttribute("owners", owners);
		return "business/owner/ownerlist";
	}

	@RequestMapping("/detail/{id}")
	public String detailOwner(@PathVariable("id") Long id, Model model) {

		model.addAttribute("owner", ownerDao.find(id));
		return "business/owner/ownerdetail";
	}

	@RequestMapping("/del/{id}")
	public String delOwner(@PathVariable("id") Long id, Model model) {
		
		ownerDao.delete(ownerDao.find(id));
		return listOwner(model);
	}

	@RequestMapping("/edit/{id}")
	public String editOwner(@PathVariable("id") Long id, Model model) {

		model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("ownerObj", ownerDao.find(id));
		return "business/owner/owneradd";
	}

	@RequestMapping("/add")
	public String addOwner(Model model) {
		
		model.addAttribute("centreEquestres", centreEquestreDao.findAll());
		model.addAttribute("ownerObj", new Owner());
		return "business/owner/owneradd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitOwner(@Valid @ModelAttribute("ownerObj") Owner owner, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("centreEquestres", centreEquestreDao.findAll());
			return "business/owner/owneradd";
		}
		else {
			if(owner.getId() == null)
				ownerDao.create(owner);
			else
				ownerDao.update(owner);
			
			return listOwner(model);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// register the OwnerValidator used to validate objects of type Owner
		binder.setValidator(new OwnerValidator());
	}
}