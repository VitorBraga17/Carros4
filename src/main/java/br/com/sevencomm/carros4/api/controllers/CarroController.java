package br.com.sevencomm.carros4.api.controllers;

import br.com.sevencomm.carros4.api.DTOs.CarroDTO;
import br.com.sevencomm.carros4.domain.models.Carro;
import br.com.sevencomm.carros4.domain.services.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private CarroService _carroService;

    public CarroController(CarroService carroService) {
        _carroService = carroService;
    }

    @GetMapping("/listCarros")
    public ResponseEntity listCarros() {
        List<CarroDTO> carro = _carroService.listCarros();
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/getCarroById")
    public ResponseEntity findCarroById(@RequestParam Long id) {
        CarroDTO carro = _carroService.getCarroById(id);

        try {
            return ResponseEntity.ok(carro);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/createCarro")
    public ResponseEntity createCarro(@RequestBody CarroDTO carroDTO) {
        Carro carro = _carroService.createCarro(carroDTO);
        try {
            return ResponseEntity.ok(carro);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/updateCarro")
    public ResponseEntity updateCarro(@RequestBody CarroDTO carroDTO, @RequestParam Long id) {
        Carro carro = _carroService.updateCarro(carroDTO, id);
        try {
            return ResponseEntity.ok(carro);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/deleteCarro")
    public ResponseEntity DeleteCarro(@RequestParam Long id){
        Carro carro = _carroService.deleteCarro(id);
        try{
            return ResponseEntity.ok(carro);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/park")
    public ResponseEntity park(@RequestParam Long id){
        Carro carro = _carroService.entradaCarro(id);
        try {
            return ResponseEntity.ok("The car " + carro.getModelo() + " parked successfully.");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/depart")
    public ResponseEntity depart(@RequestParam Long id) {
        Carro carro = _carroService.saidaCarro(id);
        try {
            return ResponseEntity.ok("The car " + carro.getModelo() + " departed successfully.");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
