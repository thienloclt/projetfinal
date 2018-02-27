package monprojet.cheval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import monprojet.cheval.dao.CentreEquestreDao;
import monprojet.cheval.model.CentreEquestre;

@Controller
@RequestMapping("/centreequestre")
public class CentreEquestreController {
	
	@Autowired
	CentreEquestreDao centreEquestreDao;

	@RequestMapping("")
	public String listCentreEquestre(Model model) {
		
		List<CentreEquestre> centreEquestres = centreEquestreDao.findAll();
		model.addAttribute("centreEquestres", centreEquestres);
		return "business/centreequestre/centreequestrelist";
	}

	@RequestMapping("/detail/{id}")
	public String detailCentreEquestre(@PathVariable("id") Long id, Model model) {

		model.addAttribute("centreEquestre", centreEquestreDao.find(id));
		return "business/centreequestre/centreequestredetail";
	}

	@RequestMapping("/del/{id}")
	public String delCentreEquestre(@PathVariable("id") Long id, Model model) {
		
		centreEquestreDao.delete(centreEquestreDao.find(id));
		return listCentreEquestre(model);
	}

	@RequestMapping("/edit/{id}")
	public String editCentreEquestre(@PathVariable("id") Long id, Model model) {

		model.addAttribute("centreEquestreObj", centreEquestreDao.find(id));
		return "business/centreequestre/centreequestreadd";
	}

	@RequestMapping("/add")
	public String addCentreEquestre(Model model) {
		
		model.addAttribute("centreEquestreObj", new CentreEquestre());
		return "business/centreequestre/centreequestreadd";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitCentreEquestre(@ModelAttribute("centreEquestreObj") CentreEquestre centreEquestre, Model model) {
		
		if (centreEquestre.getId() == null)
			centreEquestreDao.create(centreEquestre);
		else
			centreEquestreDao.update(centreEquestre);
		
		return listCentreEquestre(model);
	}
}