package com.example.springdataintro.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
    private String firstName;
    private String lastName;

    public Author() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
