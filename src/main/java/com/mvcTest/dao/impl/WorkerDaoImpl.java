package com.mvcTest.dao.impl;

import com.mvcTest.dao.WorkerDao;
import com.mvcTest.entity.entityAssociation.oneToMany.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class WorkerDaoImpl implements WorkerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Worker> workerList() {
        return null;
    }

    @Override
    public void remove(Worker worker) {

    }

    @Override
    public void saveOrUpdate(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(worker);
    }
}
