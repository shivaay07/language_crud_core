package com.duttech.language_crud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duttech.language_crud.models.Language;
import com.duttech.language_crud.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
//	All languages
	@RequestMapping("/languages")
	public String listOfLanguages(Model model, @ModelAttribute("language") Language lang) {
		List<Language> langList = languageService.allLanguages();
		model.addAttribute("langList", langList);
		return "/languages/index.jsp";
	}
	
//	create new language
	@RequestMapping(value="/create/lang", method=RequestMethod.POST )
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/index.jsp";
		}else {
			languageService.createLang(lang);
			return"redirect:/languages";
		}
	}
	
//	Page that will render the edit page
	
	@RequestMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		System.out.println("Heyy where are you ??");
		Language lang = languageService.findlanguage(id);
		
		model.addAttribute("language", lang);
		return "/languages/edit.jsp";
		
	}

	
	
//	update the language
	

	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT )
	public String updateLang(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/{id}";
		}else {
			languageService.updateLang(lang);
			return"redirect:/languages";
		}
	}
	
//	show the language page
	@RequestMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
			Language showOne = languageService.findlanguage(id);
		model.addAttribute("language",showOne);
		return "languages/show.jsp";
	}
	
//	lets delete some languages
	@RequestMapping(value="/languages/delete/{id}", method=RequestMethod.DELETE)
	public String destroyLang(@PathVariable("id") Long id) {
		languageService.deleteLang(id);
		return "redirect:/languages";
	}
}
	

