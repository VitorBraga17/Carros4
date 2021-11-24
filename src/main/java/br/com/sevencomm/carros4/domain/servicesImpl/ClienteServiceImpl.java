package br.com.sevencomm.carros4.domain.servicesImpl;

import br.com.sevencomm.carros4.api.DTOs.ClienteDTO;
import br.com.sevencomm.carros4.data.repositories.ClienteRepository;
import br.com.sevencomm.carros4.domain.models.Cliente;
import br.com.sevencomm.carros4.domain.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository _clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        _clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> listClientes() {
        List<Cliente> clientes = _clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for(Cliente c : clientes){
            ClienteDTO clienteDTO = ClienteDTO.toDTO(c);
            clientesDTO.add(clienteDTO);
        }
        return clientesDTO;
    }

    public ClienteDTO getClienteById(Long id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);

        if(cliente.isPresent()){
            ClienteDTO clienteDTO = ClienteDTO.toDTO(cliente.get());
            return clienteDTO;
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
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());

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
            updateCliente.setEmail(clienteDTO.getEmail());
            updateCliente.setTelefone(clienteDTO.getTelefone());
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
