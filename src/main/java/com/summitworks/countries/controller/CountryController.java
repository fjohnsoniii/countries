package com.summitworks.countries.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.summitworks.countries.entity.Country;
import com.summitworks.countries.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	CountryService cService;

	@GetMapping("/")
	public String getAllCountries(Model model) {
		List<Country> cList = cService.findAllCountries();
		model.addAttribute("countries", cList);
		return "index";
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView getCountryById(@PathVariable ("id") int id, Model model) {
		ModelAndView mav = new ModelAndView("country_details");
		Country c = cService.findByCountryId(id);
		Model m = model.addAttribute("countries", c);
		mav.addObject(m);
		return mav;
	}
	
	@PostMapping("/save") 
	public String saveCountry(@Valid @ModelAttribute ("country") Country country,
							BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add_country";
		}
		
		cService.saveCountry(country);
		return "redirect:/";
	}
	
	@GetMapping("/add") 
	public String showForm(Model model, Country country) {
		model.addAttribute("country", country);
		return "add_country";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editCountry(@PathVariable ("id") int id, @Valid Country country,
									BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("edit_country");
		if (bindingResult.hasErrors()) {
			return mav;
		}
		Country c = cService.findByCountryId(id);
		cService.saveCountry(c);
		mav.addObject("country", c);
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCountry(@PathVariable ("id") int id) {
		cService.deleteCountry(id);
		return "redirect:/";
	}
}
