package com.oneler.service.impl;

import com.oneler.domain.Person;
import com.oneler.repository.UserMapper;
import com.oneler.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<Person> findUsers() {
        return userMapper.findAll();
    }

    @Override
    public Person savePerson(Person p) {
        return userMapper.save(p);
    }
}
