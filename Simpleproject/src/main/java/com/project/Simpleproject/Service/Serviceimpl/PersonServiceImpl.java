package com.project.Simpleproject.Service.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

import com.project.Simpleproject.Model.Person;
import com.project.Simpleproject.Repository.PersonRepository;
import com.project.Simpleproject.Service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        
        String password = generatePassword(person.getFirstName(), person.getMiddleName(), person.getLastName());
        person.setPassword(password);
        return personRepository.save(person);
    }

    private String generatePassword(String firstName, String middleName, String lastName) {
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        String password = firstName.substring(0, Math.min(2, firstName.length())) +
                          middleName.substring(0, Math.min(2, middleName.length())) +
                          lastName.substring(0, Math.min(2, lastName.length())) +
                          randomNumber;
        return password;
    }
}