package com.jw.burgertracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jw.burgertracker.models.Burger;
import com.jw.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
	@Autowired
	BurgerService bServ;

	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("burgers", bServ.findAll());
		m.addAttribute("burger", new Burger());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String create(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			Model m
			) {
		m.addAttribute("burgers", bServ.findAll());

		if (result.hasErrors()) {
			return "index.jsp";
		}
		bServ.create(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model m
			) {
		m.addAttribute("burger", bServ.byID(id));
		return "/edit.jsp";
	}

	@PutMapping("/burgers/edit/{id}")
	public String update(
			@Valid @ModelAttribute("burger") Burger b,
			BindingResult result,
			Model m
			) {
		if (result.hasErrors()) {
			return "/edit.jsp";
		}
		bServ.update(b);
		return "redirect:/";
	}
}
