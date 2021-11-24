package br.com.sevencomm.carros4.domain.servicesImpl;

import br.com.sevencomm.carros4.api.DTOs.CarroDTO;
import br.com.sevencomm.carros4.data.repositories.CarroRepository;
import br.com.sevencomm.carros4.data.repositories.ClienteRepository;
import br.com.sevencomm.carros4.domain.models.Carro;
import br.com.sevencomm.carros4.domain.models.Cliente;
import br.com.sevencomm.carros4.domain.services.CarroService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroServicesImpl implements CarroService {

    private CarroRepository _carroRepository;
    private ClienteRepository _clienteRepository;

    public  CarroServicesImpl (CarroRepository carroRepository,ClienteRepository clienteRepository){
        _carroRepository = carroRepository;
        _clienteRepository = clienteRepository;
    }

    public List<CarroDTO> listCarros() {
        List<Carro> carros = _carroRepository.findAll();
        List<CarroDTO> carrosDTO = new ArrayList<>();

        //carrosDTO = carros.stream().map(CarroDTO::toDTO).collect(Collectors.toList());
        for (Carro c : carros) {
            CarroDTO cDTO = CarroDTO.toDTO(c);
            carrosDTO.add(cDTO);
        }

        return carrosDTO;
    }

    public CarroDTO getCarroById(Long id) {
        Optional<Carro> carro = _carroRepository.findById(id);
        if(carro.isPresent()){
            CarroDTO carroDTO = CarroDTO.toDTO(carro.get());
            return carroDTO;
        } else {
            throw new IllegalArgumentException("Carro Not Found!");
        }
    }

    public Carro createCarro(CarroDTO carroDTO) {
        Carro carro = new Carro();
        Optional<Cliente> cliente = _clienteRepository.findById(carroDTO.getClienteId());

        if((carroDTO.getModelo().equals("")) || (carroDTO.getModelo()== null))
            throw new IllegalArgumentException("Modelo field is empty");
        if((carroDTO.getTipo().equals("")) || (carroDTO.getTipo()== null))
            throw new IllegalArgumentException("Tipo field is empty");

        carro.setModelo(carroDTO.getModelo());
        carro.setTipo(carroDTO.getTipo());
        carro.setEstacionado(false);
        carro.setCliente(cliente.orElse(null));
        return _carroRepository.save(carro);
    }

    public Carro updateCarro(CarroDTO carroDTO, Long id) {
        Optional<Carro> carro = _carroRepository.findById(id);
        Optional<Cliente> cliente = _clienteRepository.findById(carroDTO.getClienteId());

        if ((carroDTO.getModelo().equals("")) || (carroDTO.getModelo() == null))
            throw new IllegalArgumentException("Modelo field is empty");
        if ((carroDTO.getTipo().equals("")) || (carroDTO.getTipo() == null))
            throw new IllegalArgumentException("Tipo field is empty");//javax.validation

        if (carro.isPresent()) {
            Carro updateCarro = carro.get();

            updateCarro.setTipo(carroDTO.getTipo());
            updateCarro.setModelo(carroDTO.getModelo());
            updateCarro.setEstacionado(carroDTO.isEstacionado());
            updateCarro.setCliente(cliente.orElse(null));

            return _carroRepository.save(updateCarro);
        } else{
            throw new IllegalArgumentException("Carro not found!");
        }
    }

    public Carro deleteCarro(Long id) {
        Optional<Carro> carro = _carroRepository.findById(id);
        if (carro.isPresent()) {
            _carroRepository.delete(carro.get());
            return carro.get();
        } else {
            throw new IllegalArgumentException("Carro not found!");
        }
    }

    public Carro entradaCarro(Long id) {
        Optional<Carro> carro = _carroRepository.findById(id);

        if (carro.isPresent()){
            if(!carro.get().getEstacionado()){
                Carro parkCar = carro.get();
                parkCar.setEstacionado(true);
                carro.get().setEstacionado(true);
                return _carroRepository.save(parkCar);
            } else{
                throw new IllegalArgumentException("Carro already Parked!");
            }
        }
        else{
            throw new IllegalArgumentException("Carro not found!");
        }
    }

    public Carro saidaCarro(Long id) {
        Optional<Carro> carro = _carroRepository.findById(id);

        if (carro.isPresent()){
            if(carro.get().getEstacionado()){
                Carro parkCar = carro.get();
                parkCar.setEstacionado(false);
                return _carroRepository.save(parkCar);
            }
            else{
                throw new IllegalArgumentException("Carro already Departed!");
            }
        }
        else{
            throw new IllegalArgumentException("Carro not found!");
        }
    }

}
