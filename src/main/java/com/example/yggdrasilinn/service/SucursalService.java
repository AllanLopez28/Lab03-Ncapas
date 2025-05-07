package com.example.yggdrasilinn.service;

import com.example.yggdrasilinn.model.Sucursal;

import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<Sucursal> listarTodos();
    Optional<Sucursal> buscarPorId(Long id);
    Sucursal crear(Sucursal sucursal);
    Sucursal actualizar(Long id, Sucursal sucursal);
    void eliminar(Long id);
}
