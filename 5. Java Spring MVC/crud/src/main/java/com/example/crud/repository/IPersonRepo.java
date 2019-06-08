package com.example.crud.repository;

import com.example.crud.model.Person;

import java.util.List;

public interface IPersonRepo {

    List<Person> fetchAll();
    Person findPersonById(int id);
    boolean addPerson(Person p);
    boolean deletePerson(int id);
    boolean updatePerson(Person p);
}
