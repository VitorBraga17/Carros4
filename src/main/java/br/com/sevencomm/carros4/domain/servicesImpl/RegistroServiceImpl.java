package br.com.sevencomm.carros4.domain.servicesImpl;

import br.com.sevencomm.carros4.data.repositories.CarroRepository;
import br.com.sevencomm.carros4.data.repositories.RegistroRepository;
import br.com.sevencomm.carros4.domain.models.Registro;
import br.com.sevencomm.carros4.domain.services.RegistroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroServiceImpl implements RegistroService {

    private RegistroRepository _registroRepository;
    private CarroRepository _carroRepository;


    public RegistroServiceImpl(RegistroRepository registroRepository, CarroRepository carroRepository) {
        _registroRepository = registroRepository;
        _carroRepository = carroRepository;
    }

    public List<Registro> listRegistros() {
        return _registroRepository.findAll();
    }

    public Registro createRegistro(Registro registro) {
        return null;
    }

    public Registro updateRegistro(Registro registro, Long id) {
        return null;
    }

    public Registro deleteRegistro(Long id) {
        return null;
    }
}
