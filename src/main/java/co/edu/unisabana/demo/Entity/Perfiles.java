package co.edu.unisabana.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Perfiles {



    @Id
    @Column
    private Integer empId;

    @Column
    private String Habilidades;

    @Column
    private String Experencias;

    @Column
    private String Certificaciones;




}
