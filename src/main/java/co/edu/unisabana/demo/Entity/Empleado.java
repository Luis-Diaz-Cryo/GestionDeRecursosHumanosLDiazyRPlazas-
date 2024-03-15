package co.edu.unisabana.demo.Entity;

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
    private String Nombre;

    @Column
    private String Direccion;

    @Column
    private Integer Telefono;

    @Column
    private String Cargo;



}
