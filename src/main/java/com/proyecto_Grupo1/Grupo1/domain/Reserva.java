package com.proyecto_Grupo1.Grupo1.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="reserva")

public class Reserva implements Serializable
{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idcliente;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String personas;
    private String lugar;
    private String fechaE;
    private String fechaS;

    public Reserva() {
    }

    public Reserva(Long idcliente, String nombre, String apellidos, String cedula, String personas, String lugar, String fechaE, String fechaS) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.personas = personas;
        this.lugar = lugar;
        this.fechaE = fechaE;
        this.fechaS = fechaS;
    }

    

   
    
    
}