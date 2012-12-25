package com.aminpy.phonebook.dao;

import java.util.List;
import com.aminpy.phonebook.model.Person;

public interface PersonDAOLocal {
	public Person createPerson(Person person);

	public List<Person> readPerson();

	public List<Person> personRead(Person person);

	public Person personUpdate(Person person);

	public Person deletePerson(Person person);
}
