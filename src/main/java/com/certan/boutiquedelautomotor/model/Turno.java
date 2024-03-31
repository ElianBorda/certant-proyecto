package com.certan.boutiquedelautomotor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "TURNO")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHora;
    @ManyToOne
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Servicio> serviciosContratados;
    private Double precioTotal;


    public Turno(){

    }

    public Turno(LocalDateTime fechaHora, List<Servicio> serviciosContratados, Cliente cliente) {
        this.cliente              = cliente;
        this.fechaHora            = fechaHora;
        this.serviciosContratados = serviciosContratados;
        this.precioTotal          = this.preciosDeServicios(serviciosContratados);
        this.cliente.agregarTurno(this);
        this.serviciosContratados.forEach(servicio -> servicio.setTurno(this));
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setServiciosContratados(List<Servicio> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Servicio> getServiciosContratados() {
        return serviciosContratados;
    }

    public Long getId() {
        return id;
    }

    private Double preciosDeServicios(List<Servicio> serviciosContratados) {
        return serviciosContratados.stream().map(Servicio::getPrecio).reduce(0.0, Double::sum);
    }

    public Integer cantidadDeServicios() {
        return this.serviciosContratados.size();
    }
}
