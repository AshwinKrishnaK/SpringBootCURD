package com.learnwithme.curd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.learnwithme.curd.entity.Person;
import com.learnwithme.curd.exception.UnExpectedError;
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
			throw new UnExpectedError("Unable to fetch all data");
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
			throw new UnExpectedError("Unable to save person");
		}
	}

	@Override
	public String deletePerson(int id) throws Exception {
		if (isPersonPresent(id)) {
			try {
				personRepository.deleteById(id);
				return "deleted";
			} catch (EmptyResultDataAccessException ex) {
				throw new UnExpectedError("No Person is found with this id: " + id);
			} catch (Exception ex) {
				throw new UnExpectedError("Unable to delete person");
			}
		} else {
			throw new UnExpectedError("No Person is found with this id: " + id);
		}
	}

	@Override
	public String updatePerson(Person person) throws Exception {
		if (isPersonPresent(person.getId())) {
			try {
				personRepository.save(person);
				return "updated";
			} catch (Exception e) {
				throw new UnExpectedError("Unable to update person");
			}
		} else {
			throw new UnExpectedError("No Person is found");
		}
	}

	
	private Boolean isPersonPresent(int id) {
		return personRepository.findById(id).isPresent();
	}
}
