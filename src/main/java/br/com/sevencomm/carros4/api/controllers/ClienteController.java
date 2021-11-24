package br.com.sevencomm.carros4.api.controllers;

import br.com.sevencomm.carros4.api.DTOs.ClienteDTO;
import br.com.sevencomm.carros4.domain.models.Cliente;
import br.com.sevencomm.carros4.domain.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService _clienteService;

    public ClienteController(ClienteService clienteService) {
        _clienteService = clienteService;

    }

    @GetMapping("/listClientes")
    public ResponseEntity listClientes() {
        List<ClienteDTO> clientes = _clienteService.listClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/getClienteById")
    public ResponseEntity findClienteById(Long id) {
        ClienteDTO cliente = _clienteService.getClienteById(id);
        try {
            return ResponseEntity.ok(cliente);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/createCliente")
    public ResponseEntity createCliente(@RequestBody ClienteDTO ClienteDTO){
        Cliente cliente = _clienteService.createCliente(ClienteDTO);
        try{
            return ResponseEntity.ok(cliente);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/updateCliente")
    public ResponseEntity updateCliente(@RequestBody ClienteDTO clienteDTO,@RequestParam Long id){
        Cliente cliente = _clienteService.updateCliente(clienteDTO,id);
        try{
            return ResponseEntity.ok(cliente);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteCliente")
    public ResponseEntity deleteCliente(@RequestParam Long id){
        Cliente cliente = _clienteService.deleteCliente(id);
        try{
            return ResponseEntity.ok(cliente);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


}
