package com.mvcTest.dao.impl;

import com.mvcTest.dao.ChildDao;
import com.mvcTest.entity.entityAssociation.manyToOne.Child;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ChildDaoImpl implements ChildDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Child> childList() {
        return null;
    }

    @Override
    public void remove(Child child) {

    }

    @Override
    public void saveOrUpdate(Child child) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(child);
    }
}
