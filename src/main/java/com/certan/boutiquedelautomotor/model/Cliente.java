package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String patenteVehiculo;

    @OneToMany
    private List<Turno> turnosRealizados;


    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String patenteVehiculo) {
        this.turnosRealizados = new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.patenteVehiculo = ValidadorDePatente.validarPatente(patenteVehiculo);
    }

    public List<Turno> getTurnosRealizados() {
        return turnosRealizados;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public void agregarTurno(Turno turno) {
        this.turnosRealizados.add(turno);
    }

    public int cantidadDeTurnos() {
        return this.turnosRealizados.size();
    }
}
