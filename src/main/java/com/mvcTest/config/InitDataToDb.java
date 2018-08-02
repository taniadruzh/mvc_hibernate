package com.mvcTest.config;

import com.mvcTest.dao.*;
import com.mvcTest.entity.MenuObject;
import com.mvcTest.entity.Student;
import com.mvcTest.entity.StudentTask;
import com.mvcTest.entity.entityAssociation.manyToOne.Child;
import com.mvcTest.entity.entityAssociation.manyToOne.Matinee;
import com.mvcTest.entity.entityAssociation.oneToMany.Worker;
import com.mvcTest.entity.entityAssociation.oneToMany.WorkerTask;
import com.mvcTest.entity.entityAssociation.oneToOne.Event3;
import com.mvcTest.entity.entityAssociation.oneToOne.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class InitDataToDb {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private WorkerDao workerDao;

    @Autowired
    private ChildDao childDao;

    @Autowired
    private MenuDao menuDao;


    @PostConstruct
    private void init() {


        MenuObject menuObject = new MenuObject("bjj");
        MenuObject menuObject1 = new MenuObject("box");
        MenuObject menuObject2 = new MenuObject("home");

        menuDao.saveOrUpdate(menuObject);
        menuDao.saveOrUpdate(menuObject1);
        menuDao.saveOrUpdate(menuObject2);

        Student student = new Student();
        List<StudentTask> studentTaskList = new ArrayList<>();
        StudentTask studentTask1 = new StudentTask("task1", student);
        StudentTask studentTask2 = new StudentTask("task2", student);
        StudentTask studentTask3 = new StudentTask("task3", student);
        StudentTask studentTask4 = new StudentTask("task4", student);
        StudentTask studentTask5 = new StudentTask("tasck5", student);

        studentTaskList.add(studentTask1);
        studentTaskList.add(studentTask2);
        studentTaskList.add(studentTask3);
        studentTaskList.add(studentTask4);
        studentTaskList.add(studentTask5);


        student.setPhone("12345");
        student.setName("ivan");
        student.setTaskList(studentTaskList);

        studentDao.saveOrUpdate(student);


        //Todo init one to one Person/Event

        //  Todo 1
//        Event event = new Event(new Date());
//        Person person = new Person("Ivan", event);
//        personDao.saveOrUpdate(person);
        //  Todo 2
//        Event2 event = new Event2(new Date());
//        Person person = new Person("Ivan", event);
//        personDao.saveOrUpdate(person);

        //  Todo 3
        Event3 event = new Event3(new Date());
        Person person = new Person("Ivan", event);
        personDao.saveOrUpdate(person);


        //Todo init one to many Worker/WorkerTask

        //Todo 1
//        Set<WorkerTask> taskList = new HashSet<>(Collections.singletonList(new WorkerTask("first task")));
//        Worker worker = new Worker("Ilon", taskList);
//        workerDao.saveOrUpdate(worker);

        //Todo 2

        Set<WorkerTask> taskList = new HashSet<>(Collections.singletonList(new WorkerTask("first task")));
        Worker worker2 = new Worker("Ilon", taskList);
        workerDao.saveOrUpdate(worker2);

        //Todo init many to one Worker/WorkerTask

        Matinee matinee = new Matinee("lol");
        Child child = new Child(matinee,"Olaf");
        child.setMatinee(matinee);
        childDao.saveOrUpdate(child);

    }

}
