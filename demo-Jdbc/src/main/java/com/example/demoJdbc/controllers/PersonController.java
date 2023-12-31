package com.example.demoJdbc.controllers;

import com.example.demoJdbc.DAOs.Person;
import com.example.demoJdbc.DBManager.DBOperations;
import com.example.demoJdbc.Requests.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping(value = "/getPersons")
    public List<Person> getPersons() throws SQLException {

        // calling dao to get object from db
        return DBOperations.getPersons();

    }

    @RequestMapping(value = "/createTable", method = RequestMethod.POST)
    public void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBOperations.createTable(name);
    }

    @RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {

        DBOperations.insertPerson(request);
    }



}
