package me.quantumti.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class LoginController {

	@RequestMapping(value="login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="index")
	public String index(Model model) {
		return "admin/index";
	}

}
