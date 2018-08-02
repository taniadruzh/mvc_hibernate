package com.mvcTest.entity.entityAssociation.oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * В мире реляционных баз данных существуют четыре типа связей,  которые  так же имеют место быть  и  в hibernate.  Перечислим их:
 *
 *1. One-to-one  -  Один к одному
 *2. Many-to-one  - Многие к одному.
 *3. One-to-many  - Один ко многим.
 *4. Many-to-many  -  Многие ко многим.
 *
 *
 *
*Если связь представлена в одном направлении между двумя сущностями,
*т. е.  только из одной сущности можно получить  зависимые объекты,
* то такая связь называется,  однонаправленной  ассоциацией (Unidirectional Association).
*  Если из любой сущности можно получить зависимые объекты, то такая связь называется двунаправленной
*   (Bidirectional Association).  .
*   есть сущность Event, дата рождения, событие которое может произойти один раз в жизни у каждого человека,
*   описанного сущностью Person.  Связь Person(one) -> Event(one) однонаправленная,
*    описывается через аннотацию @OneToOne() в сущности Person,   связываем через  foreign-key две таблицы,
*     поможет нам в  этом аннотация @JoinColumn(name = "idF",referencedColumnName = "idE1"),
*      где name = "idF" – имя поля в таблице Prersons,
*       referencedColumnName = "idE1" – имя поля на которое ссылаемся в таблице Events:
 *       Доступ к объекту  происходит посредством кода person.getEvent().getBirthDate().toString(), при этом генерируется  такой sql  код:



 */

@Entity
@Table(name="event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private long id;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthDate;

    public Event(Date birthDate) {
        this.birthDate = birthDate;
    }
}
