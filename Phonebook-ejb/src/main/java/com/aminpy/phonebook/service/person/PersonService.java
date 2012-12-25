package com.aminpy.phonebook.service.person;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.aminpy.phonebook.dao.person.PersonDAOLocal;
import com.aminpy.phonebook.exception.person.NationalCodeDuplicationException;
import com.aminpy.phonebook.model.Person;

@Stateless
public class PersonService implements PersonServiceLocal {

	@EJB
	private PersonDAOLocal personDAO;

	@Override
	public boolean isNationalCodeExist(String nationalCode)
			throws NationalCodeDuplicationException {
		if (personDAO.personRead(nationalCode).isEmpty()) {
			return false;
		}
		throw new NationalCodeDuplicationException("National Code already exist!");
	}

	@Override
	public Person personAdd(Person person) {
		return personDAO.personCreate(person);
	}

	@Override
	public List<Person> personFindAll() {
		return personDAO.personRead();
	}

	@Override
	public Person personRemove(Person person) {
		return personDAO.personDelete(person);
	}

	@Override
	public Person personEdit(Person person) {
		return personDAO.personUpdate(person);
	}
}
