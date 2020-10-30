package com.thuan.tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thuan.tutorial.spring.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	/*
	 * Add user in model attribute
	 */
	@ModelAttribute("user")
	public User setUpUserForm() {
		return new User();
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/dologin")
	public String doLogin(@ModelAttribute("user") User user, Model model) {

		// Implement your business logic
		if (user.getEmail().equals("thuan") && user.getPassword().equals("123")) {
			// Set user dummy data
			user.setFname("Thuan");
			user.setMname("Tran");
			user.setLname("Quang");
			user.setAge(28);
		} else {
			model.addAttribute("message", "Login failed. Try again.");
			return "index";
		}
		return "success";
	}
}
