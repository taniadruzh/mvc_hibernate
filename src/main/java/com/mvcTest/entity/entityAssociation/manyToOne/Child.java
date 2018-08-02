package com.mvcTest.entity.entityAssociation.manyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 *
 * many-to-one, реализовав связь через  foreign-key.
 * Описывается эта связь через аннотацию @ManyToOne(), и помогает связать нам поля сущностей,
 * знакомая аннотация @JoinColumn(), где атрибут name будет описывать поле таблицы Child,
 * а атрибут referencedColumnName – поле таблицы Matinee.
 *
 *
 */

@Entity
@Table(name="child")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_child")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_matinee",referencedColumnName = "id_matinee")
    private Matinee matinee;

    private String name;

    public Child(Matinee matinee, String name) {
        this.matinee = matinee;
        this.name = name;
    }
}
