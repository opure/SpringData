package com.oneler.service;

import com.oneler.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> findUsers();

    Person savePerson(Person p);
}
