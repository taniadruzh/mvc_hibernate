package com.mvcTest.entity.entityAssociation.oneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Table(name="worker_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String task;

    public WorkerTask(String task) {
        this.task = task;
    }
}
