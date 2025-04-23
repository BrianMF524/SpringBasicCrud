package com.restexplorer.app.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    @Getter
    private String titulo;
    private String descripcion;

}
