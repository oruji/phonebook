package com.aminpy.phonebook.model.person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.aminpy.phonebook.model.contactnumber.ContactNumber;

@Entity
@NamedQueries({
		@NamedQuery(name = "Person.findAll", query = "SELECT p from Person p"),
		@NamedQuery(name = "Person.findByNationalCode", query = "SELECT p FROM Person p WHERE p.nationalCode = :nationalCode") })
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personID;

	private String firstName;

	private String lastName;

	private String nationalCode;

	@ManyToOne
	@JoinColumn(name = "marriageStatusID")
	private MarriageStatus marriageStatus;

	@OneToMany(mappedBy = "person")
	private List<ContactNumber> contactNumList;

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public MarriageStatus getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(MarriageStatus marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public List<ContactNumber> getContactNumList() {
		return contactNumList;
	}

	public void setContactNumList(List<ContactNumber> contactNumList) {
		this.contactNumList = contactNumList;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
