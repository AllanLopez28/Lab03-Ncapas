package com.example.yggdrasilinn.service.impl;

import com.example.yggdrasilinn.model.ColorBoton;
import com.example.yggdrasilinn.repository.ColorBotonRepository;
import com.example.yggdrasilinn.service.ColorBotonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ColorBotonServiceImpl implements ColorBotonService {
    private final ColorBotonRepository repo;

    public ColorBotonServiceImpl(ColorBotonRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ColorBoton> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<ColorBoton> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public ColorBoton crear(ColorBoton cb) {
        return repo.save(cb);
    }

    @Override
    public ColorBoton actualizar(Long id, ColorBoton cb) {
        return repo.findById(id)
            .map(existing -> {
                existing.setNombreColor(cb.getNombreColor());
                return repo.save(existing);
            }).orElseThrow(() -> new RuntimeException("ColorBoton no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
