package br.com.sevencomm.carros4.api.DTOs;

import br.com.sevencomm.carros4.domain.models.Carro;

public class CarroDTO {

    private Long id;
    private String modelo;
    private String tipo;
    private boolean estacionado;
    private Long clienteId;

    public CarroDTO() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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

    public static CarroDTO toDTO(Carro carro){
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(carro.getId());
        carroDTO.setModelo(carro.getModelo());
        carroDTO.setTipo(carro.getTipo());
        carroDTO.setEstacionado(carro.getEstacionado());
        carroDTO.setClienteId(carro.getCliente().getId());

        return carroDTO;
    }
}

