package monprojet.framework.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Thomas") String name,
			Model model, HttpSession httpSession) {

		model.addAttribute("name", name);

//		Login login = new Login("admin", "admin", Role.ADMIN);
//		httpSession.setAttribute("login", login);
		return "other/index";
	}
}