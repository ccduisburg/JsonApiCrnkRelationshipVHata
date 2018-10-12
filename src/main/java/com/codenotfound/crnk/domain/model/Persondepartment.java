package com.codenotfound.crnk.domain.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="department")
@Data
@JsonApiResource(type="departments")
public class Persondepartment implements Serializable {
    @Id
    @Column(name="ID")
    @GeneratedValue
    @JsonApiId
    private Integer id;
    private String name;
    private String Supervisor;

    @OneToMany
    private List<Worker> workers;

    public Persondepartment(String name, String supervisor) {
        this.name = name;
        Supervisor = supervisor;
    }

    public Persondepartment() {

    }
}
