package com.springboot.model;

import java.util.Arrays;



import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import com.springboot.repository.*;
import com.springboot.SpringBootApplicationMain;

public class Run {
	
	 public static void main(String[] args) {
	        ApplicationContext context = SpringApplication.run(SpringBootApplicationMain.class, args);

	        DogBreedRepository dogBreedRepository = context.getBean(DogBreedRepository.class);
	        DogRepository dogRepository = context.getBean(DogRepository.class);
	        PersonRepository personRepository = context.getBean(PersonRepository.class);

	        dogbreed breed1 = new dogbreed(101,"Golden Retriever");
	        dogbreed breed2 = new dogbreed(102,"Bulldog");
	        dogbreed breed3 = new dogbreed(103,"Labrador Retriever");
	        dogbreed breed4 = new dogbreed(104,"Siberian Husky");

	        List<dogbreed> breeds = Arrays.asList(breed1, breed2, breed3, breed4);
        dogBreedRepository.saveAll(breeds);

	        Person person1 = new Person("P001", "John Doe", "123 Main Street", 
                                    "0812345678", "john.doe@email.com", 1);
        personRepository.save(person1);

	        Dog dog1 = new Dog("Buddy", 1, "3 years", "Friendly and playful", breed1, null);
	        Dog dog2 = new Dog("Luna", 0, "2 years", "Calm and gentle", breed1, person1);
	        Dog dog3 = new Dog("Rocky", 1, "4 years", "Strong and loyal", breed2, null);
	        Dog dog4 = new Dog("Molly", 0, "3 years", "Sweet and affectionate", breed2, null);		
	        Dog dog5 = new Dog("Max", 1, "2 years", "Energetic and intelligent", breed3, null);
	        Dog dog6 = new Dog("Bella", 0, "1 year", "Playful and curious", breed3, null);
	        Dog dog7 = new Dog("Zeus", 1, "3 years", "Independent and energetic", breed4, null);
	        Dog dog8 = new Dog("Luna", 0, "2 years", "Beautiful blue eyes", breed4, null);

	        dogRepository.saveAll(Arrays.asList(dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8));

	        System.out.println("✅ Successfully inserted");
	    }
	}
