package com.mvcTest.dao;

import com.mvcTest.entity.entityAssociation.oneToOne.Person;

import java.util.List;


public interface PersonDao {

    List<Person> menuList();

    void remove(Person person);

    void saveOrUpdate(Person person);
}
