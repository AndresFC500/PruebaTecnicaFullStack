package com.PruebaTecnica.PruebaTecnica.Repository;

import com.PruebaTecnica.PruebaTecnica.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}