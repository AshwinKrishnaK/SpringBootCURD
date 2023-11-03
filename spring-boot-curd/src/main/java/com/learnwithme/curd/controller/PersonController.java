package com.learnwithme.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithme.curd.entity.Person;
import com.learnwithme.curd.service.PersonService;

/**
 * Rest controller for Person
 * 
 * @author Ashwin
 * */
@RestController
@RequestMapping("/person")
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
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonDetailsById(@PathVariable("id") int id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(id));
	}
	
	/**
	 * API for save Person details
	 * 
	 * @param Person
	 * @return saved/Not
	 * */
	@PostMapping("/save")
	public ResponseEntity<String> savePersonDetails(@RequestBody Person person) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(personService.savePerson(person));
	}
	
	/**
	 * API for Deleting Person by id
	 * 
	 * @param id
	 * @return saved/Not
	 * */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable("id") int id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(id));
	}
	
	/**
	 * API for Updating Person details
	 * 
	 * @param Person
	 * @return updated/Not
	 * */
	@PutMapping("/update")
	public ResponseEntity<String> updatePerson(@RequestBody Person person) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(person));
	}
}
