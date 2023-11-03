package com.learnwithme.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithme.curd.entity.Person;
import com.learnwithme.curd.service.PersonService;

/**
 * Rest controller for Person
 * 
 * @author Ashwin
 * */
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	/**
	 * API for get All Person details
	 * 
	 * @return list of all person
	 * */
	@GetMapping("/allpersondetails")
	public ResponseEntity<List<Person>> getAllPersonDetails() throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
	}
	
	/**
	 * API for get Person details by id.
	 * 
	 * @param id
	 * @return Person details
	 * */
	@GetMapping("/persondetails/{id}")
	public ResponseEntity<Person> getPersonDetailsById(@PathVariable("id") int id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(id));
	}
}
