package co.edu.unisabana.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Roles {

    @Id
    @Column
    private String Nombre;

    @Column
    private String Responsibilidades;
}
