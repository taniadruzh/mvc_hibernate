package com.mvcTest.dao;

import com.mvcTest.entity.entityAssociation.manyToOne.Child;

import java.util.List;

public interface ChildDao {

    List<Child> childList();

    void remove(Child child);

    void saveOrUpdate(Child child);
}
