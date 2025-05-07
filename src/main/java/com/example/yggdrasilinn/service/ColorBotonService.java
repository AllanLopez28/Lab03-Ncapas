package com.example.yggdrasilinn.service;

import com.example.yggdrasilinn.model.ColorBoton;

import java.util.List;
import java.util.Optional;

//metodos para el color de boton
public interface ColorBotonService {
    List<ColorBoton> listarTodos();
    Optional<ColorBoton> buscarPorId(Long id);
    ColorBoton crear(ColorBoton cb);
    ColorBoton actualizar(Long id, ColorBoton cb);
    void eliminar(Long id);
}
