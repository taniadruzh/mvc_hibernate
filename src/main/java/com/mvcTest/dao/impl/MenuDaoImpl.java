package com.mvcTest.dao.impl;

import com.mvcTest.dao.MenuDao;
import com.mvcTest.entity.MenuObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MenuDaoImpl implements MenuDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MenuObject> menuList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<MenuObject> theQuery = currentSession.createQuery("from MenuObject", MenuObject.class);
        return theQuery.getResultList();
    }

    @Override
    public void remove(MenuObject menu) {

    }

    @Override
    public void saveOrUpdate(MenuObject menu) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(menu);
    }
}
