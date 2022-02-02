package com.stan.parcel.Percistance.Entities;

import javax.persistence.*;

@Entity
public class Configurations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String value;
    private String description;

    public Configurations(Long id) {
        this.id = id;
    }

    public Configurations() {

    }

    public Configurations(Long id, String value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Configurations{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
