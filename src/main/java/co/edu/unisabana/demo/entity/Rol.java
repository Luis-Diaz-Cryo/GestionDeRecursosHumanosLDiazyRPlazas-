package co.edu.unisabana.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Rol {


    @Id
    @Column
    private String nombre;

    @Column
    private String responsibilidades;
}
