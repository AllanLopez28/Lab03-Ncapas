package com.example.yggdrasilinn.controller;

import com.example.yggdrasilinn.model.ColorBoton;
import com.example.yggdrasilinn.service.ColorBotonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color-boton")
public class ColorBotonController {
    private final ColorBotonService service;

    public ColorBotonController(ColorBotonService service) {
        this.service = service;
    }

    @GetMapping
    public List<ColorBoton> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColorBoton> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ColorBoton crear(@RequestBody ColorBoton cb) {
        return service.crear(cb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColorBoton> actualizar(@PathVariable Long id,
                                                  @RequestBody ColorBoton cb) {
        try {
            return ResponseEntity.ok(service.actualizar(id, cb));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
