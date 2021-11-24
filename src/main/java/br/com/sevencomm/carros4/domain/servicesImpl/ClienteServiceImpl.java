package br.com.sevencomm.carros4.domain.servicesImpl;

import br.com.sevencomm.carros4.api.DTOs.ClienteDTO;
import br.com.sevencomm.carros4.data.repositories.ClienteRepository;
import br.com.sevencomm.carros4.domain.models.Cliente;
import br.com.sevencomm.carros4.domain.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository _clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        _clienteRepository = clienteRepository;
    }

    public List<Cliente> listClientes() {
        return _clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);

        if(cliente.isPresent()){
            return cliente.get();
        } else {
            throw new IllegalArgumentException("Cliente not found!");
        }
    }

    public Cliente createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        if((clienteDTO.getNome()==null) || clienteDTO.getNome().equals("")){
            throw new IllegalArgumentException("Cliente field is empty!");
        }

        cliente.setNome(clienteDTO.getNome());

        return _clienteRepository.save(cliente);
    }

    public Cliente updateCliente(ClienteDTO clienteDTO, Long id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);
        if(cliente.isPresent()){
            if((clienteDTO.getNome()==null) || clienteDTO.getNome().equals("")){
                throw new IllegalArgumentException("Cliente field is empty!");
            }
            Cliente updateCliente = cliente.get();
            updateCliente.setNome(clienteDTO.getNome());
            return _clienteRepository.save(updateCliente);
        }else {
            throw new IllegalArgumentException("Cliente not found!");
        }
    }

    public Cliente deleteCliente(Long id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);
        if(cliente.isPresent()){
            _clienteRepository.delete(cliente.get());
            return cliente.get();
        }else {
            throw new IllegalArgumentException("Cliente not found!");
        }
    }
}
