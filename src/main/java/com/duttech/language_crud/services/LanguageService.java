package com.duttech.language_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duttech.language_crud.models.Language;
import com.duttech.language_crud.repositories.LanguageRepository;


@Service
public class LanguageService {
	
//	adding the language repository as dependency
	
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	
//	list all languages
	
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
		
//	lets create language
	
	public Language createLang(Language lang) {
		return languageRepo.save(lang);
	}
	
//	find language by id 
	
	public Language findlanguage(Long id) {
		Optional<Language> optionLang = languageRepo.findById(id);
		if(optionLang.isPresent()) {
			return optionLang.get();
		}else {
			return null;
		}
			
	}
	
//	lets update the language
	
	public Language updateLang(Language lang) {
		return languageRepo.save(lang);
	}
	
//	lets delete the language
	public void deleteLang(Long id) {
		Optional<Language> langDelete = languageRepo.findById(id);
		if(langDelete.isPresent()) {
			languageRepo.deleteById(id);
		}
			
	}

}
