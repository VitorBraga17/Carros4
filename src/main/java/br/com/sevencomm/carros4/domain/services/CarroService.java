package br.com.sevencomm.carros4.domain.services;

import br.com.sevencomm.carros4.api.DTOs.CarroDTO;
import br.com.sevencomm.carros4.domain.models.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {
    List<Carro> listCarros();
    Optional<Carro> findCarroById(Long id);
    Carro createCarro(CarroDTO carroDTO);
    Carro updateCarro(CarroDTO carroDTO,Long id);
    Carro deleteCarro(Long id);
    Carro park(Long id);
    Carro depart(Long id);
}
