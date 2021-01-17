package com.antriksh.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antriksh.app.model.Contact;
import com.antriksh.app.model.User;
import com.antriksh.app.repository.IUserRepository;

@Controller
public class HomeController {

	@Autowired
	private IUserRepository repo;

	@RequestMapping({ "/", "home" })
	public String home(Model map) {
		map.addAttribute("tittle", "Home-Smart Contact Managert");

		return "home";
	}

	@RequestMapping("/about")
	public String about(Model map) {
		map.addAttribute("tittle", "about-Smart Contact Managert");

		return "about";

	}

	@RequestMapping("/signup")
	public String signup(Model map) {
		map.addAttribute("tittle", "register-Smart Contact Managert");
		map.addAttribute("user", new User());

		return "signup";
	}

	@PostMapping("/do-register")
	public String register(@ModelAttribute("user") User user,
			@RequestParam(value = "check", defaultValue = "false") boolean agreement, Model map) {
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		if(!agreement) {
			System.out.println("you have not agree term and condions");
		}
		System.out.println("user" + user);
		//map.addAttribute("user",user);
		User save = repo.save(user);
		map.addAttribute("user",save);
		return "signup";

	}
}
