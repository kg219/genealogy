package uk.ac.le.cs.CO3098.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.ac.le.cs.CO3098.spring.domain.Person;
import uk.ac.le.cs.CO3098.spring.domain.messageOutput;
import uk.ac.le.cs.CO3098.spring.repository.PersonRepository;
import uk.ac.le.cs.CO3098.spring.service.PersonService;

@Controller
@RequestMapping(value = {"/FamilyTree"})
public class TreeController {
	  @Autowired
	  PersonService ps;
	  
	  @Autowired
	  PersonRepository personRepo;
	  
	 @RequestMapping(value ="/add")
	 public ModelAndView add() {
		 return new ModelAndView("add");
	 }
	 @RequestMapping(value ="/search")
	 public ModelAndView search() {
		 return new ModelAndView("search");
	 }
	 @RequestMapping(value ="/tree")
	 public ModelAndView listAll(Model model) {
		 return new ModelAndView("tree", "person", ps.findAllPersons());
	 }
	 
	
	  @RequestMapping(value = "/revised", method = RequestMethod.POST)
	  public @ResponseBody ModelAndView revised(@RequestParam(value = "key", required =true)Object key, 
			  @RequestParam(value = "name", required =false) Object name,
			  @RequestParam(value = "dob", required =false )Object dob,
			  @RequestParam(value = "m", required =false)Object mKey,
			  @RequestParam(value = "f", required =false)Object fKey,
			  @RequestParam(value = "g", required =false)String gender, HttpServletRequest req){
//		  
//		  List<Person>keyid = personRepo.findKey(key);
//		  List<Person>keyidmother = personRepo.findKey(mKey);
//		  List<Person>keyidfather = personRepo.findKey(fKey);
		  
if(key == null|| name == null || dob ==null ||  mKey ==null || fKey ==null ||  gender ==null) {
	key = req.getParameter("key");
	name = req.getParameter("name");
	dob = req.getParameter("dateOfBirth");
	mKey = req.getParameter("motherKey");
	fKey = req.getParameter("fatherKey");
	gender = req.getParameter("gender");
}
personRepo.edit(key,name,dob,mKey,fKey,gender);
return new ModelAndView("redirect:../FamilyTree/settings");

  
	  }
	  
	  
		
		 
		  @RequestMapping(value = "/new", method = RequestMethod.POST)
		  public @ResponseBody ModelAndView add(@RequestParam(value = "key", required =true)Integer key, 
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

		return new ModelAndView("redirect:famTree");
	}else  {
		System.out.println("the parent id has not been provided");
		messageOutput mOut = new messageOutput();
		mOut.setResult("false"); 
		mOut.setMessage("mother or father key doesnt exist ");
		return new ModelAndView("redirect:errors");
	}

	}else {
		System.out.println("key already exist ");
		messageOutput mOut = new messageOutput();
		mOut.setResult("false"); 
		mOut.setMessage("person id already exist ");
		return new ModelAndView("redirect:error");
	}
			  
		  }
		  
		 



}
