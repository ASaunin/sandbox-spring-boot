package com.asaunin.service;

import com.asaunin.domain.Person;
import com.asaunin.repository.PersonRepository;
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

    public Collection<Person> findAll() {
        return (Collection<Person>) personRepository.findAll();
    }

    public Person findByNickName(String nickName) {
        return personRepository.findByNickName(nickName);
    }
}
