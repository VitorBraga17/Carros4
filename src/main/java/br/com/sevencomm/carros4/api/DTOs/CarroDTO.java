package br.com.sevencomm.carros4.api.DTOs;

public class CarroDTO {

    private String modelo;
    private String tipo;
    private boolean estacionado;
    private Long clienteId;


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

    public boolean isEstacionado() {return estacionado;}

    public void setEstacionado(boolean estacionado) {this.estacionado = estacionado;}

    public Long getClienteId() {return clienteId;}

    public void setClienteId(Long clienteId) {this.clienteId = clienteId;}
}

