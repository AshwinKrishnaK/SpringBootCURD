package com.learnwithme.curd.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person")
@Data
@NoArgsConstructor
public class Person {

	@Id
	private int id;
	
	private String name;
	
	private int age;
	
	//private Address address;
}
