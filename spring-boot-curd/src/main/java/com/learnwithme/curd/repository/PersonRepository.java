package com.learnwithme.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithme.curd.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>{

}
