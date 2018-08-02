package com.mvcTest.entity.entityAssociation.oneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {

    //Todo первый способ

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_person")
//    private Long idP;
//    @Column
//    private String name;
//    @OneToOne(fetch =  FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "id_event", referencedColumnName = "id_event" )
//    private Event event;
//
//    public Person(String name, Event event) {
//        this.name = name;
//        this.event = event;
//    }


//    //Todo второй способ
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_person")
//    private Long id;
//
//    @Column
//    private String name;
//
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(name = "Persons_to_Events"
//            , joinColumns = @JoinColumn(name = "id_person")
//            , inverseJoinColumns = @JoinColumn(name = "id_event2"))
//    private Event2 event2;
//
//    public Person(String name, Event2 event2) {
//        this.name = name;
//        this.event2 = event2;
//    }

    //Todo 3-й способ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private long id;
    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_event", referencedColumnName = "id_event3")
    private Event3 event3;

    public Person(String name, Event3 event3) {
        this.name = name;
        this.event3 = event3;
    }


}
