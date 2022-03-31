package com.org.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
@Table(name = "employees")
public class Employee {

	/** The id. */
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The email. */
	@Column(name = "email")
	private String email;

	/** The dateofbirth. */
	@Column(name ="day_of_birth")
	private String dateofbirth;

	/** The phonenumber. */
	@Column(name ="phone_number")
	private String phonenumber;

	/** The gender. */
	@Column(name ="gender")
	private String gender ;

	/** The experience. */
	@Column(name ="experience")
	private String experience ;

	/** The maritalstatus. */
	@Column(name ="marital_status")
	private String maritalstatus ;

	/** The qualification. */
	@Column(name ="qualification ")
	private String qualification  ;

	/**
	 * Gets the experience.
	 *
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	
	/**
	 * Sets the experience.
	 *
	 * @param experience the new experience
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	/**
	 * Gets the maritalstatus.
	 *
	 * @return the maritalstatus
	 */
	public String getMaritalstatus() {
		return maritalstatus;
	}
	
	/**
	 * Sets the maritalstatus.
	 *
	 * @param maritalstatus the new maritalstatus
	 */
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	
	/**
	 * Gets the qualification.
	 *
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	
	/**
	 * Sets the qualification.
	 *
	 * @param qualification the new qualification
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	/**
	 * Gets the dateofbirth.
	 *
	 * @return the dateofbirth
	 */
	public String getDateofbirth() {
		return dateofbirth;
	}
	
	/**
	 * Sets the dateofbirth.
	 *
	 * @param dateofbirth the new dateofbirth
	 */
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * Gets the phonenumber.
	 *
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}	
	/**
	 * Sets the phonenumber.
	 *
	 * @param phonenumber the new phonenumber
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}