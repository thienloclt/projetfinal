package monprojet.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping("/login")
	public String login(Model model) {
		return "other/auth";
	}

	@RequestMapping("/logout")
	public String error(Model model) {

		return "other/index";
	}
	

	// @Autowired
	// LoginDao loginDao;
	//

	//
	// @RequestMapping("/logout")
	// public String logout(Model model, HttpSession httpSession) {
	//
	// Login loggedUser = (Login) httpSession.getAttribute("login");
	//
	// if (loggedUser != null) {
	// httpSession.invalidate();
	// }
	// return greeting(model);
	// }
	//

	//
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public String submitLogin(@Valid @ModelAttribute("authObj") Login login,
	// BindingResult bindingResult, Model model, HttpSession httpSession) {
	//
	// if (bindingResult.hasErrors()) {
	// return "other/auth";
	// } else {
	// Login login_obj = loginDao.findByNamePass(login.getLogin(),
	// login.getpasswrd());
	// if (login_obj == null) {
	// bindingResult.rejectValue("login", "user.notmatch", "Username or Password
	// invalid");
	// return "other/auth";
	// }
	// else {
	// httpSession.setAttribute("login", login_obj);
	// return greeting(model);
	// }
	// }
	// }
	//
	// @InitBinder
	// protected void initBinder(WebDataBinder binder) {
	// binder.setValidator(new LoginValidator());
	// }
}