package com.example.demo_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.service.ProveedorService;

@RestController
@RequestMapping
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping 
    public List<Proveedor> listar(){
        return proveedorService.listarTodos();
    }

    @PostMapping 
    public ResponseEntity<?> crear(@RequestBody Proveedor proveedor){
        try {
            Proveedor nuevoProveerdor = proveedorService.guardar(proveedor);
            return ResponseEntity.ok(nuevoProveerdor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Proveedor> buscar(@RequestParam String nombre){
        return ProveedorService.buscarPorNombre(nombre);
    }

}
