package com.example.crud.service;

import com.example.crud.model.Person;
import com.example.crud.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    @Autowired
    IPersonRepo personRepo;
    @Override
    public List<Person> fetchAll() {
        return personRepo.fetchAll();
    }

    @Override
    public Person findPersonById(int id) {
        return personRepo.findPersonById(id);
    }

    @Override
    public boolean addPerson(Person p) {
        return personRepo.addPerson(p);
    }

    @Override
    public boolean deletePerson(int id) {
        return personRepo.deletePerson(id);
    }

    @Override
    public boolean updatePerson(Person p) {
        return personRepo.updatePerson(p);
    }
}
