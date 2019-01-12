package uk.ac.le.cs.CO3098.spring.domain;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;


//Uncomment annotations if you use Spring Data JPA

@Entity(name ="Person")
public class Person {
	@Id
	@Column(name="perso_key", unique=true, nullable= false)
     int key;
	@Column(name="Fullname", nullable= false)
    private String name;
	@Column(name = "Father_key", nullable= false)
	private transient int fatherKey ;
	@Column(name="Mother_key", nullable = false)
	private transient int motherKey;
	@Column(name="dob", nullable= false)
	private transient int DateOfBirth;
	@Column(name="gender", nullable = false)
	 String gender;
	
	@JsonProperty("key")
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("m")
	public int getMotherKey() {
		return motherKey;
	}
	public void setMotherKey(int motherKey) {
		this.motherKey = motherKey;
	}
	@JsonProperty("f")
	public int getFatherKey() {
		return fatherKey;
	}
	public void setFatherKey(int fatherKey) {
		this.fatherKey = fatherKey;
	}
	
	@JsonProperty("dob")
	public int getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	@JsonProperty("g")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	public Person(int key, String name) {
		super();
		this.key = key;
		this.name = name;
	}


	public Person(int key, String name, int motherKey, int fatherKey, int dateOfBirth, String gender) {
		super();
		this.key = key;
		this.name = name;
		this.motherKey = motherKey;
		this.fatherKey = fatherKey;
		this.DateOfBirth = dateOfBirth;
		this.gender = gender;
	}



	//int key;	
//	String name;
	
//	int motherKey;
//	int fatherKey;
	//int DateOfBirth; //19921210->December 10th 1992 
//String gender;
	

}
