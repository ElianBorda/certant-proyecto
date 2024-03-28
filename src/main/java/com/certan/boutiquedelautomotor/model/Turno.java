package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaHora;
    private String patenteVehiculo;
    private String nombreCliente;
    @ManyToOne
    private List<Servicio> serviciosContratados;
    private Long precioTotal;

    public Turno(LocalDate fechaHora, String patenteVehiculo, String nombreCliente, ArrayList<Servicio> serviciosContratados) {
        this.fechaHora            = fechaHora;
        this.patenteVehiculo      = patenteVehiculo;
        this.nombreCliente        = nombreCliente;
        this.serviciosContratados = serviciosContratados;
        this.precioTotal          = this.preciosDeServicio(serviciosContratados);
    }

    public Long getPrecioTotal() {
        return precioTotal;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Servicio> getServiciosContratados() {
        return serviciosContratados;
    }

    private Long preciosDeServicio(ArrayList<Servicio> serviciosContratados) {
        return (long) serviciosContratados.size();
    }
}
