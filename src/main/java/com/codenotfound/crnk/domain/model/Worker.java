package com.codenotfound.crnk.domain.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Worker")
@Data
@JsonApiResource(type="workers")
public class Worker extends Person{
//    @Id
////    @GeneratedValue
//    @Column(name="id")
//    @JsonApiId
//    private long id;
//    private String name;
//    private int age;
//    private double wage;
//    private boolean active;

    private String position;
    private Double Lohn;
    @ManyToOne
//    @JoinColumn(name="department_id")
    private Persondepartment department;


    public Worker() {
    }

    public Worker(String position, Double lohn, Persondepartment department) {
        this.position = position;
        Lohn = lohn;
        this.department = department;
    }

    public Worker(String name,String position, Double lohn, Persondepartment department) {
        super(name);
        this.position = position;
        Lohn = lohn;
        this.department = department;
    }


    public Worker(String position, Double lohn) {
        this.position = position;
        Lohn = lohn;
    }

    public Worker(String name,String position, Double lohn) {
        super(name);
        this.position = position;
        Lohn = lohn;
    }

}
