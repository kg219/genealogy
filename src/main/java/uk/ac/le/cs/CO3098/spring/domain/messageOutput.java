package uk.ac.le.cs.CO3098.spring.domain;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


//Uncomment annotations if you use Spring Data JPA

@JsonInclude(Include.NON_NULL)
public class messageOutput {
	String message;
	String result;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		
	}
	
public String getResult() {
	return result;
}
	
public void setResult(String result) {
	this.result = result;
}



}
