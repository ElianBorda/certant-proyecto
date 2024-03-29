package com.certan.boutiquedelautomotor.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "TURNO")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaHora;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Servicio> serviciosContratados;
    final private Double precioTotal;

    public Turno(ArrayList<Servicio> serviciosContratados, Cliente cliente) {
        this.cliente              = cliente;
        this.fechaHora            = LocalDate.now();
        this.serviciosContratados = serviciosContratados;
        this.precioTotal          = this.preciosDeServicios(serviciosContratados);
        this.cliente.agregarTurno(this);
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }


    public Long getId() {
        return id;
    }

    private Double preciosDeServicios(ArrayList<Servicio> serviciosContratados) {
        return serviciosContratados.stream().map(Servicio::getPrecio).reduce(0.0, Double::sum);
    }

    public Integer cantidadDeServicios() {
        return this.serviciosContratados.size();
    }
}
