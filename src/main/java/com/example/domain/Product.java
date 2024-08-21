package com.example.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product extends PanacheEntity {

    @NotBlank
    public String name;

    @NotNull
    public Double price;

    @NotBlank
    public String description;

}
