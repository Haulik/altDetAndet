package com.example.crud.repository;

import com.example.crud.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo implements IPersonRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> fetchAll() {
        String sql = "SELECT * FROM mydb.person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Person findPersonById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public boolean addPerson(Person p) {
        String sql ="INSERT INTO person VALUES (default,?,?)";
        return jdbcTemplate.update(sql, p.getFirst_name(), p.getLast_name()) >= 0;
    }

    @Override
    public boolean deletePerson(int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        System.out.println(id);
        return jdbcTemplate.update(sql, id) >=0;


    }

    @Override
    public boolean updatePerson(Person p) {
        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, p.getFirst_name(), p.getLast_name(), p.getId()) >= 0;
    }
}
