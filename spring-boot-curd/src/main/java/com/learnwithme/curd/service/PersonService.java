package com.learnwithme.curd.service;

import java.util.List;

import com.learnwithme.curd.entity.Person;
/**
 * Service class for Person
 * */
public interface PersonService {
	
	/**
	 * Get all person details
	 * 
	 * @author Ashwin
	 * @return List of Person
	 * @throws Exception
	 * */
	public List<Person> getAllPersons() throws Exception;
	
	/**
	 * Get perticular Person using id
	 * 
	 * @author Ashwin
	 * @param id : id
	 * @return Person details
	 * @throws Exception
	 * */
	public Person getPersonById(int id) throws Exception;
	
	/**
	 * Save Person
	 * 
	 * @author Ashwin
	 * @param Person
	 * @return String save/Not
	 * @throws Exception
	 * */
	public String savePerson(Person person) throws Exception;
	
	/**
	 * Delete Person by id
	 * 
	 * @author Ashwin
	 * @param id
	 * @return String deleted/Not
	 * @throws Exception
	 * */
	public String deletePerson(int id) throws Exception;
	
	/**
	 * Update Person
	 * 
	 * @author Ashwin
	 * @param Person
	 * @return String saved/Not
	 * @throw Exception
	 * */
	public String updatePerson(Person person) throws Exception;
}
