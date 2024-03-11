package co.edu.unisabana.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Perfiles {



    @Id
    @Column
    private Integer id;

    @Column
    private String Habilidades;

    @Column
    private String Eperencias;

    @Column
    private Integer Certificaciones;


}
