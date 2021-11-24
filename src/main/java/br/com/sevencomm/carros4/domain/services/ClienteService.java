package br.com.sevencomm.carros4.domain.services;

import br.com.sevencomm.carros4.api.DTOs.ClienteDTO;
import br.com.sevencomm.carros4.domain.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listClientes();
    ClienteDTO getClienteById(Long id);
    Cliente createCliente(ClienteDTO clienteDTO);
    Cliente updateCliente(ClienteDTO clienteDTO,Long id);
    Cliente deleteCliente(Long id);

}
