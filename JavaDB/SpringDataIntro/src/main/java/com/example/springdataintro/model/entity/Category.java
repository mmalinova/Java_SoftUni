package com.example.springdataintro.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
