package com.example.demo_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;  // Fixed: removed invalid 'class'

    public List<Proveedor> listarTodos(){
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor){
        if (proveedor.getTelefono() == null || proveedor.getTelefono().length() != 10) {
            throw new RuntimeException("Lógica de Negocio: El número de teléfono debe tener 10 dígitos.");
        }
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> buscarPorNombre(String nombre) {  // Removed static
        return proveedorRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
