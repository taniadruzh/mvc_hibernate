package com.mvcTest.dao;

import com.mvcTest.entity.entityAssociation.oneToMany.Worker;

import java.util.List;

public interface WorkerDao {

    List<Worker> workerList();

    void remove(Worker worker);

    void saveOrUpdate(Worker worker);
}
