package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.*;

import java.util.List;

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String patenteVehiculo;
    @OneToMany
    private List<Servicio> serviciosContratados;

    public Cliente(String nombre, String apellido, String patenteVehiculo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.patenteVehiculo = patenteVehiculo;
    }

    public Long getId() {
        return id;
    }

    public List<Servicio> getServiciosContratados() {
        return serviciosContratados;
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
}
