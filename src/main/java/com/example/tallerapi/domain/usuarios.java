package com.example.tallerapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data //Con esta anotacion de lombock hago que todos los atributos tengasn get y set
@AllArgsConstructor //Creo constructor completo
@NoArgsConstructor //Creo constructor vacio
//Le indico a la bbdd que es una tabla
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class usuarios {

    //Le indico las columnas y el ID autogenerado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String DNI;
    @Column
    private String email;
    @Column
    private String telefono;
    @Column(name = "fecha_nacimiento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNac;

    
    /*public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getfechaNac() {
        return fechaNac;
    }

    public void setfechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }*/
}
