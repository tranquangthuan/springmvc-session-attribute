package com.thuan.tutorial.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.thuan.tutorial.spring.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	/*
	 * Get user from session attribute
	 */
	@GetMapping("/info")
	public String userInfo(@SessionAttribute("user") User user, HttpSession httpSession) {

		User userFromSession = (User) httpSession.getAttribute("user");
		System.out.println("UserFromSession Email: " + userFromSession.getEmail());
		System.out.println("UserFromSession First Name: " + userFromSession.getFname());

		System.out.println("Email: " + user.getEmail());
		System.out.println("First Name: " + user.getFname());

		return "user";
	}
}
