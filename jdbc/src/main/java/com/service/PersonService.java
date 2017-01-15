package com.service;

import com.model.Person;
import com.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id);
    }

    public Person findByNickName(String nickName) {
        return personRepository.findByNickName(nickName);
    }

    public Collection<Person> findAll() {
        return personRepository.findAll();
    }

}
