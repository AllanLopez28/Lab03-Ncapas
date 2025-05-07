package com.example.yggdrasilinn.service.impl;

import com.example.yggdrasilinn.model.Sucursal;
import com.example.yggdrasilinn.repository.SucursalRepository;
import com.example.yggdrasilinn.service.SucursalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {
    private final SucursalRepository repo;

    public SucursalServiceImpl(SucursalRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Sucursal> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Sucursal> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Sucursal crear(Sucursal sucursal) {
        return repo.save(sucursal);
    }

    @Override
    public Sucursal actualizar(Long id, Sucursal sucursal) {
        return repo.findById(id)
            .map(existing -> {
                existing.setNombre(sucursal.getNombre());
                existing.setUbicacion(sucursal.getUbicacion());
                return repo.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con id " + id));
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
