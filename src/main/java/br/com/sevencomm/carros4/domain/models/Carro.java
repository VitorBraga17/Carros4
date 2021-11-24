package br.com.sevencomm.carros4.domain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String tipo;
    private Boolean estacionado;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @JsonManagedReference
    @OneToMany(mappedBy = "carro",fetch = FetchType.EAGER)
    private List<EntradaSaida> registros;


    public Carro(){}

    public Carro(Long id, String modelo, String tipo, Boolean estacionado) {
        this.id = id;
        this.modelo = modelo;
        this.tipo = tipo;
        this.estacionado = estacionado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstacionado() {
        return estacionado;
    }

    public void setEstacionado(Boolean estacionado) {
        this.estacionado = estacionado;
    }

    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public Cliente getCliente() {
        return cliente;
    }

}

