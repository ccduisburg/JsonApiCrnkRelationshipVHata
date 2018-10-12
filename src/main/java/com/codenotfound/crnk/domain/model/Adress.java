package com.codenotfound.crnk.domain.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="adress")
@Data
@JsonApiResource(type="p_adress")
public class Adress {
        @Id
//    @GeneratedValue
        @Column(name="id")
        @JsonApiId
        private long id;
        private String strasse;
        private int hnummer;
        private String PLZ;
        private String city;

    public Adress(long id, String strasse, int hnummer, String PLZ, String city) {
        this.id = id;
        this.strasse = strasse;
        this.hnummer = hnummer;
        this.PLZ = PLZ;
        this.city = city;
    }
    public Adress() {

    }

}
