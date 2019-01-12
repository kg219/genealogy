package uk.ac.le.cs.CO3098.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.repository.PersonRepository;



@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	public Object findAllPersons(){
		return personRepo.findAll();
	
	}
	
	
	public Person findById(Integer i){
		return personRepo.findOne(i);
	}
	
	public void deleteById(Integer id){
		personRepo.delete(id);;
	}
	
	
	public void save(Person p){
		personRepo.save(p);
	}

}
