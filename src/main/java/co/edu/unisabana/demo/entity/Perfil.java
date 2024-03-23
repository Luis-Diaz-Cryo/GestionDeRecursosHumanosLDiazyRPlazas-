package co.edu.unisabana.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Perfil {


    @Id
    @Column
    private Integer empId;

    @Column
    private String habilidades;

    @Column
    private String experencias;

    @Column
    private String certificaciones;


}
