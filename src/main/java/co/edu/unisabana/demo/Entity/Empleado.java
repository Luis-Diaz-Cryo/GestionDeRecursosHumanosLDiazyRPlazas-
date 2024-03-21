package co.edu.unisabana.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data

public class Empleado {

    @Id
    @Column
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private Integer telefono;

    @Column
    private String cargo;


}
