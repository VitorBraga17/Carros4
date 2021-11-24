package br.com.sevencomm.carros4.domain.services;

import br.com.sevencomm.carros4.domain.models.Registro;

import java.util.List;

public interface RegistroService {

    List<Registro> listRegistros();
    Registro createRegistro(Registro registro);
    Registro updateRegistro(Registro registro,Long id);
    Registro deleteRegistro(Long id);

}
