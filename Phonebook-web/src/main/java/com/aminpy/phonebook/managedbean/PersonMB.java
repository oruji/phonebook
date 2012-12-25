package com.aminpy.phonebook.managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import com.aminpy.phonebook.model.Person;
import com.aminpy.phonebook.service.person.PersonServiceLocal;

@Named
@SessionScoped
public class PersonMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<Person> personList;
	private List<Person> filteredPersonList;
	@EJB
	private PersonServiceLocal personService;;
	private Person person;
	private Person selectedPerson;

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public List<Person> getFilteredPersonList() {
		return filteredPersonList;
	}

	public void setFilteredPersonList(List<Person> filteredPersonList) {
		this.filteredPersonList = filteredPersonList;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String personMng() {
		this.setPersonList(this.personService.personFindAll());
		return "/pages/person/personList.xhtml";
	}

	public void personDelete() {
		this.personService.personRemove(this.selectedPerson);
		this.personList.remove(this.personList.indexOf(this.selectedPerson));
	}

	public String personCreateLink() {
		this.person = new Person();
		return "/pages/person/personCreate.xhtml";
	}

	public String personCreate() {
		this.personService.personAdd(this.person);
		this.personList.add(this.person);

		return "/pages/person/personList.xhtml";
	}

	public String personUpdateLink() {
		this.setPerson(this.selectedPerson);
		return "/pages/person/personUpdate.xhtml";
	}

	public String personUpdate() {
		this.personService.personEdit(this.selectedPerson);
		return "/pages/person/personList.xhtml";
	}
}
