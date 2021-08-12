package com.duttech.language_crud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.duttech.language_crud.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	List<Language> findAll();

}
