package uk.ac.le.cs.CO3098.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.domain.messageOutput;
import uk.ac.le.cs.CO3098.spring.repository.PersonRepository;
import uk.ac.le.cs.CO3098.spring.service.PersonService;

@Controller
@RequestMapping(value = {"/person"})
public class PersonController {
	  @Autowired
	  PersonService ps;
	  
	  @Autowired
	  PersonRepository personRepo;
	  
	  //adding a person
	
	  @RequestMapping(value = "/add", method = RequestMethod.GET, produces ="application/json")
	  public @ResponseBody messageOutput add(@RequestParam(value = "key", required =true)Integer key, 
			  @RequestParam(value = "name", required =true) String name,
			  @RequestParam(value = "dob", required =false, defaultValue = "0")Integer dob,
			  @RequestParam(value = "m", required =false, defaultValue ="0")Integer mKey,
			  @RequestParam(value = "f", required =false, defaultValue = "0")Integer fKey,
			  @RequestParam(value = "g", required =false, defaultValue = "null")String gender){
		  
		  List<Person>keyid = personRepo.findKey(key);
		  List<Person>keyidmother = personRepo.findKey(mKey);
		  List<Person>keyidfather = personRepo.findKey(fKey);
		  if(keyid.size()==0) {
if(keyidmother.size() !=0 && keyidfather.size() !=0 || keyidmother.size() ==0 && keyidfather.size() ==0 ) {
	
	Person per = new Person(key, name ,mKey,fKey,dob,gender);
	ps.save(per);
	
	messageOutput mOut = new messageOutput();
	mOut.setResult("true"); 
	mOut.setMessage("successfully added to the family tree ");

	return mOut;
}else  {
	System.out.println("the parent id has not been provided");
	messageOutput mOut = new messageOutput();
	mOut.setResult("false"); 
	mOut.setMessage("mother or father key doesnt exist ");
	return mOut ;
}

}else {
	System.out.println("key already exist ");
	messageOutput mOut = new messageOutput();
	mOut.setResult("false"); 
	mOut.setMessage("person id already exist ");
	return mOut;
}
		  
	  }
	  
	  // deleting Person
	  
	  
	  @RequestMapping(value = "/delete/{key}", method = RequestMethod.GET, produces="application/json")
	  public @ResponseBody messageOutput delete(@PathVariable(value = "key" , required = true) Integer key) {
		  List<Person> keyid = personRepo.findKey(key); 
		  messageOutput mOut = new messageOutput();
		  
		  if(keyid.size() !=0) {
			  personRepo.delete(key);
			  System.out.println("deleted from the database");
				mOut.setResult("true"); 
				mOut.setMessage("person has been succesfully deleted");
				return mOut;
		  
		  }else {
			  System.out.println("Has not been deleted from the database");
				mOut.setResult("false"); 
				mOut.setMessage(key +"doesnt exist");
				return mOut;
			  
		  }
	  }
		  
		  // info on specific person
		  @RequestMapping(value = "/get/{key}", method = RequestMethod.GET, produces="application/json")
		  public @ResponseBody Object getInfo(@PathVariable(value = "key" , required = true) Integer key) {
			  List<Person> keyid = personRepo.findKey(key); 
			  messageOutput mOut = new messageOutput();
			  
			  if(keyid.size() !=0) {
				  System.out.println("the choosen user");
				  return keyid;
				
			  }else {
				  System.out.println("They dont exist");
					mOut.setResult("false"); 
					mOut.setMessage(key +"doesnt exist");
					return mOut;
				  
			  }
	  }



}
