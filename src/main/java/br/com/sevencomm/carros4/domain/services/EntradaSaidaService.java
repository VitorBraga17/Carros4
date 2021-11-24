package br.com.sevencomm.carros4.domain.services;

import br.com.sevencomm.carros4.domain.models.EntradaSaida;

import java.util.List;

public interface EntradaSaidaService {

    List<EntradaSaida> listEntradaSaidas();
    EntradaSaida createEntradaSaida(EntradaSaida registro);
    EntradaSaida updateEntradaSaida(EntradaSaida registro, Long id);
    EntradaSaida deleteEntradaSaida(Long id);

}
