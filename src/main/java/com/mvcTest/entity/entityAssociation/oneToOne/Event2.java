package com.mvcTest.entity.entityAssociation.oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Следующий пример, рассматриваем  ту же связь one-to-one,
 * но связаны  сущности  через таблицу связи (join table)  Persons_to_Events ,
 * описать такую связь помогает нам  аннотация @JoinTable( name = "Persons_to_Events" , joinColumns= @JoinColumn(name = "id_person"),
 * inverseJoinColumns = @JoinColumn(name = "id_event2") ) , где  имя таблицы описывается в атрибуте name = "Persons_to_Events",
 * и два поля связи "id_person" и "id_event2"  посредством которых связываются две сущности
 *
 */

@Entity
@Table(name="event2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event2 {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event2")
    private long id;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthDate;

    public Event2(Date birthDate) {
        this.birthDate = birthDate;
    }

}
