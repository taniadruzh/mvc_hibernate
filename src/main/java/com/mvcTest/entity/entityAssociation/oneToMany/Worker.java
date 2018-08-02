package com.mvcTest.entity.entityAssociation.oneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


/**
 *
 * однонаправленная  связь  one-to-many  через foreign-key,  связь представлена двумя сущностями  Worker(one) -> WorkerTask(many) .
 * Описывается  эта связь через аннотацию @OneToMany() в сущности Worker,
 * так же нам нужно установить связь foreign-key  между двумя сущностями поможет нам в этом аннотация @JoinColumn(),
 * name – описывает поле связи в таблице WorkerTask,  referencedColumnName – поле связи в таблице PersonsM:
 *
 *
 *
 */
@Entity
@Table(name = "worker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_worker")
//    private Long id;
//    @Column
//    private String name;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_worker_task", referencedColumnName = "id_worker")
//    private Set<WorkerTask> workerTasks;
//
//    public Worker(String name, Set<WorkerTask> workerTasks) {
//        this.name = name;
//        this.workerTasks = workerTasks;
//    }



    /**
     *
     * реализуем связь через таблицу (join table), для этого будем использовать  аннотацию @JoinTable(),
     * где атрибут name задает имя таблицы связи,  атрибут joinColumns связывает поле таблицы Worker с таблицей persons_2_to_workerTask,
     * атрибут inverseJoinColumns связывает поле таблицы WorkerTask с таблицей persons_2_to_workerTask

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_worker")
    private Long id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "persons_2_to_workerTask",
            joinColumns = @JoinColumn(name = "id_worker"),
            inverseJoinColumns = @JoinColumn(name = "id_event"))
    private Set<WorkerTask> workerTasks;

    public Worker(String name, Set<WorkerTask> workerTasks) {
        this.name = name;
        this.workerTasks = workerTasks;
    }
}
