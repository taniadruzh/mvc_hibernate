package com.mvcTest.entity.entityAssociation.oneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Двунаправленная связь (Bidirectional Association),
 * имеет место быть искусственно создано  только в ORM, и Hibernate  не исключение, он поддерживает такие связи  но,
 * в реляционных базах данных,   стандартом такое не предусмотрено. Рассмотрим следующий пример, связь Person(one) <-> Event(one)
 * через foreign-key, сущность Person3 осталось неизменной приведем её:
 *
 * При этом генерируются похожие sql  схемы как  у однонаправленной  ассоциации,
 * и мы получаем возможность из сущности Event3, получить сущность Person,
 * и наоборот из Person, сущность Event3 . Можно подобным образом  преобразовать однонаправленные  ассоциации связей one-to-one(primary key)
 * и one-to-one (join table)  добавив к ним сущность  и аннотацию @OneToOne(mappedBy = …).
 */

@Entity
@Table(name = "event3")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event3")
    private long id;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthDate;

    @OneToOne(mappedBy = "event3")
    private Person person;

    public Event3(Date birthDate) {
        this.birthDate = birthDate;
    }

}
