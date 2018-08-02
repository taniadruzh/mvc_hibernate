package com.mvcTest.entity.entityAssociation.manyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="matinee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matinee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matinee")
    private long id;
    @Column
    private String title;

    public Matinee(String title) {
        this.title = title;
    }
}
