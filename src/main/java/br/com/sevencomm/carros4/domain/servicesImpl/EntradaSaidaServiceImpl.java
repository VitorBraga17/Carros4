package br.com.sevencomm.carros4.domain.servicesImpl;

import br.com.sevencomm.carros4.data.repositories.CarroRepository;
import br.com.sevencomm.carros4.data.repositories.EntradaSaidaRepository;
import br.com.sevencomm.carros4.domain.models.EntradaSaida;
import br.com.sevencomm.carros4.domain.services.EntradaSaidaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaSaidaServiceImpl implements EntradaSaidaService {

    private EntradaSaidaRepository _registroRepository;
    private CarroRepository _carroRepository;


    public EntradaSaidaServiceImpl(EntradaSaidaRepository registroRepository, CarroRepository carroRepository) {
        _registroRepository = registroRepository;
        _carroRepository = carroRepository;
    }

    public List<EntradaSaida> listEntradaSaidas() {
        return null;
    }

    public EntradaSaida createEntradaSaida(EntradaSaida registro) {
        return null;
    }

    public EntradaSaida updateEntradaSaida(EntradaSaida registro, Long id) {
        return null;
    }

    public EntradaSaida deleteEntradaSaida(Long id) {
        return null;
    }
}
