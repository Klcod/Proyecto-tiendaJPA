package com.example.tiendajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tiendajpa.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

}
