package com.codeup.springblog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "tiny int(3) unsigned", nullable = false, unique = true)
    private int age;
    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String name;
    @Column(columnDefinition = "char(2) Default 'XX'")
    private String resideState;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
