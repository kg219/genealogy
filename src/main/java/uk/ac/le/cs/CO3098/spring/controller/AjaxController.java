package uk.ac.le.cs.CO3098.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class AjaxController {
	
	  @Autowired
	  PersonRepository personRepo;
	  
	  //adding a person
	
	  @RequestMapping(value = "/mKeyAJAX", method = RequestMethod.GET)
	  public @ResponseBody String checkMother(@RequestParam(value = "mkey", required =false)Object mKey, 
			  @RequestParam(value = "fkey", required =false) Object fKey,HttpServletRequest req) {
		  String message = "";
		  try {
			  if(mKey == null) {
				  mKey = req.getParameter("key");
			  
		  }
			
		 
		  List<Person>keyidmother = personRepo.findKey(mKey);
		  List<Person>keyidfather = personRepo.findKey(fKey);
		  
if(keyidmother.size() ==0 && keyidfather.size() ==0 ) {
	message = "doesntExist";
	System.out.println("you must choose an existing key for both");
}
if(keyidmother.size() ==0 && keyidfather.size() ==0 ) {
	message = "noMother";
	System.out.println("must choose an existing key for Mother");
}
if(keyidmother.size() ==0 && keyidfather.size() ==0 ) {
	message = "noFather";
	System.out.println("must choose an existing key for Father");
}
if(keyidmother.size() !=0 && keyidfather.size() !=0 ) {
	message = "OK";
	System.out.println("Good");
}


}catch(Exception e){
	e.printStackTrace();
	
}
		  return message;
	  }
	



}
