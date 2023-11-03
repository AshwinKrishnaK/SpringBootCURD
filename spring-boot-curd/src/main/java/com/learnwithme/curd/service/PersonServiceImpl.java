package com.learnwithme.curd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwithme.curd.entity.Person;
import com.learnwithme.curd.exception.UnExceptedError;
import com.learnwithme.curd.repository.PersonRepository;

/**
 * Service Implementation of Person Service class.
 * 
 * @author Ashwin
 */
@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() throws Exception {
		try {
			return personRepository.findAll();
		} catch (Exception e) {
			logger.error("Error occured while getAllPersons method ", e);
			throw new UnExceptedError("Unable to fetch all data");
		}
	}

	@Override
	public Person getPersonById(int id) throws Exception {
		return personRepository.findById(id)
				.orElseThrow(() -> new Exception("Person not found with id: "+id));
	}

	@Override
	public String savePerson(Person person) throws Exception {
		try {
			personRepository.save(person);
			return "saved";
		} catch (Exception e) {
			throw new UnExceptedError("Unable to save person");
		}
	}

	@Override
	public String deletePerson(int id) throws Exception {
		try {
			if(isPersonPresent(id)) {
				personRepository.deleteById(id);
				return "deleted";
			}else {
				throw new UnExceptedError("No Person is found with this id: "+id);
			}
		} catch (Exception e) {
			throw new UnExceptedError("Unable to delete person");
		}
	}

	@Override
	public String updatePerson(Person person) throws Exception {
		try {
			if(isPersonPresent(person.getId())) {
				personRepository.save(person);
				return "updated";
			}else {
				throw new UnExceptedError("No Person is found");	
			}
		} catch (Exception e) {
			throw new UnExceptedError("Unable to update person");
		}
	}

	
	private Boolean isPersonPresent(int id) {
		return personRepository.findById(id).isPresent();
	}
}
