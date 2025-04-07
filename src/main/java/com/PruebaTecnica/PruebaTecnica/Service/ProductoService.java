package com.PruebaTecnica.PruebaTecnica.Service;

import com.PruebaTecnica.PruebaTecnica.Model.Producto;
import com.PruebaTecnica.PruebaTecnica.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto actualizar(Long id, Producto producto) {
        Producto existente = obtenerPorId(id);
        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> listar(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }
}